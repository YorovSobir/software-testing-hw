package ru.spbau.mit.issue;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IssueHeader {
    private WebElement issueHeaderElement;
    private WebElement dashBoard;
    private WebElement issues;
    private WebElement issuesDropDown;
    private WebElement agileBoards;

    private WebElement reports;
    private WebElement createIssue;
    private WebElement createIssueDropDown;
    private WebElement user;
    private WebElement settings;
    private WebElement help;

    public IssueHeader(WebElement issueHeaderElement) {
        this.issueHeaderElement = issueHeaderElement;
        init();
    }

    private void init() {
        dashBoard = issueHeaderElement.findElement(By.cssSelector("a[href$='dashboard']"));
        issues = issueHeaderElement.findElement(By.cssSelector("a[href$='issues']"));
        issuesDropDown = issueHeaderElement.findElement(By.cssSelector("span.ring-dropdown-toggle:nth-child(4)"));
        agileBoards = issueHeaderElement.findElement(By.cssSelector("a[href$='agile']"));
        reports = issueHeaderElement.findElement(By.cssSelector("a[href$='reports']"));
        try {
            createIssue = issueHeaderElement.findElement(By.cssSelector("a[title='Create Issue']"));
            createIssueDropDown = issueHeaderElement.findElement(By.cssSelector("span.ring-dropdown-toggle:nth-child(8)"));
        } catch (NoSuchElementException e) {
            // it means that we are guest
        }
        user = issueHeaderElement.findElement(By.cssSelector("div.ring-menu__right > a.ring-link:nth-child(2)"));
        if (createIssue != null) {
            settings = issueHeaderElement.findElement(By.cssSelector("div.ring-menu__right > a.ring-link:nth-child(3)"));
        }
        help = issueHeaderElement.findElement(By.cssSelector("div.ring-menu__right > a.ring-link:nth-child(4)"));
    }

    public WebElement getDashBoard() {
        return dashBoard;
    }

    public WebElement getIssues() {
        return issues;
    }

    public WebElement getIssuesDropDown() {
        return issuesDropDown;
    }

    public WebElement getAgileBoards() {
        return agileBoards;
    }

    public WebElement getReports() {
        return reports;
    }

    public WebElement getCreateIssue() {
        return createIssue;
    }

    public WebElement getCreateIssueDropDown() {
        return createIssueDropDown;
    }

    public WebElement getUser() {
        return user;
    }

    public WebElement getSettings() {
        return settings;
    }

    public WebElement getHelp() {
        return help;
    }
}

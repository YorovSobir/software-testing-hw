package ru.spbau.mit.issue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.spbau.mit.login.LogIn;

public class Issue {
    private WebDriver webDriver;
    private IssueHeader issueHeader;
    private IssueSearch issueSearch;
    private IssueBody issueBody;

    public Issue(WebDriver webDriver) {
        this.webDriver = webDriver;
        new LogIn(webDriver).defaultLogIn();
        webDriver.get("http://localhost:8080/issues");
        init();
    }

    private void init() {
        issueHeader = new IssueHeader(webDriver.findElement(By.id("id_l.I.h.header")));
        issueSearch = new IssueSearch(webDriver.findElement(By.id("id_l.I.sp.searchPanel")));
        issueBody = new IssueBody(webDriver.findElement(By.cssSelector("div[class='content content__issue-list']")));
    }

    public IssueHeader getIssueHeader() {
        return issueHeader;
    }

    public IssueSearch getIssueSearch() {
        return issueSearch;
    }

    public IssueBody getIssueBody() {
        return issueBody;
    }

    public static void main(String[] args) {
        //simple run
        System.setProperty("webdriver.gecko.driver", "/usr/local/lib/geckodriver");
        WebDriver webDriver = new FirefoxDriver();
        Issue issue = new Issue(webDriver);
        IssueBody issueBody = issue.getIssueBody();
        System.out.println(issueBody.getIssueContent()
                .getIssueContainer().getIssue(1)
                .getIssueInfo().getIssueId().getText());
    }

}

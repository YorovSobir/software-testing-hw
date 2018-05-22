package ru.spbau.mit.issue.content.toolbar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BottomToolBar {
    private WebElement bottomToolBarElement;
    private WebElement foundedIssueCount;
    private WebElement issuesPerPage;

    public BottomToolBar(WebElement bottomToolBarElement) {
        this.bottomToolBarElement = bottomToolBarElement;
        init();
    }

    private void init() {
        foundedIssueCount = bottomToolBarElement.findElement(By.cssSelector("div:nth-child(1) > div:nth-child(1) > div:nth-child(1)"));
        issuesPerPage = bottomToolBarElement.findElement(By.cssSelector("#id_l\\.I\\.c\\.bb\\.issuesPerPage"));
    }

    public WebElement getFoundedIssueCount() {
        return foundedIssueCount;
    }

    public WebElement getIssuesPerPage() {
        return issuesPerPage;
    }
}


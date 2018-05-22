package ru.spbau.mit.issue.content;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class IssueContainer {

    private WebElement issueContainerElement;
    private List<WebElement> issues;

    public IssueContainer(WebElement issueContainerElement) {
        this.issueContainerElement = issueContainerElement;
        init();
    }

    private void init() {
        issues = issueContainerElement.findElements(By.cssSelector("div.issueContainer"));
    }

    public int getIssueCount() {
        return issues.size();
    }

    public IssueItem getIssue(int index) {
        return new IssueItem(issues.get(index));
    }
}

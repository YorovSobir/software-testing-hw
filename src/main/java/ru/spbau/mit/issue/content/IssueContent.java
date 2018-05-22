package ru.spbau.mit.issue.content;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.spbau.mit.issue.content.toolbar.BottomToolBar;
import ru.spbau.mit.issue.content.toolbar.TopToolBar;

public class IssueContent {

    private final WebElement issueContentElement;
    private TopToolBar topToolBar;
    private IssueContainer issueContainer;
    private BottomToolBar bottomToolBar;

    public IssueContent(WebElement issueContentElement) {
        this.issueContentElement = issueContentElement;
        init();
    }

    private void init() {
        topToolBar = new TopToolBar(issueContentElement.findElement(By.id("id_l.I.c.tb.topToolbar")));
        issueContainer = new IssueContainer(issueContentElement.findElement(By.id("id_l.I.c.il.issueList")));
        bottomToolBar = new BottomToolBar(issueContentElement.findElement(By.id("id_l.I.c.bb.bottomToolbar")));
    }

    public TopToolBar getTopToolBar() {
        return topToolBar;
    }

    public IssueContainer getIssueContainer() {
        return issueContainer;
    }

    public BottomToolBar getBottomToolBar() {
        return bottomToolBar;
    }
}


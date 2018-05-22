package ru.spbau.mit.issue.content.toolbar;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class TopToolBar {
    private WebElement toolBarElement;
    private WebElement treeView;
    private WebElement oneLineView;
    private WebElement compactView;
    private WebElement detailedView;
    private WebElement printIssue;
    private WebElement viewSettings;

    private WebElement selectAll;
    private WebElement assignMenu;
    private WebElement addComment;
    private WebElement addFileMenu;
    private WebElement addLinkMenu;
    private WebElement addTag;
    private WebElement commandMenu;

    public TopToolBar(WebElement toolBarElement) {
        this.toolBarElement = toolBarElement;
        init();
    }

    private void init() {
        treeView = toolBarElement.findElement(By.id("id_l.I.c.tb.showHierarchy"));
        oneLineView = toolBarElement.findElement(By.id("id_l.I.c.tb.detailLevelLink_9_0"));
        compactView = toolBarElement.findElement(By.id("id_l.I.c.tb.detailLevelLink_9_1"));
        detailedView = toolBarElement.findElement(By.id("id_l.I.c.tb.detailLevelLink_9_2"));
        printIssue = toolBarElement.findElement(By.id("id_l.I.c.tb.printIssues"));
        viewSettings = toolBarElement.findElement(By.id("id_l.I.c.tb.viewSettings"));

        try {
            selectAll = toolBarElement.findElement(By.id("id_l.I.c.tb.selectAllCheckbox"));
            assignMenu = toolBarElement.findElement(By.id("id_l.I.c.tb.c.assignMenu"));
            addComment = toolBarElement.findElement(By.id("id_l.I.c.tb.c.addCommentCommandItem_comment"));
            addFileMenu = toolBarElement.findElement(By.id("id_l.I.c.tb.c.afm.addFileMenu"));
            addLinkMenu = toolBarElement.findElement(By.id("id_l.I.c.tb.c.addLinkMenu"));
            addTag = toolBarElement.findElement(By.cssSelector("#id_l\\.I\\.c\\.tb\\.c\\.commandItem_add\\ tag\\ _1"));
            commandMenu = toolBarElement.findElement(By.id("id_l.I.c.tb.c.commandMenu"));
        } catch (NoSuchElementException e) {
            // guest user cannot change issue
        }
    }


    public WebElement getTreeView() {
        return treeView;
    }

    public WebElement getOneLineView() {
        return oneLineView;
    }

    public WebElement getCompactView() {
        return compactView;
    }

    public WebElement getDetailedView() {
        return detailedView;
    }

    public WebElement getPrintIssue() {
        return printIssue;
    }

    public WebElement getViewSettings() {
        return viewSettings;
    }

    public WebElement getSelectAll() {
        return selectAll;
    }

    public WebElement getAssignMenu() {
        return assignMenu;
    }

    public WebElement getAddComment() {
        return addComment;
    }

    public WebElement getAddFileMenu() {
        return addFileMenu;
    }

    public WebElement getAddLinkMenu() {
        return addLinkMenu;
    }

    public WebElement getAddTag() {
        return addTag;
    }

    public WebElement getCommandMenu() {
        return commandMenu;
    }
}


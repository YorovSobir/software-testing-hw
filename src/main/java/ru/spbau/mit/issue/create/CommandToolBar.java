package ru.spbau.mit.issue.create;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CommandToolBar {
    private WebElement commandToolBarElement;
    private WebElement assignMenu;
    private WebElement addComment;
    private WebElement addFileMenu;
    private WebElement addLinkMenu;
    private WebElement addTag;
    private WebElement commandMenu;

    public CommandToolBar(WebElement commandToolBarElement) {
        this.commandToolBarElement = commandToolBarElement;
        init();
    }

    private void init() {
        assignMenu = commandToolBarElement.findElement(By.id("id_l.I.ni.t.assignMenu"));
        addComment = commandToolBarElement.findElement(By.id("id_l.I.ni.t.addCommentCommandItem_comment"));
        addFileMenu = commandToolBarElement.findElement(By.id("id_l.I.ni.t.afm.addFileMenu"));
        addLinkMenu = commandToolBarElement.findElement(By.id("id_l.I.ni.t.addLinkMenu"));
        addTag = commandToolBarElement.findElement(By.cssSelector("#id_l\\.I\\.ni\\.t\\.commandItem_add\\ tag\\ _1"));
        commandMenu = commandToolBarElement.findElement(By.id("id_l.I.ni.t.commandMenu"));
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



package ru.spbau.mit.issue.create;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SubContent {
    private WebElement rootElement;
    private WebElement project;
    private WebElement priority;
    private WebElement type;
    private WebElement state;
    private WebElement assignee;
    private WebElement subSystem;
    private WebElement fixVersions;
    private WebElement affectedVersions;
    private WebElement fixedInBuild;

    public SubContent(WebElement rootElement) {
        this.rootElement = rootElement;
        init();
    }

    private void init() {
        project = rootElement.findElement(
                By.cssSelector("table.fsi-properties > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(2) > div")
        );
        priority = rootElement.findElement(
                By.cssSelector("table.fsi-properties > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2) > div")
        );
        type = rootElement.findElement(
                By.cssSelector("table.fsi-properties > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(2) > div")
        );
        state = rootElement.findElement(
                By.cssSelector("table.fsi-properties > tbody:nth-child(1) > tr:nth-child(5) > td:nth-child(2) > div")
        );
        assignee = rootElement.findElement(
                By.cssSelector("table.fsi-properties > tbody:nth-child(1) > tr:nth-child(6) > td:nth-child(2) > div")
        );
        subSystem = rootElement.findElement(
                By.cssSelector("table.fsi-properties > tbody:nth-child(1) > tr:nth-child(7) > td:nth-child(2) > div")
        );
        fixVersions = rootElement.findElement(
                By.cssSelector("table.fsi-properties > tbody:nth-child(1) > tr:nth-child(8) > td:nth-child(2) > div")
        );
        affectedVersions = rootElement.findElement(
                By.cssSelector("table.fsi-properties > tbody:nth-child(1) > tr:nth-child(9) > td:nth-child(2) > div")
        );
        fixedInBuild = rootElement.findElement(
                By.cssSelector("table.fsi-properties > tbody:nth-child(1) > tr:nth-child(10) > td:nth-child(2) > div")
        );
    }


    public WebElement getProject() {
        return project;
    }

    public WebElement getPriority() {
        return priority;
    }

    public WebElement getType() {
        return type;
    }

    public WebElement getState() {
        return state;
    }

    public WebElement getAssignee() {
        return assignee;
    }

    public WebElement getSubSystem() {
        return subSystem;
    }

    public WebElement getFixVersions() {
        return fixVersions;
    }

    public WebElement getAffectedVersions() {
        return affectedVersions;
    }

    public WebElement getFixedInBuild() {
        return fixedInBuild;
    }

}

package ru.spbau.mit.issue.create;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class NewIssueContainer {
    private WebElement rootElement;
    private WebElement project;
    private WebElement summary;
    private WebElement description;
    private WebElement similarIssues;
    private WebElement similarToggler;
    private WebElement togglePreview;
    private WebElement fileUpload;
    private WebElement addFileMenu;
    private WebElement visibilityContent;
    private WebElement generateIssueTemplateUrl;
    private WebElement submitButton;
    private WebElement cancelButton;

    public NewIssueContainer(WebElement rootElement) {
        this.rootElement = rootElement;
        init();
    }

    private void init() {
        project = rootElement.findElement(By.id("id_l.I.ni.ei.eit.project"));
        summary = rootElement.findElement(By.id("id_l.I.ni.ei.eit.summary"));
        description = rootElement.findElement(By.id("id_l.I.ni.ei.eit.description"));
        similarIssues = rootElement.findElement(By.id("id_l.I.ni.ei.sip.ip.ip"));
        similarToggler = rootElement.findElement(By.id("id_l.I.ni.ei.sip.toggler"));
        togglePreview = rootElement.findElement(By.id("id_l.I.ni.ei.ip.togglePreview"));
        fileUpload = rootElement.findElement(By.id("id_l.I.ni.ei.atch.fileUploadBtn"));
        addFileMenu = rootElement.findElement(By.id("id_l.I.ni.ei.atch.AddFileMenu.addFileMenu"));
        visibilityContent = rootElement.findElement(By.id("id_l.I.ni.ei.iv.visibilityContent"));
        generateIssueTemplateUrl = rootElement.findElement(By.id("id_l.I.ni.ei.chageIssueTemplateURLVisibility"));
        submitButton = rootElement.findElement(By.id("id_l.I.ni.ei.submitButton_74_4"));
        cancelButton = rootElement.findElement(By.id("id_l.I.ni.ei.cancelButton_74_4"));
    }

    public WebElement getProject() {
        return project;
    }

    public WebElement getSummary() {
        return summary;
    }

    public WebElement getDescription() {
        return description;
    }

    public WebElement getSimilarIssues() {
        return similarIssues;
    }

    public WebElement getSimilarToggler() {
        return similarToggler;
    }

    public WebElement getTogglePreview() {
        return togglePreview;
    }

    public WebElement getFileUpload() {
        return fileUpload;
    }

    public WebElement getAddFileMenu() {
        return addFileMenu;
    }

    public WebElement getVisibilityContent() {
        return visibilityContent;
    }

    public WebElement getGenerateIssueTemplateUrl() {
        return generateIssueTemplateUrl;
    }

    public WebElement getSubmitButton() {
        return submitButton;
    }

    public WebElement getCancelButton() {
        return cancelButton;
    }

}

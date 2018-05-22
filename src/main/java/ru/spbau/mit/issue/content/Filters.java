package ru.spbau.mit.issue.content;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Filters {
    private WebElement issueContentFiltersElement;
    private WebElement projects;
    private WebElement tags;
    private WebElement savedSearches;
    private WebElement filters;

    public Filters(WebElement issueContentFiltersElement) {
        this.issueContentFiltersElement = issueContentFiltersElement;
        init();
    }

    private void init() {
        projects = issueContentFiltersElement.findElement(By.id("id_l.I.sb.s.psb.watchFoldersSideBar"));
        tags = issueContentFiltersElement.findElement(By.id("id_l.I.sb.s.tsb.watchFoldersSideBar"));
        savedSearches = issueContentFiltersElement.findElement(By.id("id_l.I.sb.s.sqsb.watchFoldersSideBar"));
        filters = issueContentFiltersElement.findElement(By.id("id_l.I.sb.fb.filtersSideBar"));
    }

    public WebElement getProjects() {
        return projects;
    }

    public WebElement getTags() {
        return tags;
    }

    public WebElement getSavedSearches() {
        return savedSearches;
    }

    public WebElement getFilters() {
        return filters;
    }
}

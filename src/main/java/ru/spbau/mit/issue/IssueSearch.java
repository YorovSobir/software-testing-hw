package ru.spbau.mit.issue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IssueSearch {
    private WebElement issueSearchElement;
    private WebElement filterFolder;
    private WebElement putQuery;
    private WebElement searchButton;
    private WebElement clearSearchLink;
    private WebElement searchField;

    public IssueSearch(WebElement issueSearchElement) {
        this.issueSearchElement = issueSearchElement;
        init();
    }

    private void init() {
        filterFolder = issueSearchElement.findElement(By.id("id_l.I.sp.filterFolder"));
        putQuery = issueSearchElement.findElement(By.id("id_l.I.sp.putQuery"));
        searchButton = issueSearchElement.findElement(By.id("id_l.I.sp.searchSubmit"));
        clearSearchLink = issueSearchElement.findElement(By.id("id_l.I.sp.clearSearchLink"));
        searchField = issueSearchElement.findElement(By.id("id_l.I.sp.searchField"));
    }

    public WebElement getFilterFolder() {
        return filterFolder;
    }

    public WebElement getPutQuery() {
        return putQuery;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getClearSearchLink() {
        return clearSearchLink;
    }

    public WebElement getSearchField() {
        return searchField;
    }
}

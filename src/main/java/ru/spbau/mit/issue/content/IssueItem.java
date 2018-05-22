package ru.spbau.mit.issue.content;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public class IssueItem {
    public static class LastUpdate {
        private WebElement lastUpdateElement;
        private WebElement reportedBy;
        private WebElement updateTime;

        public LastUpdate(WebElement lastUpdateElement) {
            this.lastUpdateElement = lastUpdateElement;
            init();
        }

        private void init() {
            reportedBy = lastUpdateElement.findElement(By.cssSelector("span[title^='Reported by']"));
            updateTime = lastUpdateElement.findElement(By.cssSelector("div.update-date"));
        }

        public WebElement getReportedBy() {
            return reportedBy;
        }

        public WebElement getUpdateTime() {
            return updateTime;
        }
    }

    public static class IssueInfo {
        private WebElement issueInfoElement;
        private WebElement issueId;
        private WebElement issueSummary;

        public IssueInfo(WebElement issueInfoElement) {
            this.issueInfoElement = issueInfoElement;
            init();
        }

        private void init() {
            issueId = issueInfoElement.findElement(By.cssSelector("a.issueId"));
            issueSummary = issueInfoElement.findElement(By.cssSelector("a.issue-summary"));
        }

        public WebElement getIssueId() {
            return issueId;
        }

        public WebElement getIssueSummary() {
            return issueSummary;
        }
    }

    public static class IssueActions {
        private WebElement issueActionsElement;
        private WebElement addComment;
        private WebElement vote;

        public IssueActions(WebElement issueActionsElement) {
            this.issueActionsElement = issueActionsElement;
            init();
        }

        private void init() {
            addComment = issueActionsElement.findElement(By.cssSelector("div.toggleCommentsAnchor"));
            try {
                vote = issueActionsElement.findElement(By.cssSelector("a.poller"));
            } catch (NoSuchElementException e) {
                // cannot vote if we owner of this issue
            }
        }

        public WebElement getAddComment() {
            return addComment;
        }

        public WebElement getVote() {
            return vote;
        }
    }

    public static class Properties {

        private WebElement propertiesElement;
        private WebElement priority;
        private WebElement type;
        private WebElement state;
        private WebElement assignee;
        private WebElement subsystem;
        private WebElement fixVersion;
        private WebElement affectedVersion;

        public Properties(WebElement propertiesElement) {
            this.propertiesElement = propertiesElement;
            init();
        }

        private void init() {
            priority = propertiesElement.findElement(By.cssSelector("a[title^='Priority']"));
            type = propertiesElement.findElement(By.cssSelector("a[title^='Type']"));
            state = propertiesElement.findElement(By.cssSelector("a[title^='State']"));
            assignee = propertiesElement.findElement(By.cssSelector("a[title^='Assignee']"));
            subsystem = propertiesElement.findElement(By.cssSelector("a[title^='Subsystem']"));
            fixVersion = propertiesElement.findElement(By.cssSelector("a[title^='Fix versions']"));
            affectedVersion = propertiesElement.findElement(By.cssSelector("a[title^='Affected versions']"));
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

        public WebElement getSubsystem() {
            return subsystem;
        }

        public WebElement getFixVersion() {
            return fixVersion;
        }

        public WebElement getAffectedVersion() {
            return affectedVersion;
        }
    }

    private WebElement issue;
    private LastUpdate lastUpdate;
    private IssueInfo issueInfo;
    private Properties properties;
    private IssueActions issueActions;
    private WebElement checkBox;
    private WebElement star;

    public IssueItem(WebElement issue) {
        this.issue = issue;
        init();
    }

    private void init() {
        lastUpdate = new LastUpdate(
                issue.findElement(By.cssSelector("table:nth-child(1) > tbody:nth-child(1) > " +
                        "tr:nth-child(1) > td.issue-details > div.issue-last-update"))
        );
        issueInfo = new IssueInfo(
                issue.findElement(By.cssSelector("table:nth-child(1) > tbody:nth-child(1) > " +
                        "tr:nth-child(1) > td.issue-details > div.issue-info"))
        );
        properties = new Properties(
                issue.findElement(By.cssSelector("div.dtbl > div.properties-container > " +
                        "div.properties"))
        );
        issueActions = new IssueActions(issue.findElement(By.cssSelector("div.issue-actions")));
        try {
            checkBox = issue.findElement(By.cssSelector(".jt-input"));
            star = issue.findElement(By.cssSelector(".star-issues"));
        } catch (NoSuchElementException e) {
            //it means that we are not root
        }
    }

    public LastUpdate getLastUpdate() {
        return lastUpdate;
    }

    public IssueInfo getIssueInfo() {
        return issueInfo;
    }

    public Properties getProperties() {
        return properties;
    }

    public IssueActions getIssueActions() {
        return issueActions;
    }

    public WebElement getCheckBox() {
        return checkBox;
    }

    public WebElement getStar() {
        return star;
    }
}

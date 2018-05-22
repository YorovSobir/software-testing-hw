package ru.spbau.mit.issue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.spbau.mit.issue.content.Filters;
import ru.spbau.mit.issue.content.IssueContent;

public class IssueBody {
    private WebElement issueBodyElement;
    private Filters filters;
    private IssueContent issueContent;

    public IssueBody(WebElement issueBodyElement) {
        this.issueBodyElement = issueBodyElement;
        init();
    }

    private void init() {
        filters = new Filters(issueBodyElement.findElement(By.id("id_l.I.sb.filters_div")));
        issueContent = new IssueContent(issueBodyElement.findElement(By.id("id_l.I.c.issuesContent")));
    }

    public Filters getFilters() {
        return filters;
    }

    public IssueContent getIssueContent() {
        return issueContent;
    }
}

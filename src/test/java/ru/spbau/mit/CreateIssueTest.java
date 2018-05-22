package ru.spbau.mit;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.spbau.mit.issue.Issue;
import ru.spbau.mit.issue.content.IssueContainer;
import ru.spbau.mit.issue.content.IssueItem;
import ru.spbau.mit.issue.create.Creator;

public class CreateIssueTest {

    private static WebDriver webDriver = new FirefoxDriver();

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.gecko.driver", "/usr/local/lib/geckodriver");
    }

    @Test
    public void testEmptySummary() {
        Creator creator = new Creator(webDriver);
        creator.getNewIssueContainer().getSummary().sendKeys("");
        creator.getNewIssueContainer().getDescription().sendKeys("someDescription");
        creator.getNewIssueContainer().getSubmitButton().click();
        WebElement errorElement = (new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[id^='__popup__'][class='message error']")));

        Assert.assertTrue(errorElement.getText().contains("Summary is required"));
    }

    @Test
    public void testEmptyDescription() {
        Creator creator = new Creator(webDriver);
        creator.getNewIssueContainer().getSummary().sendKeys("some summary");
        creator.getNewIssueContainer().getDescription().sendKeys("");
        creator.getNewIssueContainer().getSubmitButton().click();
        // after this line we must be in page issue
        Assert.assertTrue(webDriver.getCurrentUrl().startsWith("http://localhost:8080/issues"));
        WebElement successElement = webDriver.findElement(By.cssSelector("div[id^='__popup__']"));
        Assert.assertTrue(successElement.getText().contains("Issue"));
        Assert.assertTrue(successElement.getText().contains("was reported"));
    }

    @Test
    public void testCreateIssueSuccess() {
        String expectedSummary = "expected summary";
        String expectedDesc = "expected description";
        Creator creator = new Creator(webDriver);
        creator.getNewIssueContainer().getSummary().sendKeys(expectedSummary);
        creator.getNewIssueContainer().getDescription().sendKeys(expectedDesc);
        creator.getNewIssueContainer().getSubmitButton().click();
        // after this line we must be in page issue
        Assert.assertTrue(webDriver.getCurrentUrl().startsWith("http://localhost:8080/issues"));
        Issue issue = new Issue(webDriver);
        IssueContainer issueContainer = issue.getIssueBody().getIssueContent().getIssueContainer();
        boolean founded = false;
        for (int i = 0; i < issueContainer.getIssueCount(); ++i) {
            IssueItem issueItem = issueContainer.getIssue(i);
            if (issueItem.getIssueInfo().getIssueSummary().getText().equals(expectedSummary)) {
                founded = true;
            }
        }
        Assert.assertTrue(founded);
    }

    @Test
    public void testCreateIssueFailed() {
        Issue beforeIssue = new Issue(webDriver);
        String issueBeforeCount = beforeIssue.getIssueBody()
                .getIssueContent()
                .getBottomToolBar()
                .getFoundedIssueCount()
                .getText();
        Creator creator = new Creator(webDriver);
        creator.getNewIssueContainer().getSummary().sendKeys("");
        creator.getNewIssueContainer().getDescription().sendKeys("");
        creator.getNewIssueContainer().getSubmitButton().click();

        Issue afterIssue = new Issue(webDriver);
        String issueAfterCount = afterIssue.getIssueBody()
                .getIssueContent()
                .getBottomToolBar()
                .getFoundedIssueCount()
                .getText();
        Assert.assertEquals(issueBeforeCount, issueAfterCount);
    }
}

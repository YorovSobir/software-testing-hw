package ru.spbau.mit.issue.create;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.spbau.mit.issue.IssueHeader;
import ru.spbau.mit.login.LogIn;

public class Creator {
    private WebDriver webDriver;
    private IssueHeader issueHeader;
    private CommandToolBar commandToolBar;
    private NewIssueContainer newIssueContainer;
    private SubContent subContent;

    public Creator(WebDriver webDriver) {
        this.webDriver = webDriver;
        new LogIn(webDriver).defaultLogIn();
        webDriver.get("http://localhost:8080/issues#newissue=yes");
        init();
    }

    private void init() {
        issueHeader = new IssueHeader(webDriver.findElement(By.id("id_l.I.h.header")));
        WebElement commandToolBarElement = (new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("id_l.I.ni.commandToolbar")));
        commandToolBar = new CommandToolBar(commandToolBarElement);
        newIssueContainer = new NewIssueContainer(webDriver.findElement(By.id("id_l.I.ni.ei.issueEditContainer")));
        subContent = new SubContent(webDriver.findElement(By.id("id_l.I.ni.s.subContent")));
    }

    public IssueHeader getIssueHeader() {
        return issueHeader;
    }

    public CommandToolBar getCommandToolBar() {
        return commandToolBar;
    }

    public NewIssueContainer getNewIssueContainer() {
        return newIssueContainer;
    }

    public SubContent getSubContent() {
        return subContent;
    }

    /*
      method for creating new issue
     */
    public static void createIssue(String summary, String description) {
        System.setProperty("webdriver.gecko.driver", "/usr/local/lib/geckodriver");
        WebDriver webDriver = new FirefoxDriver();
        Creator creator = new Creator(webDriver);
        creator.getNewIssueContainer().getSummary().sendKeys(summary);
        creator.getNewIssueContainer().getDescription().sendKeys(description);
        creator.getNewIssueContainer().getSubmitButton().click();
    }

    public static void main(String[] args) {
        createIssue("issue", "test issue");
    }
}

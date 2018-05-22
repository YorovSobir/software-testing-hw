package ru.spbau.mit.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LogIn {
    private WebDriver webDriver;

    public LogIn(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void defaultLogIn() {
        if (!register("user", "user@mail.ru", "user", "user")) {
            logIn("user", "user");
        }
    }

    private boolean logIn(String login, String password) {
        String loginUrl = "http://localhost:8080/login";
        webDriver.get(loginUrl);
        webDriver.findElement(By.id("id_l.L.login")).sendKeys(login);
        webDriver.findElement(By.id("id_l.L.password")).sendKeys(password);
        webDriver.findElement(By.id("id_l.L.loginButton")).click();
        if (webDriver.getCurrentUrl().equals(loginUrl)) {
            return false;
        }
        return true;
    }

    private boolean register(String fullName, String email, String login, String password) {
        String registerUrl = "http://localhost:8080/registerUserForm";
        webDriver.get(registerUrl);
        webDriver.findElement(By.id("id_l.R.user_fullName")).sendKeys(fullName);
        webDriver.findElement(By.id("id_l.R.user_email")).sendKeys(email);
        webDriver.findElement(By.id("id_l.R.user_login")).sendKeys(login);
        webDriver.findElement(By.id("id_l.R.password")).sendKeys(password);
        webDriver.findElement(By.id("id_l.R.confirmPassword")).sendKeys(password);
        webDriver.findElement(By.id("id_l.R.register")).click();
        if (webDriver.getCurrentUrl().equals(registerUrl)) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "/usr/local/lib/geckodriver");
        new LogIn(new FirefoxDriver()).defaultLogIn();
    }
}

package sakhaulov;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestSteps {

    public static void authorize (WebDriver driver, String login, String password) {
        new WebDriverWait(driver, Duration.ofSeconds(7))
                .until(ExpectedConditions.urlContains("id.atlassian.com/login"));

        LogInPage logInPage = new LogInPage(driver);

        logInPage
                .clickUsername()
                .enterUsername(login)
                .clickSubmit()
                .clickPassword()
                .enterPassword(password)
                .clickSubmit();
    }
}

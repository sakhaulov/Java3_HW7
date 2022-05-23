package sakhaulov.Atlassian.AtlassianPages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends AbstractPage {

    @FindBy(id = "username")
    private WebElement username;

    @FindBy(id = "login-submit")
    private WebElement submit;

    @FindBy(id = "password")
    private WebElement password;

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @Step("Кликнуть на поле 'Имя пользователя'")
    public LogInPage clickUsername() {
        username.click();
        return this;
    }

    @Step("Ввести имя пользователя")
    public LogInPage enterUsername(String input) {
        username.sendKeys(input);
        return this;
    }

    @Step("Кликнуть на поле 'Пароль'")
    public LogInPage clickPassword() {
        password.click();
        return this;
    }

    @Step("Ввести пароль")
    public LogInPage enterPassword(String input) {
        password.sendKeys(input);
        return this;
    }

    @Step("Кликнуть на кнопку 'Отправить'")
    public LogInPage clickSubmit() {
        submit.click();
        return this;
    }

}

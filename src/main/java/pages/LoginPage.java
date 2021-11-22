package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Waiters;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final By USERNAME_INPUT = By.xpath("//*[@id='user-name']");
    private static final By PASSWORD_INPUT = By.xpath("//*[@id='password']");
    private static final By LOGIN_BUTTON = By.xpath("//*[@id='login-button']");
    private static final By BOT_LOGO = By.xpath("//*[@class='bot_column']");
    private static final By USERNAME_ERROR_MESSAGE = By.xpath("//*[contains(text(), 'Epic sadface: Username is required')]");
    private static final By PASSWORD_ERROR_MESSAGE = By.xpath("//*[contains(text(), 'Epic sadface: Password is required')]");
    private static final By LOCKED_OUT_USER_ERROR_MESSAGE = By.xpath("//*[contains(text(), 'Epic sadface: Sorry, this user has been locked out.')]");
    private static final By INVALID_DATE_ERROR_MESSAGE = By.xpath("//*[contains(text(), 'Epic sadface: Username and password do not match any user in this service')]");

    public String getUsernameErrorMessage() {
        return driver.findElement(USERNAME_ERROR_MESSAGE).getText();
    }

    public String getPasswordErrorMessage() {
        return driver.findElement(PASSWORD_ERROR_MESSAGE).getText();
    }

    public String getLockedOutUserErrorMessage() {
        return driver.findElement(LOCKED_OUT_USER_ERROR_MESSAGE).getText();
    }

    public String getInvalidDataErrorMessage() {
        return driver.findElement(INVALID_DATE_ERROR_MESSAGE).getText();
    }

    @Step("Log in as '{username}' with '{password}'")
    public ProductsPage loginUsingValidData(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductsPage(driver);
    }

    @Step("Log in as '{username}' with '{password}' using invalid data")
    public LoginPage loginUsingInvalidData(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    public void waitForPageOpened() {
        Waiters.waitForElementLocated(driver, BOT_LOGO, 10);
    }

    public LoginPage openPage() {
        openPage(BASE_URL);
        waitForPageOpened();
        return this;
    }
}

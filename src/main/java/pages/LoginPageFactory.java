package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageFactory extends BasePage {

    public LoginPageFactory(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id='user-name']")
    WebElement userNameInput;
    @FindBy(xpath = "//*[@id='password']")
    WebElement passwordInput;
    @FindBy(xpath = "//*[@id='login-button']")
    WebElement loginButton;
    @FindBy(xpath = "//*[@class='bot_column']")
    WebElement botLogo;
    @FindBy(xpath = "//*[contains(text(), 'Epic sadface: Username is required')]")
    WebElement usernameErrorMessage;
    @FindBy(xpath = "//*[contains(text(), 'Epic sadface: Password is required')]")
    WebElement passwordErrorMessage;
    @FindBy(xpath = "//*[contains(text(), 'Epic sadface: Sorry, this user has been locked out.')]")
    WebElement lockedOutUserErrorMessage;
    @FindBy(xpath = "//*[contains(text(), 'Epic sadface: Username and password do not match any user in this service')]")
    WebElement invalidDateErrorMessage;

    public String getUsernameErrorMessage() {
        return usernameErrorMessage.getText();
    }

    public String getPasswordErrorMessage() {
        return passwordErrorMessage.getText();
    }

    public String getLockedOutUserErrorMessage() {
        return lockedOutUserErrorMessage.getText();
    }

    public String getInvalidDataErrorMessage() {
        return invalidDateErrorMessage.getText();
    }

    public ProductsPage login(String username, String password) {
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new ProductsPage(driver);
    }

    public LoginPageFactory openPage() {
        openPage(BASE_URL);
        return this;
    }
}

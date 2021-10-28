package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private static final By FIRST_NAME = By.xpath("//*[@id='first-name']");
    private static final By LAST_NAME = By.xpath("//*[@id='last-name']");
    private static final By ZIP_CODE = By.xpath("//*[@id='postal-code']");
    private static final By CONTINUE_BUTTON = By.xpath("//*[@id='continue']");

    private static final By CANCEL_BUTTON_ON_CHECKOUT_INFO = By.xpath("//*[@id='cancel']/ancestor::*[@class='checkout_buttons']//button");
    private static final By CANCEL_BUTTON_ON_CHECKOUT_OVERVIEW = By.xpath("//*[@id='cancel']/ancestor::*[@class='cart_footer']//button");
    private static final String RETURN_TO_CART_URL = "https://www.saucedemo.com/cart.html";
    private static final By FINISH_BUTTON = By.xpath("//*[@id='finish']");

    private static final By COMPLETE_HEADER = By.xpath("//*[text() = 'THANK YOU FOR YOUR ORDER']");
    private static final By COMPLETE_TEXT = By.xpath("//*[text() = 'Your order has been dispatched, and will arrive just as fast as the pony can get there!']");
    private static final By IMAGE_ON_CHECKOUT_COMPLETE = By.className("pony_express");
    private static final By BACK_HOME_BUTTON = By.id("back-to-products");

    public String getCompleteHeaderAfterCheckout() {
        return driver.findElement(COMPLETE_HEADER).getText();
    }

    public String getCompleteTextAfterCheckout() {
        return driver.findElement(COMPLETE_TEXT).getText();
    }

    public boolean isImageOnCheckoutCompleteDisplayed() {
        return driver.findElement(IMAGE_ON_CHECKOUT_COMPLETE).isDisplayed();
    }

    public void fillInCheckoutInfo(String firstname, String lastName, String zipCode) {
        driver.findElement(FIRST_NAME).sendKeys(firstname);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(ZIP_CODE).sendKeys(zipCode);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void finishCheckout() {
        driver.findElement(FINISH_BUTTON).click();
    }

    public void clickOnBackHomeButton() {
        driver.findElement(BACK_HOME_BUTTON).click();
    }

    public void clickOnCancelButtonOnCheckoutInfoPage() {
        driver.findElement(CANCEL_BUTTON_ON_CHECKOUT_INFO).click();
    }

    public void clickOnCancelButtonOnCheckoutOverviewPage() {
        driver.findElement(CANCEL_BUTTON_ON_CHECKOUT_OVERVIEW).click();
    }

    public String getReturnToCartUrl() {
        return RETURN_TO_CART_URL;
    }
}

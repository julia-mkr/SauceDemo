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
    private static final By CANCEL_BUTTON = By.xpath("//*[@id='cancel']/ancestor::*[@class='checkout_buttons']//button");
    private static final By CANCEL_BUTTON_ON_CHECKOUT_OVERVIEW = By.xpath("//*[@id='cancel']/ancestor::*[@class='cart_footer']//button");
    private static final By FINISH_BUTTON = By.xpath("//*[@id='finish']");

    public void fillInCheckoutInfo(String firstname, String lastName, String zipCode) {
        driver.findElement(FIRST_NAME).sendKeys(firstname);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(ZIP_CODE).sendKeys(zipCode);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void finishCheckout() {
        driver.findElement(FINISH_BUTTON).click();
    }
}

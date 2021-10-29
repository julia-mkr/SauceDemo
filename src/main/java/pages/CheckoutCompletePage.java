package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends BasePage {

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    private static final By COMPLETE_HEADER_TEXT = By.xpath("//*[text() = 'THANK YOU FOR YOUR ORDER']");
    private static final By COMPLETE_TEXT = By.xpath("//*[text() = 'Your order has been dispatched, and will arrive just as fast as the pony can get there!']");
    private static final By IMAGE_ON_CHECKOUT_COMPLETE = By.className("pony_express");
    private static final By BACK_HOME_BUTTON = By.id("back-to-products");

    public String getCompleteHeaderText() {
        return driver.findElement(COMPLETE_HEADER_TEXT).getText();
    }

    public String getCompleteText() {
        return driver.findElement(COMPLETE_TEXT).getText();
    }

    public boolean isImageOnCheckoutCompleteDisplayed() {
        return driver.findElement(IMAGE_ON_CHECKOUT_COMPLETE).isDisplayed();
    }

    public void clickOnBackHomeButton() {
        driver.findElement(BACK_HOME_BUTTON).click();
    }
}

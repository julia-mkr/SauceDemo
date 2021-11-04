package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepTwoPage extends BasePage{

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    private static final By CANCEL_BUTTON_ON_CHECKOUT_STEP_TWO = By.xpath("//*[@id='cancel']/ancestor::*[@class='cart_footer']//button");
    private static final By FINISH_BUTTON = By.xpath("//*[@id='finish']");

    public ProductsPage clickOnCancelButtonOnCheckoutStepTwo() {
        driver.findElement(CANCEL_BUTTON_ON_CHECKOUT_STEP_TWO).click();
        return new ProductsPage(driver);
    }

    public CheckoutCompletePage clickOnFinishButton() {
        driver.findElement(FINISH_BUTTON).click();
        return new CheckoutCompletePage(driver);
    }
}

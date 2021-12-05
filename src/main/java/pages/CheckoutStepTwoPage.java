package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CheckoutStepTwoPage extends BasePage{

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    private static final By CANCEL_BUTTON_ON_CHECKOUT_STEP_TWO = By.xpath("//*[@id='cancel']/ancestor::*[@class='cart_footer']//button");
    private static final By FINISH_BUTTON = By.xpath("//*[@id='finish']");

    @Step("Click on the Cancel button on the Checkout Step two page")
    public ProductsPage clickOnCancelButtonOnCheckoutStepTwo() {
        log.info("Click on the 'Cancel' button on the 'Checkout Step Two' page");
        driver.findElement(CANCEL_BUTTON_ON_CHECKOUT_STEP_TWO).click();
        return new ProductsPage(driver);
    }

    @Step("Click on the Finish button")
    public CheckoutCompletePage clickOnFinishButton() {
        log.info("Click on the 'Finish' button on the 'Checkout Step Two' page");
        driver.findElement(FINISH_BUTTON).click();
        return new CheckoutCompletePage(driver);
    }
}


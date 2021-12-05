package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CheckoutStepOnePage extends BasePage{

    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    private static final By FIRST_NAME_INPUT = By.xpath("//*[@id='first-name']");
    private static final By LAST_NAME_INPUT = By.xpath("//*[@id='last-name']");
    private static final By ZIP_CODE_INPUT = By.xpath("//*[@id='postal-code']");
    private static final By CONTINUE_BUTTON = By.xpath("//*[@id='continue']");
    private static final By CANCEL_BUTTON_ON_CHECKOUT_STEP_ONE = By.xpath("//*[@id='cancel']/ancestor::*[@class='checkout_buttons']//button");

    @Step("Fill in all fields on the checkout info page with First name: '{firstname}', Last name: '{lastName}', " +
            "Zip Code: '{zipCode}'")
    public CheckoutStepTwoPage fillInCheckoutInfo(String firstname, String lastName, String zipCode) {
        log.info(String.format("Type first name: '%s' on 'Checkout Info' page", firstname));
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstname);
        log.info(String.format("Type second name: '%s'", lastName));
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        log.info(String.format("Type zip code: '%s'", zipCode));
        driver.findElement(ZIP_CODE_INPUT).sendKeys(zipCode);
        log.info("Click on the 'Continue' button");
        driver.findElement(CONTINUE_BUTTON).click();
        return new CheckoutStepTwoPage(driver);
    }

    @Step("Click on the 'Cancel Button' on Checkout Step One page")
    public CartPage clickOnCancelButtonOnCheckoutStepOnePage() {
        log.info("Click on the 'Cancel' button on the 'Checkout Step One' page");
        driver.findElement(CANCEL_BUTTON_ON_CHECKOUT_STEP_ONE).click();
        return new CartPage(driver);
    }
}

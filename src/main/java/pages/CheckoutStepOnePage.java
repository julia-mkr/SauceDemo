package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepOnePage extends BasePage{

    public CheckoutStepOnePage(WebDriver driver) {
        super(driver);
    }

    private static final By FIRST_NAME_INPUT = By.xpath("//*[@id='first-name']");
    private static final By LAST_NAME_INPUT = By.xpath("//*[@id='last-name']");
    private static final By ZIP_CODE_INPUT = By.xpath("//*[@id='postal-code']");
    private static final By CONTINUE_BUTTON = By.xpath("//*[@id='continue']");
    private static final By CANCEL_BUTTON_ON_CHECKOUT_STEP_ONE = By.xpath("//*[@id='cancel']/ancestor::*[@class='checkout_buttons']//button");

    @Step("Fill in all fields on the checkout info page")
    public CheckoutStepTwoPage fillInCheckoutInfo(String firstname, String lastName, String zipCode) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstname);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        driver.findElement(ZIP_CODE_INPUT).sendKeys(zipCode);
        driver.findElement(CONTINUE_BUTTON).click();
        return new CheckoutStepTwoPage(driver);
    }

    @Step("Click on the Cancel Button on Chekout Step One page")
    public CartPage clickOnCancelButtonOnCheckoutStepOnePage() {
        driver.findElement(CANCEL_BUTTON_ON_CHECKOUT_STEP_ONE).click();
        return new CartPage(driver);
    }
}

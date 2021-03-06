package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Waiters;

@Log4j2
public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private static final String PRODUCT_PRICE = "//*[text()='%s']/ancestor::*[@class='cart_item']//*[@class='inventory_item_price']";
    private static final By CHECKOUT_BUTTON = By.xpath("//*[@id='checkout']");
    private static final String REMOVE_BUTTON = "//*[text()='%s']/ancestor::*[@class='cart_item']//button";
    private static final By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");

    public String getProductPrice(String productName) {
        log.info("Get price from product: " + productName);
        String productPrice = driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
        log.info("Price is: " + productPrice);
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    public boolean isRemoveButtonAbsent() {
        return driver.findElements(By.xpath("//*[contains(text(),'Remove')]")).size() < 1;
    }

    @Step("Click on the Checkout button")
    public CheckoutStepOnePage clickOnCheckoutButton() {
        log.info("Click on the 'Checkout' button");
        driver.findElement(CHECKOUT_BUTTON).click();
        return new CheckoutStepOnePage(driver);
    }

    @Step("Click on the Remove button")
    public CartPage clickOnRemoveButton(String productName) {
        log.info("Click on the 'Remove' button");
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON, productName))).click();
        return this;
    }

    @Step("Click on the Continue Shopping button")
    public ProductsPage clickOnContinueShoppingButton() {
        log.info("Click on the 'Continue Shopping' button");
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
        return new ProductsPage(driver);
    }

    public void waitForPageOpened() {
        Waiters.waitForElementLocated(driver, CHECKOUT_BUTTON, 10);
    }

    public CartPage openPage() {
        openPage(BASE_URL + CART_URL);
        waitForPageOpened();
        return this;
    }
}

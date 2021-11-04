package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private static final String PRODUCT_PRICE = "//*[text()='%s']/ancestor::*[@class='cart_item']//*[@class='inventory_item_price']";
    private static final By CHECKOUT_BUTTON = By.xpath("//*[@id='checkout']");
    private static final String REMOVE_BUTTON = "//*[text()='%s']/ancestor::*[@class='cart_item']//button";
    private static final By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");
    private static final String CART_URL = "/cart.html";

    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    public CheckoutStepOnePage clickOnCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
        return new CheckoutStepOnePage(driver);
    }

    public CartPage clickOnRemoveButton(String productName) {
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON, productName))).click();
        return this;
    }

    public ProductsPage clickOnContinueShoppingButton() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
        return new ProductsPage(driver);
    }

    public void waitForPageOpened() {
        waitForElementLocated(CHECKOUT_BUTTON, 10);
    }

    public CartPage openPage() {
        openPage(BASE_URL + CART_URL);
        waitForPageOpened();
        return this;
    }
}

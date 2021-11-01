package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private static final String PRODUCT_PRICE = "//*[text()='%s']/ancestor::*[@class='cart_item']//*[@class='inventory_item_price']";
    private static final By CHECKOUT_BUTTON = By.xpath("//*[@id='checkout']");
    private static final String REMOVE_BUTTON = "//*[text()='%s']/ancestor::*[@class='cart_item']//button";
    private static final By CONTINUE_SHOPPING_BUTTON = By.id("continue-shopping");

    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    public void clickOnCheckoutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public void clickOnRemoveButton(String productName) {
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON, productName))).click();
    }

    public void clickOnContinueShoppingButton() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

    public int getAmountOfRemoveButtons() {
        List<WebElement> removeButtonsList = driver.findElements(By.xpath("//*[contains(text(),'Remove')]"));
        return removeButtonsList.size();
    }
}

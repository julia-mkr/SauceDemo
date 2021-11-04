package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductsPage extends BasePage{

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private static final String ADD_PRODUCT_TO_CART_BUTTON = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";
    private static final String REMOVE_BUTTON = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";
    private static final String INVENTORY_URL = "/inventory.html";

    public ProductsPage addProductToCart(String productName) {
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
        return this;
    }

    public ProductsPage removeItemFromCartOnProductsPage(String productName) {
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON, productName))).click();
        return this;
    }

    public void waitForPageOpened(int timeout) {
        wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(@id, '_img_link')]")));
    }

    public ProductsPage openPage() {
        openPage(BASE_URL + INVENTORY_URL);
        waitForPageOpened(10);
        return this;
    }
}

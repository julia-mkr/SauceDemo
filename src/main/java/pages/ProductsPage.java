package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class ProductsPage extends BasePage{

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private static final String ADD_PRODUCT_TO_CART_BUTTON = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";
    private static final String REMOVE_BUTTON = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";
    private static final By PRODUCT_SORT_DROPDOWN = By.cssSelector(".product_sort_container");

    @Step("Add a product: '{productName}' to the cart")
    public ProductsPage addProductToCart(String productName) {
        log.info("Add " + productName + " to the cart on the 'Product' page");
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
        return this;
    }

    @Step("Remove a product: '{productName}' from the cart on the product page")
    public ProductsPage removeItemFromCartOnProductsPage(String productName) {
        log.info("Remove " + productName + " from the cart on the 'Product' page");
        driver.findElement(By.xpath(String.format(REMOVE_BUTTON, productName))).click();
        return this;
    }

    public boolean isRemoveButtonAbsent() {
        return driver.findElements(By.xpath("//*[contains(text(),'Remove')]")).size() < 1;
    }

    public boolean isProductSortDropdownDisplayed() {
        return driver.findElement(PRODUCT_SORT_DROPDOWN).isDisplayed();
    }
}

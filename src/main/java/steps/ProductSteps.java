package steps;

import org.openqa.selenium.WebDriver;
import pages.*;

public class ProductSteps {

    private LoginPage loginPage;
    private ProductsPage productsPage;

    public ProductSteps(WebDriver driver) {
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
    }

    public ProductSteps loginAndAddProductToCart(String username, String password, String productName) {
        loginPage.openPage()
                .loginUsingValidData(username, password)
                .addProductToCart(productName);
        return this;
    }


}

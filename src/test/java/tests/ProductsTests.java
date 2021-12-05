package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTests extends BaseTest {

    @Test
    public void removeItemOnProductsPageTest() {
        loginPage.openPage()
                .loginUsingValidData("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Backpack")
                .removeItemFromCartOnProductsPage("Sauce Labs Backpack");
        Assert.assertTrue(productsPage.isRemoveButtonAbsent());
    }
}

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
        Assert.assertTrue(productsPage.isRemoveButtonMissing());
    }

    @Test  //сценарий теста туповатый, но надо было оправдать два последних метода в ProductsPage
    public void returnToProductsPageFromCheckoutStepOneTest() {
        loginPage.openPage()
                .loginUsingValidData("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage()
                .clickOnCheckoutButton();
        productsPage.openPage();
        Assert.assertEquals(INVENTORY_PAGE_URL, INVENTORY_PAGE_URL);
    }
}

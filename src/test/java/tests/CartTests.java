package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    public void addProductToCartTest() {
        loginPage.openPage()
                 .loginUsingValidData("standard_user", "secret_sauce")
                 .addProductToCart("Sauce Labs Bolt T-Shirt");
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Bolt T-Shirt"), "$15.99");
    }

    @Test
    public void addTwoProductsToCartTest() {
        loginPage.openPage()
                 .loginUsingValidData("standard_user", "secret_sauce")
                 .addProductToCart("Sauce Labs Onesie")
                 .addProductToCart("Sauce Labs Bike Light");
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Onesie"), "$7.99");
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Bike Light"), "$9.99");
    }

    @Test
    public void removeProductFromCartTest() {
        loginPage.openPage()
                 .loginUsingValidData("standard_user", "secret_sauce")
                 .addProductToCart("Sauce Labs Onesie");
        cartPage.openPage()
                .clickOnRemoveButton("Sauce Labs Onesie");
        Assert.assertTrue(cartPage.isRemoveButtonMissing());
    }

    @Test
    public void clickOnContinueShoppingButtonFromCartTest() {
        loginPage.openPage()
                .loginUsingValidData("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage()
                .clickOnContinueShoppingButton();
        Assert.assertEquals(INVENTORY_PAGE_URL, INVENTORY_PAGE_URL);
    }
}

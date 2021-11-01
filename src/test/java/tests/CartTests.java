package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @Test
    public void addProductToCartTest() {
        loginPage.openPage(SAUCEDEMO_PAGE_URL);
        loginPage.login("standard_user", "secret_sauce");
        loginPage.clickOnLoginButton();
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        productsPage.openPage(CART_PAGE_URL);
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Bolt T-Shirt"), "$15.99");
    }

    @Test
    public void addTwoProductsToCartTest() {
        loginPage.openPage(SAUCEDEMO_PAGE_URL);
        loginPage.login("standard_user", "secret_sauce");
        loginPage.clickOnLoginButton();
        productsPage.addProductToCart("Sauce Labs Onesie");
        productsPage.addProductToCart("Sauce Labs Bike Light");
        productsPage.openPage(CART_PAGE_URL);
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Onesie"), "$7.99");
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Bike Light"), "$9.99");
    }

    @Test
    public void removeProductFromCartTest() {
        loginPage.openPage(SAUCEDEMO_PAGE_URL);
        loginPage.login("standard_user", "secret_sauce");
        loginPage.clickOnLoginButton();
        productsPage.addProductToCart("Sauce Labs Onesie");
        productsPage.openPage(CART_PAGE_URL);
        cartPage.clickOnRemoveButton("Sauce Labs Onesie");
        Assert.assertTrue(cartPage.getAmountOfRemoveButtons() < 1);
    }
}

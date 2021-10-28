package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {

    @Test
    public void checkoutTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage("https://www.saucedemo.com/cart.html");
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillInCheckoutInfo("Michael", "Scott", "888555");
        checkoutPage.finishCheckout();
        Assert.assertEquals(checkoutPage.getCompleteHeaderAfterCheckout(), "THANK YOU FOR YOUR ORDER");
        Assert.assertEquals(checkoutPage.getCompleteTextAfterCheckout(), "Your order has been dispatched, " +
                                                            "and will arrive just as fast as the pony can get there!");
        Assert.assertTrue(checkoutPage.isImageOnCheckoutCompleteDisplayed());
    }

    @Test
    public void checkoutAndReturnToHomepageTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Test.allTheThings() T-Shirt (Red)");
        cartPage.openPage("https://www.saucedemo.com/cart.html");
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillInCheckoutInfo("Joe", "Smith", "235622");
        checkoutPage.finishCheckout();
        checkoutPage.clickOnBackHomeButton();
        Assert.assertEquals(productsPage.getInventoryPageUrl(), driver.getCurrentUrl());
    }

    @Test
    public void proceedToCheckoutAndCancelOnCheckoutInfoPageTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage("https://www.saucedemo.com/cart.html");
        cartPage.clickOnCheckoutButton();
        checkoutPage.clickOnCancelButtonOnCheckoutInfoPage();
        Assert.assertEquals(checkoutPage.getReturnToCartUrl(), driver.getCurrentUrl());
    }

    @Test
    public void proceedToCheckoutAndCancelOnCheckoutOverviewPageTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Test.allTheThings() T-Shirt (Red)");
        cartPage.openPage("https://www.saucedemo.com/cart.html");
        cartPage.clickOnCheckoutButton();
        checkoutPage.fillInCheckoutInfo("Joe", "Smith", "235622");
        checkoutPage.clickOnCancelButtonOnCheckoutOverviewPage();
        Assert.assertEquals(productsPage.getInventoryPageUrl(), driver.getCurrentUrl());
    }
}

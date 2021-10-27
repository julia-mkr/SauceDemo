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
}

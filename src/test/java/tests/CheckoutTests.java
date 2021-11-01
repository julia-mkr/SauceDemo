package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {

    @Test
    public void checkoutTest() {
        loginPage.openPage(SAUCEDEMO_PAGE_URL);
        loginPage.login("standard_user", "secret_sauce");
        loginPage.clickOnLoginButton();
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage(CART_PAGE_URL);
        cartPage.clickOnCheckoutButton();
        checkoutStepOne.fillInCheckoutInfo("Michael", "Scott", "888555");
        checkoutStepOne.clickOnContinueButton();
        checkoutStepTwo.clickOnFinishButton();
        Assert.assertEquals(checkoutComplete.getCompleteHeaderText(), "THANK YOU FOR YOUR ORDER");
        Assert.assertEquals(checkoutComplete.getCompleteText(), "Your order has been dispatched, " +
                                                            "and will arrive just as fast as the pony can get there!");
        Assert.assertTrue(checkoutComplete.isImageOnCheckoutCompleteDisplayed());
    }

    @Test
    public void checkoutAndReturnToHomepageTest() {
        loginPage.openPage(SAUCEDEMO_PAGE_URL);
        loginPage.login("standard_user", "secret_sauce");
        loginPage.clickOnLoginButton();
        productsPage.addProductToCart("Test.allTheThings() T-Shirt (Red)");
        cartPage.openPage(CART_PAGE_URL);
        cartPage.clickOnCheckoutButton();
        checkoutStepOne.fillInCheckoutInfo("Joe", "Smith", "235622");
        checkoutStepOne.clickOnContinueButton();
        checkoutStepTwo.clickOnFinishButton();
        checkoutComplete.clickOnBackHomeButton();
        Assert.assertEquals(INVENTORY_PAGE_URL, "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void proceedToCheckoutAndCancelOnCheckoutStepOnePageTest() {
        loginPage.openPage(SAUCEDEMO_PAGE_URL);
        loginPage.login("standard_user", "secret_sauce");
        loginPage.clickOnLoginButton();
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage(CART_PAGE_URL);
        cartPage.clickOnCheckoutButton();
        checkoutStepOne.clickOnCancelButtonOnCheckoutStepOnePage();
        Assert.assertEquals(CART_PAGE_URL, "https://www.saucedemo.com/cart.html");
    }

    @Test
    public void proceedToCheckoutAndCancelOnCheckoutStepTwoPageTest() {
        loginPage.openPage(SAUCEDEMO_PAGE_URL);
        loginPage.login("standard_user", "secret_sauce");
        loginPage.clickOnLoginButton();
        productsPage.addProductToCart("Test.allTheThings() T-Shirt (Red)");
        cartPage.openPage(CART_PAGE_URL);
        cartPage.clickOnCheckoutButton();
        checkoutStepOne.fillInCheckoutInfo("Joe", "Smith", "235622");
        checkoutStepOne.clickOnContinueButton();
        checkoutStepTwo.clickOnCancelButtonOnCheckoutStepTwo();
        Assert.assertEquals(INVENTORY_PAGE_URL, "https://www.saucedemo.com/inventory.html");
    }
}

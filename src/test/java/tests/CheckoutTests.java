package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTest {

    @Test
    public void checkoutTest() {
        loginPage.openPage()
                 .loginUsingValidData("standard_user", "secret_sauce")
                 .addProductToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage()
                .clickOnCheckoutButton()
                .fillInCheckoutInfo("Michael", "Scott", "888555")
                .clickOnFinishButton();
        Assert.assertEquals(checkoutComplete.getCompleteHeaderText(), "THANK YOU FOR YOUR ORDER");
        Assert.assertEquals(checkoutComplete.getCompleteText(), "Your order has been dispatched, " +
                                                            "and will arrive just as fast as the pony can get there!");
        Assert.assertTrue(checkoutComplete.isImageOnCheckoutCompleteDisplayed());
    }

    @Test
    public void checkoutAndReturnToHomepageTest() {
        loginPage.openPage()
                 .loginUsingValidData("standard_user", "secret_sauce")
                 .addProductToCart("Test.allTheThings() T-Shirt (Red)");
        cartPage.openPage()
                .clickOnCheckoutButton()
                .fillInCheckoutInfo("Joe", "Smith", "235622")
                .clickOnFinishButton();
        checkoutComplete.clickOnBackHomeButton();
        Assert.assertEquals(checkoutComplete.getCurrentUrl(), INVENTORY_PAGE_URL);
    }

    @Test
    public void proceedToCheckoutAndCancelOnCheckoutStepOnePageTest() {
        loginPage.openPage()
                 .loginUsingValidData("standard_user", "secret_sauce")
                 .addProductToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage()
                .clickOnCheckoutButton()
                .clickOnCancelButtonOnCheckoutStepOnePage();
        Assert.assertEquals(checkoutStepOne.getCurrentUrl(), CART_PAGE_URL);
    }

    @Test
    public void proceedToCheckoutAndCancelOnCheckoutStepTwoPageTest() {
        loginPage.openPage()
                 .loginUsingValidData("standard_user", "secret_sauce")
                 .addProductToCart("Test.allTheThings() T-Shirt (Red)");
        cartPage.openPage()
                .clickOnCheckoutButton()
                .fillInCheckoutInfo("Joe", "Smith", "235622")
                .clickOnCancelButtonOnCheckoutStepTwo();
        Assert.assertEquals(checkoutStepTwo.getCurrentUrl(), INVENTORY_PAGE_URL);
    }
}

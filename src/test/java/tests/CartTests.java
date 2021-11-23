package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @Test(retryAnalyzer = Retry.class)
    @Description("Add a product to cart")
    public void addProductToCartTest() {
        productSteps.loginAndAddProductToCart("standard_user", "secret_sauce", "Sauce Labs Onesie");
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Bolt T-Shirt"), "$15.99");
    }

    @Test
    public void addTwoProductsToCartTest() {
        loginPage.openPage()
                 .loginUsingValidData(System.getenv("username"), System.getenv("password"))
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
        Assert.assertEquals(cartPage.getCurrentUrl(), INVENTORY_PAGE_URL);
        Assert.assertTrue(productsPage.isProductSortDropdownDisplayed());
    }
}

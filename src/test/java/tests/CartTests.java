package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @Test
    public void addProductToCartTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        productsPage.openPage("https://www.saucedemo.com/cart.html");
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Bolt T-Shirt"), "$15.99");
    }

    @Test
    public void addTwoProductsToCartTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Onesie");
        productsPage.addProductToCart("Sauce Labs Bike Light");
        productsPage.openPage("https://www.saucedemo.com/cart.html");
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Onesie"), "$7.99");
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Bike Light"), "$9.99");
    }

    @Test
    public void removeProductFromCartTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Onesie");
        productsPage.openPage("https://www.saucedemo.com/cart.html");
        cartPage.removeItemFromCart("Sauce Labs Onesie");
        // как сделать Assert, если корзина пуста - я не знаю, так как никакого текста при пустой корзине нет,
        // а в коде меняется только класс div-a c "cart-item" на "removed_cart_item"
    }
}

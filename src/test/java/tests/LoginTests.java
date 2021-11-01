package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loginUsingValidDataTest() {
        loginPage.openPage(SAUCEDEMO_PAGE_URL);
        loginPage.login("standard_user", "secret_sauce");
        loginPage.clickOnLoginButton();
        Assert.assertEquals(INVENTORY_PAGE_URL, "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void loginWithoutEnteringUsernameTest() {
        loginPage.openPage(SAUCEDEMO_PAGE_URL);
        loginPage.login("", "secret_sauce");
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getUsernameErrorMessage(), "Epic sadface: Username is required");
    }

    @Test
    public void loginWithoutEnteringPasswordTest() {
        loginPage.openPage(SAUCEDEMO_PAGE_URL);
        loginPage.login("standard_user", "");
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getPasswordErrorMessage(), "Epic sadface: Password is required");
    }

    @Test
    public void loginAsLockedOutUserTest() {
        loginPage.openPage(SAUCEDEMO_PAGE_URL);
        loginPage.login("locked_out_user", "secret_sauce");
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getLockedOutUserErrorMessage(), "Epic sadface: Sorry, " +
                                                                              "this user has been locked out.");
    }

    @Test
    public void loginWithInvalidDateTest() {
        loginPage.openPage(SAUCEDEMO_PAGE_URL);
        loginPage.login("Brian", "123456789");
        loginPage.clickOnLoginButton();
        Assert.assertEquals(loginPage.getInvalidDataErrorMessage(), "Epic sadface: Username and password " +
                                                                            "do not match any user in this service");
    }
}

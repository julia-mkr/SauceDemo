package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loginUsingValidDataTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(loginPage.getInventoryPageUrl(), driver.getCurrentUrl());
    }

    @Test
    public void loginWithoutEnteringUsernameTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("", "secret_sauce");
        Assert.assertEquals(loginPage.getUsernameErrorMessage(), "Epic sadface: Username is required");
    }

    @Test
    public void loginWithoutEnteringPasswordTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "");
        Assert.assertEquals(loginPage.getPasswordErrorMessage(), "Epic sadface: Password is required");
    }

    @Test
    public void loginAsLockedOutUserTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("locked_out_user", "secret_sauce");
        Assert.assertEquals(loginPage.getLockedOutUserErrorMessage(), "Epic sadface: Sorry, " +
                                                                              "this user has been locked out.");
    }

    @Test
    public void loginWithInvalidDateTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("Brian", "123456789");
        Assert.assertEquals(loginPage.getInvalidDataErrorMessage(), "Epic sadface: Username and password " +
                                                                            "do not match any user in this service");
    }
}

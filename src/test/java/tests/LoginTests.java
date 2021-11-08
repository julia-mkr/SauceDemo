package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @DataProvider(name = "User data")
    public Object[][] userData() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"standard_user", ""},
                {"", "secret_sauce"},
        };
    }

    @Test(dataProvider = "User data")
    public void loginUsingValidDataTest(String username, String password) {
        loginPage.openPage()
                 .loginUsingValidData(username, password);
        Assert.assertEquals(INVENTORY_PAGE_URL, INVENTORY_PAGE_URL);
    }

    @Test
    public void loginThroughLoginPageFactoryClassTest() {
        loginPageFactory.openPage()
                .login("standard_user", "secret_sauce");
        Assert.assertEquals(INVENTORY_PAGE_URL, INVENTORY_PAGE_URL);
    }

    @Test
    public void loginWithoutEnteringUsernameTest() {
        loginPage.openPage()
                 .loginUsingInvalidData("", "secret_sauce");
        Assert.assertEquals(loginPage.getUsernameErrorMessage(), "Epic sadface: Username is required");
    }

    @Test
    public void loginWithoutEnteringPasswordTest() {
        loginPage.openPage()
                 .loginUsingInvalidData("standard_user", "");
        Assert.assertEquals(loginPage.getPasswordErrorMessage(), "Epic sadface: Password is required");
    }

    @Test
    public void loginAsLockedOutUserTest() {
        loginPage.openPage()
                 .loginUsingInvalidData("locked_out_user", "secret_sauce");
        Assert.assertEquals(loginPage.getLockedOutUserErrorMessage(), "Epic sadface: Sorry, " +
                                                                              "this user has been locked out.");
    }

    @Test
    public void loginWithInvalidDateTest() {
        loginPage.openPage()
                 .loginUsingInvalidData("Brian", "123456789");
        Assert.assertEquals(loginPage.getInvalidDataErrorMessage(), "Epic sadface: Username and password " +
                                                                            "do not match any user in this service");
    }
}

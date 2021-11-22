package tests;

import constants.TestConstants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import steps.ProductSteps;

@Listeners(TestListener.class)
public class BaseTest implements TestConstants {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutStepOnePage checkoutStepOne;
    CheckoutStepTwoPage checkoutStepTwo;
    CheckoutCompletePage checkoutComplete;
    LoginPageFactory loginPageFactory;
    ProductSteps productSteps;

    @BeforeMethod
    public void initTest(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        String driverVariable = "driver";
        context.setAttribute(driverVariable, driver);
        productSteps = new ProductSteps(driver);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutStepOne = new CheckoutStepOnePage(driver);
        checkoutStepTwo = new CheckoutStepTwoPage(driver);
        checkoutComplete = new CheckoutCompletePage(driver);
        loginPageFactory = new LoginPageFactory (driver);
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }
}

package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutStepOnePage checkoutStepOne;
    CheckoutStepTwoPage checkoutStepTwo;
    CheckoutCompletePage checkoutComplete;

    public static final String SAUCEDEMO_PAGE_URL = "https://www.saucedemo.com";
    public static final String INVENTORY_PAGE_URL = SAUCEDEMO_PAGE_URL + "/inventory.html";
    public static final String CART_PAGE_URL = SAUCEDEMO_PAGE_URL + "/cart.html";

    @BeforeMethod
    public void initTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutStepOne = new CheckoutStepOnePage(driver);
        checkoutStepTwo = new CheckoutStepTwoPage(driver);
        checkoutComplete = new CheckoutCompletePage(driver);
    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }
}

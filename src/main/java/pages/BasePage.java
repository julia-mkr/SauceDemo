package pages;

import constants.PageConstants;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

@Log4j2
public class BasePage implements PageConstants {

    WebDriver driver;
    WebDriverWait wait;

    BasePage(WebDriver driver) {
        this.driver = driver;
        log.debug("Initializing PageFactory");
        PageFactory.initElements(driver, this);

    }

    @Step("Opening URL: '{url}'")
    public void openPage(String url) {
        log.info("Open URL: " + url);
        driver.get(url);
    }

    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}

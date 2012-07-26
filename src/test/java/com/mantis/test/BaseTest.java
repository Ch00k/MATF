package com.mantis.test;

import com.mantis.data.UserData;
import com.mantis.utils.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    protected static WebDriver driver;

    public UserData admin = new UserData("administrator", "test");
    public UserData unknown = new UserData("unknown", "unknown");

    protected WebDriver getWebDriver() {
        if (driver == null) {
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigProperties.getProperty("imp.wait")), TimeUnit.SECONDS);
        }
        return driver;
    }

    @AfterTest
    public void tearDown() throws Exception {
        driver.quit();
    }
}
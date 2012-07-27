package com.mantis.test;

import com.mantis.data.UserData;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {

    protected WebDriver driver;

    public UserData admin = new UserData("administrator", "test");
    public UserData unknown = new UserData("unknown", "unknown");

    protected WebDriver getWebDriver() {
        if (driver == null) {
            driver = new FirefoxDriver();
            //driver.manage().timeouts().implicitlyWait(Long.parseLong(ConfigProperties.getProperty("imp.wait")), TimeUnit.SECONDS);
        }

        return driver;
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
package com.mantis.test;

import com.mantis.pages.HomePage;
import com.mantis.pages.LoginPage;
import com.mantis.utils.LoginFailException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;


public class LoginTest extends BaseTest {

    private LoginPage loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);
    private HomePage homePage;

    @Test
    public void loginSuccessful() throws LoginFailException {
        loginPage.open();
        homePage = loginPage.loginAs(admin);
        assertTrue(homePage.isLoggedIn());
    }

    @Test
    public void loginUnsuccessful() {
        loginPage.open();
        try {
            homePage = loginPage.loginAs(unknown);
            fail("Logged in successfully");
        } catch (LoginFailException e) {

        }
    }
}

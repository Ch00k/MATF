package com.mantis.test;

import com.mantis.pages.HomePage;
import com.mantis.pages.LoginPage;
import com.mantis.utils.LoginFailException;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;


public class LoginTest extends BaseTest {

    private LoginPage loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);
    private HomePage homePage;

    @Test
    public void loginSuccessful() throws LoginFailException {
        loginPage.open();
        homePage = loginPage.loginAs(admin);
        assertTrue(homePage.isLoggedIn());
    }

    @Test(expected = LoginFailException.class)
    public void loginUnsuccessful() throws LoginFailException {
        loginPage.open();
        homePage = loginPage.loginAs(unknown);
    }
}
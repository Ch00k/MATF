package com.mantis.test;

import com.mantis.pages.HomePage;
import com.mantis.pages.LoginPage;
import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    private LoginPage loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);
    private HomePage homePage;

    @Test
    public void loginSuccessful() throws Exception {
        loginPage.open();
        homePage = loginPage.loginAs(admin);
        assertTrue(homePage.isLoggedIn());
        homePage.logout();
        assertTrue(homePage.isLoggedOut());
    }

    public void loginUnsuccessful() throws Exception {
        loginPage.open();
        homePage = loginPage.loginAs(unknown);
        assertTrue(homePage.isLoggedIn());
        homePage.logout();
        assertTrue(homePage.isLoggedOut());
    }



}

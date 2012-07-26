package com.mantis.test;

import com.mantis.pages.HomePage;
import com.mantis.pages.LoginPage;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTestCase {

    private LoginPage loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);
    private HomePage homePage;

    //@Test
    public void testLogin() throws Exception {
        loginPage.open();
        homePage = loginPage.loginAs(admin);
        assertTrue(homePage.isLoggedIn());
        homePage.logout();
        assertTrue(homePage.isLoggedOut());
    }

}

package com.mantis.test;

import com.mantis.pages.LoginPage;
import com.mantis.pages.SignupPage;
import com.mantis.pages.SignupResult;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SignupTest extends BaseTestCase {
    private LoginPage loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);
    private SignupPage signupPage;
    private SignupResult signupResult;

    @Test
    public void testSignup() throws Exception {
        loginPage.open();
        signupPage = loginPage.navToSignup();
        signupResult = signupPage.signUp("mud3", "mud3@mud.net");
        assertTrue(signupResult.isSignedUp());
        //homePage.logout();
        //assertTrue(homePage.isLoggedOut());
    }
}

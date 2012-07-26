package com.mantis.test;

import com.mantis.pages.*;
import com.mantis.pages.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SignupTest extends BaseTest {
    private LoginPage loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);
    private SignupPage signupPage;
    private SignupResultPage signupResult;

    @Test
    public void signupSuccessful() throws Exception {
        loginPage.open();
        signupPage = loginPage.navToSignup();
        signupResult = signupPage.signUp("mud3", "mud3@mud.net");
        assertTrue(signupResult.isSignedUp());
    }
}

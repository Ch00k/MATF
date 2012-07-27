package com.mantis.test;

import com.mantis.pages.LoginPage;
import com.mantis.pages.SignupPage;
import com.mantis.pages.SignupResultPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SignupTest extends BaseTest {
    private LoginPage loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);
    private SignupPage signupPage;
    private SignupResultPage signupResult;

    @Test
    public void signupSuccessful() {
        loginPage.open();
        signupPage = loginPage.navToSignup();
        signupResult = signupPage.signUp("mud3", "mud3@mud.net");
        assertTrue(signupResult.isSignedUp());
    }
}

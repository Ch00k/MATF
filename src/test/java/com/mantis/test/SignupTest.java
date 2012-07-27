package com.mantis.test;

import com.mantis.pages.LoginPage;
import com.mantis.pages.SignupPage;
import com.mantis.pages.SignupResultPage;
import com.mantis.utils.SignupEmailInvalidException;
import com.mantis.utils.SignupLoginInvalidException;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import static org.testng.Assert.assertTrue;


public class SignupTest extends BaseTest {
    private LoginPage loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);
    private SignupPage signupPage;
    private SignupResultPage signupResult;

    @Test
    public void signupSuccessful() throws SignupLoginInvalidException, SignupEmailInvalidException{
        loginPage.open();
        signupPage = loginPage.navToSignup();
        signupResult = signupPage.signUp("mud8", "mud8@mud.net");
        assertTrue(signupResult.isSignedUp());
    }

    @Test(expected = SignupLoginInvalidException.class)
    public void loginInvalid() throws SignupLoginInvalidException, SignupEmailInvalidException {
        loginPage.open();
        signupPage = loginPage.navToSignup();
        signupResult = signupPage.signUp("", "mud@mud.net");
    }

    @Test(expected = SignupEmailInvalidException.class)
    public void emailInvalid() throws SignupLoginInvalidException, SignupEmailInvalidException {
        loginPage.open();
        signupPage = loginPage.navToSignup();
        signupResult = signupPage.signUp("login1", "");
    }
}

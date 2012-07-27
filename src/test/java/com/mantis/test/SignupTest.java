package com.mantis.test;

import com.mantis.pages.LoginPage;
import com.mantis.pages.SignupPage;
import com.mantis.pages.SignupResultPage;
import com.mantis.utils.SignupEmailInvalidException;
import com.mantis.utils.SignupLoginInvalidException;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;


public class SignupTest extends BaseTest {
    private LoginPage loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);
    private SignupPage signupPage;
    private SignupResultPage signupResult;

    @Test
    public void signupSuccessful() throws SignupLoginInvalidException, SignupEmailInvalidException{
        loginPage.open();
        signupPage = loginPage.navToSignup();
        signupResult = signupPage.signUp("mud3", "mud3@mud.net");
        assertTrue(signupResult.isSignedUp());
    }

    @Test
    public void loginInvalid() {
        loginPage.open();
        signupPage = loginPage.navToSignup();
        try {
            signupResult = signupPage.signUp("", "mud@mud.net");
            fail("Signed up successfully");
        } catch (SignupLoginInvalidException e) {

        } catch (SignupEmailInvalidException e) {
            fail("Login valid");
        }
    }

    @Test
    public void emailInvalid() {
        loginPage.open();
        signupPage = loginPage.navToSignup();
        try {
            signupResult = signupPage.signUp("login", "mud@mm.mm");
            fail("Signed up successfully");
        } catch (SignupEmailInvalidException e) {

        } catch (SignupLoginInvalidException e) {
            fail("Email valid");
        }
    }
}

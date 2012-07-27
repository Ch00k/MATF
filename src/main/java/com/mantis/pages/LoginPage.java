package com.mantis.pages;

import com.mantis.data.UserData;
import com.mantis.utils.ConfigProperties;
import com.mantis.utils.LoginFailException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage {

    @FindBy(name = "username")
    public WebElement fieldUsername;

    @FindBy(name = "password")
    public WebElement fieldPassword;

    @FindBy(xpath = "//input[@class='button']")
    public WebElement buttonLogin;

    @FindBy(linkText = "Signup for a new account")
    public WebElement linkSignUp;

    @FindBy(xpath = "//div/font[@color='red'][contains(text(), 'Your account may be disabled or blocked or the username/password you entered is incorrect.')]")
    public WebElement loginFailFlash;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage loginAs(UserData account) throws LoginFailException {
        type(fieldUsername, account.name);
        type(fieldPassword, account.password);
        buttonLogin.click();
        if (isElementPresent(loginFailFlash)) {
            throw new LoginFailException("Login failed");
        } else {
            return PageFactory.initElements(driver, HomePage.class);
        }
    }

    public SignupPage navToSignup() {
        linkSignUp.click();

        return PageFactory.initElements(driver, SignupPage.class);
    }

    @Override
    public void open() {
        driver.get(ConfigProperties.getProperty("login.url"));
    }
}

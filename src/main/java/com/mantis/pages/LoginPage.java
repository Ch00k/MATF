package com.mantis.pages;

import com.mantis.data.UserData;
import com.mantis.utils.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends Page {

    @FindBy(name = "username")
    public WebElement fieldUsername;

    @FindBy(name = "password")
    public WebElement fieldPassword;

    @FindBy(xpath = "//input[@class='button']")
    public WebElement buttonLogin;

    @FindBy(linkText = "Signup for a new account")
    public WebElement linkSignUp;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage loginAs(UserData admin) {
        type(fieldUsername, admin.name);
        type(fieldPassword, admin.password);
        buttonLogin.click();

        return PageFactory.initElements(driver, HomePage.class);
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

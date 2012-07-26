package com.mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage extends Page {

    @FindBy(name = "username")
    public WebElement fieldUsername;

    @FindBy(name = "email")
    public WebElement fieldEmail;

    @FindBy(xpath = "//input[@class='button']")
    public WebElement buttonSignUp;

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public SignupResult signUp(String username, String email) {
        //linkSignUp.click();
        type(fieldUsername, username);
        type(fieldEmail, email);
        buttonSignUp.click();

        return PageFactory.initElements(driver, SignupResult.class);
    }

    @Override
    public void open() {
    }
}

package com.mantis.pages;

import com.mantis.utils.SignupEmailInvalidException;
import com.mantis.utils.SignupLoginInvalidException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage extends BasePage {

    @FindBy(name = "username")
    public WebElement fieldUsername;

    @FindBy(name = "email")
    public WebElement fieldEmail;

    @FindBy(xpath = "//input[@class='button']")
    public WebElement buttonSignUp;

    @FindBy(xpath = "//p[@style='color:red'][contains(text(), 'The username is invalid. Usernames may only contain Latin letters, numbers, spaces, hyphens, dots, plus signs and underscores.')]")
    public WebElement loginInvalidFlash;

    @FindBy(xpath = "//p[@style='color:red'][contains(text(), 'Invalid e-mail address.')]")
    public WebElement emailInvalidFlash;

    public SignupPage(WebDriver driver) {
        super(driver);
    }

    public SignupResultPage signUp(String username, String email) throws SignupLoginInvalidException, SignupEmailInvalidException {
        type(fieldUsername, username);
        type(fieldEmail, email);
        buttonSignUp.click();
        if (isElementPresent(loginInvalidFlash)) {
            throw new SignupLoginInvalidException("Login invalid");
        } else if (isElementPresent(emailInvalidFlash)) {
            throw new SignupEmailInvalidException("Email invalid");
        } else {
            return PageFactory.initElements(driver, SignupResultPage.class);
        }
    }

    @Override
    public void open() {
    }
}

package com.mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupResult extends Page {

    public SignupResult(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//tbody/tr[1]/td/b[contains(text(), 'Account registration processed')]")
    public WebElement signupSuccessFlash;

    public boolean isSignedUp() {
        if (isElementPresent(signupSuccessFlash)) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void open() {

    }
}

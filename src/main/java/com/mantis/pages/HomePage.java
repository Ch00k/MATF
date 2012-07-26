package com.mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Page {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Logout")
    public WebElement linkLogOut;

    @FindBy(xpath = "//input[@class='button']")
    public WebElement linkLogin;

    @Override
    public void open() {

    }

    public boolean isLoggedOut() {
        if (isElementPresent(linkLogin)) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isLoggedIn() {
        return isElementPresent(linkLogOut);
    }

    public void logout() {
        linkLogOut.click();
    }
}
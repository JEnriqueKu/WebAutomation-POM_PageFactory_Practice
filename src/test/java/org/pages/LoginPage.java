package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.utils.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "user-name")
    private WebElement userNameBox;

    @FindBy(id = "password")
    private WebElement passwordBox;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    public void writeUserName(String userName){
        waitElementToBeVisible(userNameBox);
        userNameBox.sendKeys(userName);
    }
    public boolean loginButtonIsDisplayed(){
        waitElementToBeVisible(loginButton);
        return loginButton.isDisplayed();
    }
    public void writePassword(String password){
        waitElementToBeVisible(passwordBox);
        passwordBox.sendKeys(password);
    }

    public HomePage clickLoginButton(){
        waitElementToBeClickable(loginButton);
        return new HomePage(super.getDriver());
    }
}

package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.utils.BasePage;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "first-name")
    private WebElement firstNameBox;
    @FindBy(id = "last-name")
    private WebElement lastNameBox;
    @FindBy(id = "postal-code")
    private WebElement postalCodeBox;
    @FindBy(id = "continue")
    private WebElement continueButton;
    @FindBy(className = "title")
    private WebElement title;

    public void writeFirstName(String firstName){
        waitElementToBeVisible(firstNameBox);
        firstNameBox.sendKeys(firstName);
    }
    public void writeLastName(String lastName){
        waitElementToBeVisible(lastNameBox);
        lastNameBox.sendKeys(lastName);
    }
    public void writePostalCode(String postalCode){
        waitElementToBeVisible(postalCodeBox);
        postalCodeBox.sendKeys(postalCode);
    }
    public ConfirmPage clickContinueButton(){
        waitElementToBeClickable(continueButton);
        return new ConfirmPage(super.getDriver());
    }
    public String getTitleOfPage(){
        return title.getText();
    }
}

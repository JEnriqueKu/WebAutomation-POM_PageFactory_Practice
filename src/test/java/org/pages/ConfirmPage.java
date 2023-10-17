package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.utils.BasePage;

public class ConfirmPage extends BasePage {
    public ConfirmPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "finish")
    private WebElement finishButton;
    @FindBy(className = "title")
    private WebElement title;

    public ThankYouPage clickFinishButton(){
        waitElementToBeClickable(finishButton);
        return new ThankYouPage(super.getDriver());
    }
    public String getTitle(){
        return title.getText();
    }
}

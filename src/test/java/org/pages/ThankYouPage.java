package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.utils.BasePage;

public class ThankYouPage extends BasePage {
    public ThankYouPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "complete-header")
    private WebElement thanksMessage;

    public String getThanksMessage(){
        System.out.println(thanksMessage.getText());
        return thanksMessage.getText();
    }
}

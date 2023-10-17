package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.utils.BasePage;

import java.util.List;

public class ShoppingCartPage extends BasePage {
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "checkout")
    private WebElement checkoutButton;
    @FindBy(className = "title")
    private WebElement title;
    @FindAll(@FindBy(css = ".btn.btn_secondary.btn_small.cart_button"))
    List<WebElement> removeButtons;

    public CheckoutPage clickCheckoutButton(){
        waitElementToBeClickable(checkoutButton);
        return new CheckoutPage(super.getDriver());
    }

    public void removeAllProductsOfTheCart(){
        for (WebElement removeButton : removeButtons) {
            waitElementToBeClickable(removeButton);
        }
    }

    public int getNumberOfItemsInCart(){
        return findElementsInPageByCssSelector(".inventory_item_name").size();
    }

    public String getTitle(){
        return title.getText();
    }
}

package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.utils.BasePage;

public class ResultsPage extends BasePage {
    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".btn.btn_primary.btn_small.btn_inventory")
    private WebElement addToCartButton;
    @FindBy(className = "shopping_cart_container")
    private WebElement shoppingCartButton;
    @FindBy(id = "back-to-products")
    private WebElement title;

    public void addToCart(){
        waitElementToBeClickable(addToCartButton);
    }

    public ShoppingCartPage clickToShoppingCart(){
        waitElementToBeClickable(shoppingCartButton);
        return new ShoppingCartPage(super.getDriver());
    }

    public String getTitleOfPage(){
        waitElementToBeVisible(title);
        return title.getText();
    }
}

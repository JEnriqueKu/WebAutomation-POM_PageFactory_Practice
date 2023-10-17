package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.utils.BasePage;

import java.util.List;
import java.util.Random;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindAll(@FindBy (css = ".btn.btn_primary.btn_small.btn_inventory "))
    private List<WebElement> addToCartButtons;
    @FindAll(@FindBy(className = "inventory_item_name"))
    private List<WebElement> products;
    @FindBy(className = "title")
    private WebElement title;
    @FindBy(className = "shopping_cart_container")
    private WebElement shoppingCartButton;
    @FindBy(id = "react-burger-menu-btn")
    private WebElement optionsButton;
    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;

    public ResultsPage clickOnARandomProduct(){
        Random random = new Random();
        int num = random.nextInt(products.size());
        System.out.println(products.get(num).getText());
        waitElementToBeClickable(products.get(num));
        return new ResultsPage(super.getDriver());
    }

    public ShoppingCartPage clickToShoppingCart(){
        waitElementToBeClickable(shoppingCartButton);
        return new ShoppingCartPage(super.getDriver());
    }

    public void addThreeDiferentElementsToTheCart(){
        for (int i = 0; i < 3; i++) {
            waitElementToBeClickable(addToCartButtons.get(i));
        }
    }

    public LoginPage clickOnLogoutButton(){
        waitElementToBeClickable(logoutButton);
        return new LoginPage(getDriver());
    }
    public void clickOnOptionsButton(){
        waitElementToBeClickable(optionsButton);
    }

    public String getTitleOfPage(){
        waitElementToBeVisible(title);
        return title.getText();
    }
}

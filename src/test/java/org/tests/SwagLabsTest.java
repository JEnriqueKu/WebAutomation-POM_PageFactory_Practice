package org.tests;

import org.pages.*;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.utils.BaseTest;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class SwagLabsTest extends BaseTest {

    @Test
    @Parameters({"firstName","lastName","postalCode"})
    public void purchaseProduct(String firstName, String lastName, String postalCode){

        HomePage homePage = loadFirstPage();
        assertEquals("Products",homePage.getTitleOfPage());
        ResultsPage resultsPage = homePage.clickOnARandomProduct();
        assertEquals("Back to products",resultsPage.getTitleOfPage());
        resultsPage.addToCart();
        ShoppingCartPage shoppingCartPage = resultsPage.clickToShoppingCart();
        assertEquals("Your Cart",shoppingCartPage.getTitle());
        CheckoutPage checkoutPage = shoppingCartPage.clickCheckoutButton();
        assertEquals("Checkout: Your Information",checkoutPage.getTitleOfPage());
        checkoutPage.writeFirstName(firstName);
        checkoutPage.writeLastName(lastName);
        checkoutPage.writePostalCode(postalCode);
        ConfirmPage confirmPage = checkoutPage.clickContinueButton();
        assertEquals("Checkout: Overview",confirmPage.getTitle());
        ThankYouPage thankYouPage = confirmPage.clickFinishButton();
        assertEquals("Thank you for your order!",thankYouPage.getThanksMessage());
    }

    @Test
    public void removingFromCart(){
        HomePage homePage = loadFirstPage();
        assertEquals("Products",homePage.getTitleOfPage());
        homePage.addThreeDiferentElementsToTheCart();
        ShoppingCartPage shoppingCartPage = homePage.clickToShoppingCart();
        assertEquals(3,shoppingCartPage.getNumberOfItemsInCart());
        shoppingCartPage.removeAllProductsOfTheCart();
        assertEquals(0,shoppingCartPage.getNumberOfItemsInCart());
    }

    @Test
    public void logoutTest(){
        HomePage homePage = loadFirstPage();
        homePage.clickOnOptionsButton();
        LoginPage loginPage = homePage.clickOnLogoutButton();
        assertTrue(loginPage.loginButtonIsDisplayed());
    }

}

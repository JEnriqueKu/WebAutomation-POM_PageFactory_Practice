package org.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    WebDriver driver;
    Wait<WebDriver> wait;

    public BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new FluentWait<>(driver).
                withTimeout(Duration.ofSeconds(5)).
                pollingEvery(Duration.ofMillis(500)).
                ignoring(NoSuchElementException.class);

        PageFactory.initElements(driver,this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public Wait<WebDriver> getWait() {
        return wait;
    }

    public void waitElementToBeClickable(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void waitElementToBeVisible(WebElement element){
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public List<WebElement> findElementsInPageByCssSelector(String css){
        return driver.findElements(By.cssSelector(css));
    }

}

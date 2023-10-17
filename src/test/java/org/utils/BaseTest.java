package org.utils;

import org.pages.HomePage;
import org.pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest {

    MyDriver driver;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser","url","userName","password"})
    public void beforeMethod(String browser, String url,String username, String password){
        this.driver = new MyDriver(browser);
        driver.getMyDriver().manage().window().maximize();
        driver.getMyDriver().get(url);

        LoginPage loginPage = new LoginPage(driver.getMyDriver());
        loginPage.writeUserName(username);
        loginPage.writePassword(password);
        HomePage homePage = loginPage.clickLoginButton();
    }

    public HomePage loadFirstPage(){
        return new HomePage(driver.getMyDriver());
    }

    @AfterMethod
    public void afterMethod(){
        driver.getMyDriver().quit();
    }
}


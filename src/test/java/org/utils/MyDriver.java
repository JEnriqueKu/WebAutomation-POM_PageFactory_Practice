package org.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyDriver {
    private WebDriver myDriver;

    public MyDriver(String browser){
        if (browser.equalsIgnoreCase("firefox")){
            this.myDriver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            this.myDriver = new EdgeDriver();
        } else this.myDriver = new ChromeDriver();
    }

    public WebDriver getMyDriver() {
        return this.myDriver;
    }
}

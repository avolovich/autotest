package com.driver;

import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

public class ChromeDriverSingleton implements IWebDriver{

    public static final ChromeDriverSingleton instance = new ChromeDriverSingleton();
    private static WebDriver driver;
    private static WebDriverWait wait;

    private ChromeDriverSingleton() {
        // hide it
    }

    public WebDriver getWebDriver() {
        if (driver==null) {
            driver = new ChromeDriver();
            System.out.println(((HasCapabilities) driver).getCapabilities());
        }
        return driver;
    }

    public WebDriverWait getWebDriverWait() {
        if (wait==null) {
            wait = new WebDriverWait(getWebDriver(),5);
        }
        return wait;
    }

}

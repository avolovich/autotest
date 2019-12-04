package com.driver;

import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FirefoxDriverSingleton implements IWebDriver {

    public static final FirefoxDriverSingleton instance = new FirefoxDriverSingleton();

    private static WebDriver driver;
    private static WebDriverWait wait;

    private FirefoxDriverSingleton() {
        // hide it
    }

    @Override
    public WebDriver getWebDriver() {
        if (driver==null) {
            driver = new FirefoxDriver();
            System.out.println(((HasCapabilities) driver).getCapabilities());
        }
        return driver;
    }

    @Override
    public WebDriverWait getWebDriverWait() {
        if (wait==null) {
            wait = new WebDriverWait(getWebDriver(),5);
        }
        return wait;
    }



}

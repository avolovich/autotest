package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverSingleton {

    private static WebDriver driver;
    private static WebDriverWait wait;

    private DriverSingleton() {
        // hide it
    }

    public static WebDriver getChromeDriver() {
        if (driver==null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static WebDriverWait getWebDriverWait() {
        if (wait==null) {
              wait = new WebDriverWait(getChromeDriver(),5);
        }
        return wait;
    }

}

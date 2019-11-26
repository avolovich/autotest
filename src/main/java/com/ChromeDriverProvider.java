package com;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


public class ChromeDriverProvider {

    private static WebDriver driver;
    private static WebDriverWait wait;

    private ChromeDriverProvider() {
        // hide it
    }

    public static WebDriver getChromeDriver() {
        if (driver==null) {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public static WebDriverWait getChromeDriverWait() {
        if (wait==null) {
              wait = new WebDriverWait(getChromeDriver(),5);
        }
        return wait;
    }

}

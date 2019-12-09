package com.driver;

import com.data.settings.CommonProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



public class DriverProvider {

    private static WebDriver driver;
    private static WebDriverWait wait;
    private static DriverProvider providerInstance;

    private DriverProvider() {
        webDriverFactory();
    }

    private void webDriverFactory(){
        String webdriver = CommonProperties.getInstance().getDefaultWebDriver();
        switch (webdriver) {
            case "chrome" :
                driver = ChromeDriverSingleton.instance.getWebDriver();
                wait = ChromeDriverSingleton.instance.getWebDriverWait();
                break;
            case "firefox" :
                driver = FirefoxDriverSingleton.instance.getWebDriver();
                wait = FirefoxDriverSingleton.instance.getWebDriverWait();
                break;
            case "iexplorer" :
                driver = IEDriverSingleton.instance.getWebDriver();
                wait = IEDriverSingleton.instance.getWebDriverWait();
                break;
            default:
                System.out.println("No suitable driver corresponds to "+webdriver+" set under properties: "+ CommonProperties.getInstance().getAbsolutePath()
                        +". Available values are: chrome, firefox. Taking default settings (Chrome)");
                driver =  ChromeDriverSingleton.instance.getWebDriver();
                wait = ChromeDriverSingleton.instance.getWebDriverWait();
        }
    }

    private static DriverProvider getInstance() {
        if (providerInstance==null) {
            providerInstance = new DriverProvider();
        }
        return providerInstance;
    }

    public static WebDriver getDriver() {
        getInstance();
        return driver;  }

    public static WebDriverWait getWait() {
        getInstance();
        return wait;
    }

}

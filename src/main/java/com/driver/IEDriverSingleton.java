package com.driver;

import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IEDriverSingleton implements IWebDriver{

    public static final IEDriverSingleton instance = new IEDriverSingleton();
    private static WebDriver driver;
    private static WebDriverWait wait;

    private IEDriverSingleton() {
        // hide it
    }

    public WebDriver getWebDriver() {
        if (driver==null) {
            DesiredCapabilities caps = new DesiredCapabilities();
//            caps.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
//            caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            DesiredCapabilities ieCapabilities=DesiredCapabilities.internetExplorer();
//            ieCapabilities.setCapability(InternetExplorerDriver
//                    .INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
//            ieCapabilities.setCapability("requireWindowFocus", true);
            driver = new InternetExplorerDriver(ieCapabilities);
            System.out.println(((HasCapabilities) driver).getCapabilities());
        }
        return driver;
    }

    public WebDriverWait getWebDriverWait() {
        if (wait==null) {
            wait = new WebDriverWait(getWebDriver(),10);
        }
        return wait;
    }

}

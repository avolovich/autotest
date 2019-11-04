package com.utils;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static com.DriverSingleton.getChromeDriver;
import static com.DriverSingleton.getWebDriverWait;

public class TestUtils {

    WebDriver driver = getChromeDriver();
    WebDriverWait wait = getWebDriverWait();

    public static void explicitWait(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void softWait(WebElement element, long timeout, int attempts) {
       FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
       fluentWait.pollingEvery(timeout, TimeUnit.SECONDS);
       for (int i=1; i<=attempts; i++) {
           fluentWait.until(ExpectedConditions.visibilityOf(element));
       }
    }

    protected FluentWait<WebDriver> doWait(Long explicitWaitTime) {
        // no need to include NoSuchElementException since WebDriverWait already includes it
        return new WebDriverWait(driver, explicitWaitTime)
                .ignoring(StaleElementReferenceException.class);
    }

}

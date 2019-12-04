package com.utils;

import com.driver.DriverProvider;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestUtils {

    private WebDriver driver = DriverProvider.getDriver();
    static private WebDriverWait wait =  DriverProvider.getWait();

    public TestUtils() throws IOException {
    }

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

    public static void waitForPageLoad() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//body")));
    }
}

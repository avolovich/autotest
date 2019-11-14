package com.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static com.DriverSingleton.getChromeDriver;
import static com.DriverSingleton.getWebDriverWait;

@Component
public class TestUtils {

    WebDriver driver = getChromeDriver();
    static WebDriverWait wait = getWebDriverWait();

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

    public static void waitForPageLoad() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//body")));
    }

    public static String generateRandomSuffix(int n) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        return sb.toString();
    }

}

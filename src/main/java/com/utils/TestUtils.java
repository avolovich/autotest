package com.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

import static com.ChromeDriverProvider.getChromeDriver;
import static com.ChromeDriverProvider.getChromeDriverWait;

@Component
public class TestUtils {

    WebDriver driver = getChromeDriver();
    static WebDriverWait wait = getChromeDriverWait();

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

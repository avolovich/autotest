package com.ui.pages.repository.explorer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.DriverSingleton.getChromeDriver;
import static com.DriverSingleton.getWebDriverWait;

public class RepoExplorerWaits {

    static WebDriver driver = getChromeDriver();
    static WebDriverWait wait = getWebDriverWait();

    public static void waitForAddFolderDialogToBeLoaded() {
        WebElement body = driver.findElement(By.tagName("body"));
        wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(body,By.id("addFolder")));
    }
}

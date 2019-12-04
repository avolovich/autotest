package com.ui.pages.repository.explorer;

import com.driver.DriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RepoExplorerWaits {

    private static WebDriver driver = DriverProvider.getDriver();
    private static WebDriverWait wait =  DriverProvider.getWait();

    public RepoExplorerWaits() {    }

    public static void waitForAddFolderDialogToBeLoaded() {
        WebElement body = driver.findElement(By.tagName("body"));
        wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(body,By.id("addFolder")));
    }
}

package com.ui.pages.repository.explorer;

import com.dto.resources.Folder;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.ApplicationContext;
import org.testng.Assert;

import static com.DataContext.getData;
import static com.ChromeDriverProvider.getChromeDriver;
import static com.ChromeDriverProvider.getChromeDriverWait;

public class RepoExplorerVerify {

    WebDriver driver = getChromeDriver();
    WebDriverWait wait = getChromeDriverWait();
    ApplicationContext data = getData();

    public RepoExplorerVerify() {
        PageFactory.initElements(driver, this);
    }

    @Step("Verify that folder is displayed under Reports folder")
    public RepoExplorerVerify folderCreated(Folder folder) {
        By newFolder = By.xpath("//p[text()='"+folder.getName()+"']");
        wait.until(ExpectedConditions.presenceOfElementLocated(newFolder));
        Assert.assertTrue(driver.findElement(newFolder).isDisplayed());
        return this;
    }
}

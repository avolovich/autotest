package com.ui.pages.repository.explorer;

import com.driver.DriverProvider;
import com.dto.Folder;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.ApplicationContext;
import org.testng.Assert;

import static com.data.DataContext.getData;

public class RepoExplorerVerify {

    private WebDriver driver = DriverProvider.getDriver();
    private WebDriverWait wait =  DriverProvider.getWait();
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

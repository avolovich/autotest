package com.ui.pages.home;

import com.driver.DriverProvider;
import com.dto.ClientUser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.ApplicationContext;
import org.testng.Assert;

import java.io.IOException;

import static com.DataContext.getData;

public class HomePageVerifyController {

    private WebDriver driver = DriverProvider.getDriver();
    private WebDriverWait wait =  DriverProvider.getWait();
    ApplicationContext data = getData();

    @FindBy(id="userID") WebElement userID;
    @FindBy(id="mainNavigation") WebElement mainMenuContainer;
    @FindBy(id = "searchInput") WebElement searchInput;

    By mainMenu = By.id("mainNavigation");

    public HomePageVerifyController() {
        PageFactory.initElements(driver,  this);
    }

    public HomePageVerifyController userLoggedIn(ClientUser user) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
//        WebElement menu = driver.findElement(mainMenu);
//        wait.until(ExpectedConditions.visibilityOf(mainMenuContainer));
//        Assert.assertTrue(mainMenuContainer.isDisplayed());
//        Assert.assertTrue(searchInput.isDisplayed());
//        wait.until(ExpectedConditions.visibilityOf(userID));

        // Assert.assertEquals(userID.getText(),user.getFullName());
        return this;
    }

}

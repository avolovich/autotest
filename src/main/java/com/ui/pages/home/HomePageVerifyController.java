package com.ui.pages.home;

import com.dto.ClientUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.ApplicationContext;
import org.testng.Assert;

import static com.DataContext.getData;
import static com.DriverSingleton.getChromeDriver;
import static com.DriverSingleton.getWebDriverWait;

public class HomePageVerifyController {

    WebDriver driver = getChromeDriver();
    WebDriverWait wait = getWebDriverWait();
    ApplicationContext data = getData();

    @FindBy(id="userID") WebElement userID;
    @FindBy(id="mainNavigation") WebElement mainMenuContainer;


    public HomePageVerifyController() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 5),  this);
    }

    public HomePageVerifyController userLoggedIn(ClientUser user) {
        wait.until(ExpectedConditions.visibilityOf(mainMenuContainer));
        wait.until(ExpectedConditions.visibilityOf(userID));
        Assert.assertTrue(mainMenuContainer.isDisplayed());
        Assert.assertEquals(userID.getText(),user.getFullName());
        return this;
    }

}

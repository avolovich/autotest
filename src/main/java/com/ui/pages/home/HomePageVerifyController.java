package com.ui.pages.home;

import com.dto.ClientUser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.ApplicationContext;
import org.testng.Assert;

import static com.DataContext.getData;
import static com.ChromeDriverProvider.getChromeDriver;
import static com.ChromeDriverProvider.getChromeDriverWait;

public class HomePageVerifyController {

    WebDriver driver = getChromeDriver();
    WebDriverWait wait = getChromeDriverWait();
    ApplicationContext data = getData();

    @FindBy(id="userID") WebElement userID;
    @FindBy(id="mainNavigation") WebElement mainMenuContainer;
    @FindBy(id = "searchInput") WebElement searchInput;


    public HomePageVerifyController() {
        PageFactory.initElements(driver,  this);
    }

    public HomePageVerifyController userLoggedIn(ClientUser user) {
        wait.until(ExpectedConditions.visibilityOf(mainMenuContainer));
        Assert.assertTrue(mainMenuContainer.isDisplayed());
        Assert.assertTrue(searchInput.isDisplayed());
//        wait.until(ExpectedConditions.visibilityOf(userID));

        // Assert.assertEquals(userID.getText(),user.getFullName());
        return this;
    }

}

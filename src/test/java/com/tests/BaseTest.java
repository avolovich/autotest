package com.tests;

import com.data.settings.CommonProperties;
import com.driver.DriverProvider;
import com.dto.User;
import com.ui.pages.home.HomePage;
import com.ui.pages.login.LoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static com.data.DataContext.getData;
import static com.ui.pages.home.HomePage.getHomePage;
import static com.ui.pages.login.LoginPage.getLoginPage;


@Test
public class BaseTest  {
    WebDriver driver;
    WebDriverWait wait;
    ApplicationContext data = getData();
    LoginPage loginPage = getLoginPage();
    HomePage homePage = getHomePage();
    CommonProperties commonProperties;
    String JRS_URL;

    public BaseTest() {
    }

    @BeforeSuite
    public void startUp() {
        driver = DriverProvider.getDriver();
        wait =  DriverProvider.getWait();
        commonProperties = CommonProperties.getInstance();
        JRS_URL = commonProperties.getJrsUrl();
    //        driver = getChromeDriver();
    //        wait = getChromeDriverWait();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeGroups("repository")
    @Step("Authentication pre-steps, login by jasperadmin")
    public void repositoryPreSteps() {
        driver.manage().deleteAllCookies();
        // driver.get("http://localhost:8080/jasperserver");
        driver.get(JRS_URL);
        User jasperadmin = data.getBean("jasperadmin", User.class);
        loginPage.act().loginByUser(jasperadmin);
        homePage.verify().userLoggedIn(jasperadmin);
    }

    @AfterMethod
    public void logOut() {
        driver.manage().deleteAllCookies();
        driver.get("http://localhost:8080/jasperserver");
    }

    @AfterSuite(alwaysRun = true)
    public void cleanUp() {
        driver.close();
    }
}

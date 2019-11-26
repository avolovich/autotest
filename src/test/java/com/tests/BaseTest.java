package com.tests;

import com.data.CommonProperties;
import com.dto.ClientUser;
import com.exceptions.propertiesFileAccessException;
import com.ui.pages.home.HomePage;
import com.ui.pages.login.LoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.DataContext.getData;
import static com.ChromeDriverProvider.getChromeDriver;
import static com.ChromeDriverProvider.getChromeDriverWait;
import static com.data.CommonProperties.getCommonProperties;
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

    @BeforeSuite
    public void startUp() throws IOException {
        driver = getChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = getChromeDriverWait();
        try {
            commonProperties = getCommonProperties();
            JRS_URL = commonProperties.getJrsUrl();
        } catch (IOException e) {
            throw new propertiesFileAccessException(e);
        }

    }

    @BeforeGroups("repository")
    @Step("Authentication pre-steps, login by jasperadmin")
    public void repositoryPreSteps() {
        driver.manage().deleteAllCookies();
        // driver.get("http://localhost:8080/jasperserver");
        driver.get(JRS_URL);
        ClientUser jasperadmin = data.getBean("jasperadmin", ClientUser.class);
        loginPage.act().loginByUser(jasperadmin);
        homePage.verify().userLoggedIn(jasperadmin);
    }

//    @BeforeMethod
//    public void goToHome() {
//        driver.manage().deleteAllCookies();
//        driver.get("http://localhost:8080/jasperserver");
//    }

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

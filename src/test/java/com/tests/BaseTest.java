package com.tests;

import com.dto.ClientUser;
import com.ui.pages.home.HomePage;
import com.ui.pages.login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

import static com.DataContext.getData;
import static com.DriverSingleton.getChromeDriver;
import static com.DriverSingleton.getWebDriverWait;
import static com.ui.pages.home.HomePage.getHomePage;
import static com.ui.pages.login.LoginPage.getLoginPage;

@Test
public class BaseTest {
    WebDriver driver;
    WebDriverWait wait;
    ApplicationContext data = getData();
    LoginPage loginPage = getLoginPage();
    HomePage homePage = getHomePage();

    @BeforeSuite
    public void startUp() {
        driver = getChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = getWebDriverWait();
    }

    @BeforeGroups("repository")
    public void goToHome() {
        driver.manage().deleteAllCookies();
        driver.get("http://localhost:8080/jasperserver");
        ClientUser jasperadmin = data.getBean("jasperadmin", ClientUser.class);
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

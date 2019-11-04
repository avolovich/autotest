package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

import static com.DriverSingleton.getChromeDriver;
import static com.DriverSingleton.getWebDriverWait;

public class BaseTest {
    WebDriver driver;
    WebDriverWait wait;

    @BeforeSuite
    public void startUp() {
        driver = getChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = getWebDriverWait();
    }

    @BeforeMethod
    public void goToHome() {
        driver.manage().deleteAllCookies();
        driver.get("http://localhost:8080/jasperserver");
    }

    @AfterSuite(alwaysRun = true)
    public void cleanUp() {
        driver.close();
    }
}

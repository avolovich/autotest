package com.ui.pages.login;

import com.driver.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class LoginVerifyController {
    private WebDriver driver = DriverProvider.getDriver();
    private WebDriverWait wait =  DriverProvider.getWait();


    public LoginVerifyController() {
    }
}

package com.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface IWebDriver {
    public WebDriver getWebDriver();
    public WebDriverWait getWebDriverWait();
}

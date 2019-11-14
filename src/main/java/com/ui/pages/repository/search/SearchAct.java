package com.ui.pages.repository.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.ApplicationContext;

import static com.DataContext.getData;
import static com.DriverSingleton.getChromeDriver;
import static com.DriverSingleton.getWebDriverWait;

public class SearchAct {

    WebDriver driver = getChromeDriver();
    WebDriverWait wait = getWebDriverWait();
    ApplicationContext data = getData();

    public SearchAct() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

}

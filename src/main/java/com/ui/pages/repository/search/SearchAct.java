package com.ui.pages.repository.search;

import com.driver.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

import static com.data.DataContext.getData;

public class SearchAct {


    private WebDriver driver = DriverProvider.getDriver();
    private WebDriverWait wait =  DriverProvider.getWait();
    ApplicationContext data = getData();

    public SearchAct() throws IOException {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

}

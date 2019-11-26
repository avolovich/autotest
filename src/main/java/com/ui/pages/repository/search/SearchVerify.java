package com.ui.pages.repository.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.ApplicationContext;

import static com.DataContext.getData;
import static com.ChromeDriverProvider.getChromeDriver;
import static com.ChromeDriverProvider.getChromeDriverWait;

public class SearchVerify {

    WebDriver driver = getChromeDriver();
    WebDriverWait wait = getChromeDriverWait();
    ApplicationContext data = getData();

    public SearchVerify() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    @FindBy(id="") WebElement element;


}

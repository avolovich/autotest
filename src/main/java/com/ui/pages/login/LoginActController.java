package com.ui.pages.login;

import com.Exceptions;
import org.openqa.selenium.WebDriver;
import com.DriverSingleton;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocator;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import sun.rmi.runtime.Log;

import java.util.List;
import java.util.NoSuchElementException;

import static com.DriverSingleton.getChromeDriver;
import static com.Exceptions.noSuchLocaleException;

// Class where we defined actions made over Login Page, e.g. enter some data into fields, click buttons,
// select values from comboboxes

public class LoginActController {
    WebDriver driver = getChromeDriver();

    public LoginActController() {
//        PageFactory.initElements(driver, this);
//        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
//        PageFactory.initElements(factory, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public LoginActController enterUserId(String userId) {
        userField.sendKeys(userId);
        return this;
    }

    public LoginActController enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }

    public LoginActController showLocaleTimeZone() {
        showHideLocaleTimeZoneLink.click();
        return this;
    }

    public LoginActController selectLocale(Locale locale)  {
        Select locales =  new Select(localeDropDown);

        try {
            locales.selectByValue(locale.toString());
        }
        catch (NoSuchElementException e) {
            noSuchLocaleException(locale, e);
        }

        return this;
    }

    public void clickLogin() {
        loginButton.click();
    }

    @FindBy(id = "j_username") WebElement userField;
    @FindBy(id = "j_password_pseudo") WebElement passwordField;
    @FindBy(id = "showHideLocaleAndTimezone") WebElement showHideLocaleTimeZoneLink;
    @FindBy(id = "userLocale") WebElement localeDropDown;
    @FindBy(id = "submitButton") WebElement loginButton;


}

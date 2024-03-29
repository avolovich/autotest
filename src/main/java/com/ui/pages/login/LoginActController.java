package com.ui.pages.login;

import com.driver.DriverProvider;
import com.dto.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.ApplicationContext;

import java.util.NoSuchElementException;

import static com.data.DataContext.getData;

// Class where we defined actions made over Login Page, e.g. enter some data into fields, click buttons,
// select values from comboboxes

public class LoginActController {

    WebDriver driver = DriverProvider.getDriver();
    WebDriverWait wait = DriverProvider.getWait();
    ApplicationContext data = getData();

    @FindBy(id = "j_username") WebElement userField;
    @FindBy(id = "j_password_pseudo") WebElement passwordField;
    @FindBy(id = "showHideLocaleAndTimezone") WebElement showHideLocaleTimeZoneLink;
    @FindBy(id = "userLocale") WebElement localeDropDown;
    @FindBy(id = "submitButton") WebElement loginButton;

    public LoginActController()  {
//        PageFactory.initElements(driver, this);
//        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
//        PageFactory.initElements(factory, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public void loginByUser(User user) {
        enterUserId(user.getUsername())
                .enterPassword(user.getPassword())
                .clickLogin();
    }

    public void loginByUserLocale(User user, Locale locale) {
        enterUserId(user.getUsername())
                .enterPassword(user.getPassword())
                .showLocaleTimeZone()
                .selectLocale(locale)
                .clickLogin();
    }

    public LoginActController enterUserId(String userId) {
        userField.sendKeys(userId);
        System.out.println(userField.getAttribute("aria-labelledby"));
        System.out.println(userField.getCssValue("background-image"));
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
            e.printStackTrace();
        }

        return this;
    }

    public void clickLogin() {
        loginButton.click();
    }

}

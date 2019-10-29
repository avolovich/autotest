package com.tests;
import com.Exceptions;
import com.ui.pages.login.Locale;
import com.ui.pages.login.LoginPage;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.ui.pages.login.LoginPage.getLoginPage;

public class LoginTest extends BaseTest {

    LoginPage loginPage = getLoginPage();

    @DataProvider(name = "locales")
    public Object[][] locales() {
        return new Object[][]
                {
                        {Locale.ENGLISH},{Locale.GERMAN},{Locale.FRENCH},
                        {Locale.ITALIAN},{Locale.SPANISH},{Locale.JAPANESE}
                };
    }

    @DataProvider(name = "credentials")
    public Object[][] credentials() {
        return new Object[][]
                {
                        {"jasperadmin", "jasperadmin"}, {"joeuser", "joeuser"},
                        {"anonymousUser", "anonymousUser"}, {"test1", "1"},
                        {"test2", "2"}, {"test3", "3"}
                };
    }


    @Test(dataProvider = "locales")
    public void canLoginByDifferentLocales(Locale locale)  {
        loginPage.act().enterUserId("jasperadmin")
                .enterPassword("jasperadmin")
                .showLocaleTimeZone()
                .selectLocale(locale)
                .clickLogin();
    }

    @Test(dataProvider = "credentials")
    public void canLoginWithCorrectCredentials(String username, String password)  {
        loginPage.act().enterUserId(username)
                .enterPassword(password)
                .showLocaleTimeZone()
                .clickLogin();
    }

}

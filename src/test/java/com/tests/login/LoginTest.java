package com.tests.login;
import com.DataContext;
import com.dto.ClientUser;
import com.tests.BaseTest;
import com.ui.pages.home.HomePage;
import com.ui.pages.login.Locale;
import com.ui.pages.login.LoginPage;
import com.utils.CsvReader;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static com.DataContext.getData;
import static com.ui.pages.home.HomePage.getHomePage;
import static com.ui.pages.login.LoginPage.getLoginPage;

public class LoginTest extends BaseTest {

    LoginPage loginPage = getLoginPage();
    HomePage homePage = getHomePage();
    ApplicationContext data = getData();

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
        String[] userBeans = data.getBeanNamesForType(ClientUser.class);
        Object[][] result = new Object[userBeans.length][1];
        int i=0;
        for (String userBean:userBeans) {
            ClientUser currentUser = data.getBean(userBean, ClientUser.class);
            result[i][0] = currentUser;
            i++;
        }
//        for(String userBean: userBeans) {
//            currentUser = data.getBean(userBean, ClientUser.class);
//            result[i][0] = currentUser.getUsername();
//            result[i][1] = currentUser.getPassword();
//            result[i][2] = currentUser.getFullName();
//            i++;
//        }
        return result;

//        return new Object[][]
//                {
//                        {"jasperadmin", "jasperadmin"}, {"joeuser", "joeuser"},
//                        {"anonymousUser", "anonymousUser"}, {"test1", "1"},
//                        {"test2", "2"}, {"test3", "3"}
//                };
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

    @Test(dataProvider = "credentials")
    public void loginByUsers(ClientUser user) {
        loginPage.act().loginByUser(user);
        homePage.verify().userLoggedIn(user);
    }

}

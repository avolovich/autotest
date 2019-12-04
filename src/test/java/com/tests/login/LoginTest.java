package com.tests.login;
import com.driver.DriverProvider;
import com.dto.ClientUser;
import com.tests.BaseTest;
import com.ui.pages.home.HomePage;
import com.ui.pages.login.Locale;
import com.ui.pages.login.LoginPage;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.DataContext.getData;
import static com.ui.pages.home.HomePage.getHomePage;
import static com.ui.pages.login.LoginPage.getLoginPage;

@Test(groups = "login")
public class LoginTest extends BaseTest {

    WebDriver driver = DriverProvider.getDriver();
    LoginPage loginPage = getLoginPage();
    HomePage homePage = getHomePage();
    ApplicationContext data = getData();

    @BeforeMethod
    public void login() {
        driver.manage().deleteAllCookies();
        driver.get("http://localhost:8080/jasperserver");
    }

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
        return result;
    }


    @Test(dataProvider = "locales", description = "Login by different locales")
    public void canLoginByDifferentLocales(Locale locale)  {
        loginPage.act().enterUserId("jasperadmin")
                .enterPassword("jasperadmin")
                .showLocaleTimeZone()
                .selectLocale(locale)
                .clickLogin();
    }

    @Test(dataProvider = "credentials", description = "Login by user")
    public void loginByUsers(ClientUser user) {
        loginPage.act().loginByUser(user);
        homePage.verify().userLoggedIn(user);
    }

}

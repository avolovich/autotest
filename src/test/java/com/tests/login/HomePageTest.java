package com.tests.login;
import com.dto.ClientUser;
import com.tests.BaseTest;
import com.ui.pages.home.HomePage;
import com.ui.pages.login.Locale;
import com.ui.pages.login.LoginPage;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.DataContext.getData;
import static com.ui.pages.home.HomePage.getHomePage;
import static com.ui.pages.login.LoginPage.getLoginPage;


@Test
public class HomePageTest extends BaseTest  {

    LoginPage loginPage = getLoginPage();
    HomePage homePage = getHomePage();
    ApplicationContext data = getData();

    @BeforeMethod
    public void loginAsJasperadmin() {
        ClientUser jasperadmin = data.getBean("jasperadmin", ClientUser.class);
        loginPage.act().loginByUser(jasperadmin);
        homePage.verify().userLoggedIn(jasperadmin);
    }

    @Test
    public void openSeachResultsPage() {
        homePage.act()
                .openSearchResults();
    }

    @Test
    public void openRepositoryPage() {
        homePage.act()
                .openRepository();
    }


}


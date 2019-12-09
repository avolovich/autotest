package com.tests.login;
import com.dto.User;
import com.tests.BaseTest;
import com.ui.pages.home.HomePage;
import com.ui.pages.login.LoginPage;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.data.DataContext.getData;
import static com.ui.pages.home.HomePage.getHomePage;
import static com.ui.pages.login.LoginPage.getLoginPage;


@Test
public class HomePageTest extends BaseTest  {

    LoginPage loginPage = getLoginPage();
    HomePage homePage = getHomePage();
    ApplicationContext data = getData();

    @BeforeMethod
    public void loginAsJasperadmin() {
        User jasperadmin = data.getBean("jasperadmin", User.class);
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


package com.tests.repository.explorer;

import com.dto.Folder;
import com.tests.BaseTest;
import com.ui.pages.home.HomePage;
import com.ui.pages.login.LoginPage;
import com.ui.pages.repository.explorer.RepoExplorerPage;
import org.springframework.context.ApplicationContext;
import org.testng.annotations.Test;

import static com.data.DataContext.getData;
import static com.ui.pages.home.HomePage.getHomePage;
import static com.ui.pages.login.LoginPage.getLoginPage;
import static com.ui.pages.repository.explorer.RepoExplorerPage.getRepoExplorerPage;

// @Test(groups = {"repository", "explorer"})

public class RepositoryExplorerTests extends BaseTest {

    public RepositoryExplorerTests() {}

    LoginPage loginPage = getLoginPage();
    HomePage homePage = getHomePage();
    RepoExplorerPage repoPage = getRepoExplorerPage();
    ApplicationContext data = getData();

    @Test(groups = "repository", description = "Create new folder with random name under Reports folder")
    public void createFolderInReportsFolder() {
        homePage = getHomePage();
        Folder newFolder = data.getBean("randomFolder", Folder.class);
        Folder parentFolder = data.getBean("parentFolder", Folder.class);
        homePage.act()
                .openRepository();
        repoPage.act()
                .addFolder(parentFolder, newFolder);
        repoPage.verify()
                .folderCreated(newFolder);

    }

}

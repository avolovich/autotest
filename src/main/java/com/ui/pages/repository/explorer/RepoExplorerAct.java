package com.ui.pages.repository.explorer;

import com.dto.resources.Folder;
import com.utils.TestUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.ApplicationContext;
import org.testng.Assert;

import static com.DataContext.getData;
import static com.DriverSingleton.getChromeDriver;
import static com.DriverSingleton.getWebDriverWait;
import static com.ui.pages.repository.explorer.RepoExplorerWaits.waitForAddFolderDialogToBeLoaded;
import static com.utils.TestUtils.waitForPageLoad;

public class RepoExplorerAct {

    WebDriver driver = getChromeDriver();
    WebDriverWait wait = getWebDriverWait();
    ApplicationContext data = getData();

    @FindBy(id="menuList") WebElement menu;
    @FindBy(id="foldersTree") WebElement repositoryFoldersTreeContainer;
    @FindBy(id="addFolder") WebElement addFolderDialog;
    @FindBy(id="addFolderBtnAdd") WebElement addFolderBtnAdd;
    @FindBy(id="addFolderInputName") WebElement addFolderInputName;
    @FindBy(id="addFolderInputDescription") WebElement addFolderInputDescription;


    public RepoExplorerAct() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public RepoExplorerAct addFolder(Folder parent, Folder sub) {
        moveToFolder(parent)
                .contextMenuAddFolderClick()
                .fillInFolderData(sub)
                .clickAddFolderBtn();
        return this;
    }

    private RepoExplorerAct moveToFolder(Folder parent) {
        String folderName = parent.getName();
            // Looking for parent folder in root node by text
        WebElement parentFolder = driver.findElement(By.xpath("//*[@id='foldersTree']//*[@id='node1sub']/li/p[text()='"+folderName+"']"));
            // If there is no such folder - test fails
        if (parentFolder == null) { Assert.fail("There is no folder named: " + folderName); }
            // Context click on desired folder
        Actions actions = new Actions(driver);
        actions.moveToElement(parentFolder).contextClick(parentFolder).perform();

        // waiting for all context menu elements to be opened
        wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(menu, By.xpath("li/p")));
        return this;
    }

    private RepoExplorerAct contextMenuAddFolderClick() {
        WebElement item = driver.findElement(By.xpath("//*[@id='menuList']/li/p[contains(., 'Add Folder')]"));
        new Actions(driver).moveToElement(item).click(item).perform();
        waitForAddFolderDialogToBeLoaded();
        return this;
    }

    private RepoExplorerAct fillInFolderData(Folder sub) {
        WebElement addFolderInputName = addFolderDialog.findElement(By.id("addFolderInputName"));
        WebElement addFolderInputDescription = addFolderDialog.findElement(By.id("addFolderInputDescription"));
        addFolderInputName.clear();
        addFolderInputDescription.clear();
        Actions actions = new Actions(driver);
        actions.sendKeys(addFolderInputName,sub.getName()).perform();
  //      TestUtils.explicitWait(500);
        actions.sendKeys(addFolderInputDescription,sub.getDescription()).perform();
   //     TestUtils.explicitWait(500);
        return this;
    }

    private RepoExplorerAct clickAddFolderBtn() {
        addFolderBtnAdd.click();
        waitForPageLoad();
        return this;
    }









}

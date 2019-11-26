package com.ui.pages.home;

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
import static com.ChromeDriverProvider.getChromeDriver;
import static com.ChromeDriverProvider.getChromeDriverWait;
import static com.utils.TestUtils.waitForPageLoad;

public class HomePageActController {

    private WebDriver driver = getChromeDriver();
    private WebDriverWait wait = getChromeDriverWait();
    ApplicationContext data = getData();

    private static final String searchResults = "Search Results";
    private static final String repository = "Repository";
    private static final String schedules = "Schedules";
    private static final String messages = "Messages";
    private static final String addFolder = "Add Folder";

    private static final String dataSourcesFolder = "Data Sources";
    private static final String reportsFolder = "Reports";
    private static final String testFolderName = "testFolderName";



    @FindBy(css = "#main_home > p") WebElement home;
    @FindBy(css = "#main_library > p") WebElement library;
    @FindBy(css = "#main_view > p") WebElement view;
    @FindBy(css = "#main_manage > p") WebElement manage;
    @FindBy(id="menuList") WebElement menu;
    @FindBy(id="foldersTree") WebElement repositoryFoldersTreeContainer;
    @FindBy(id="addFolder") WebElement addFolderDialog;
    @FindBy(id="addFolderBtnAdd") WebElement addFolderBtnAdd;


    // @FindBy(xpath = "li/p[contains(., '"+searchResultsText+"')]") WebElement searchOptRelative;
 //   @FindBy(xpath="//ul[@id=foldersTree]/li//li[contains(@class, 'node')]") List<WebElement> options;

    public HomePageActController() {
       // PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public HomePageActController addFolder() {
        openContextMenuOverFolder(reportsFolder)
                .openContextMenuItem(addFolder)
                .typeFolderNameAndClickAdd(testFolderName);
        return this;
    }

    public HomePageActController openSearchResults() {
        moveToMainMenu(view);
        openMainMenuOption(searchResults);
        return this;
    }

    public HomePageActController openRepository() {
        moveToMainMenu(view);
        openMainMenuOption(repository);
        return this;
    }

    public HomePageActController openSchedules() {
        moveToMainMenu(view);
        openMainMenuOption(schedules);
        return this;
    }

    public HomePageActController openMessages() {
        moveToMainMenu(view);
        openMainMenuOption(messages);
        return this;
    }

    private HomePageActController moveToMainMenu(WebElement option) {
        new Actions(driver).moveToElement(option).perform();

        By allItems = By.xpath("li/p");
        wait.until(
                ExpectedConditions.visibilityOfNestedElementsLocatedBy(menu, allItems));
        return this;
    }

    private HomePageActController openMainMenuOption(String option) {
        WebElement item = driver.findElement(By.xpath("//*[@id='menuList']/li/p[contains(., '"+option+"')]"));
        new Actions(driver).moveToElement(item).click(item).perform();
        waitForPageLoad();
        return this;
    }

    public HomePageActController openContextMenuOverFolder(String folder) {

        // Looking for parent folder in root node by text
        WebElement parentFolder = driver.findElement(By.xpath("//*[@id='foldersTree']//*[@id='node1sub']/li/p[text()='"+folder+"']"));

        // If there is no such folder - test fails
        if (parentFolder == null) { Assert.fail("There is no folder named: " + folder); }

        // Context click on desired folder
        Actions actions = new Actions(driver);
        actions.moveToElement(parentFolder).contextClick(parentFolder).perform();

        // waiting for all context menu elements to be opened
        wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(menu, By.xpath("li/p")));
        return this;
    }

    public HomePageActController openContextMenuItem(String option) {
        Actions actions = new Actions(driver);
        // Looking for a nested element in
        WebElement item = driver.findElement(By.xpath("//*[@id='menuList']/li/p[contains(., '"+option+"')]"));
        actions.moveToElement(item).click(item).perform();
        return this;

    }

    public HomePageActController typeFolderNameAndClickAdd(String name) {
        wait.until(ExpectedConditions.visibilityOfNestedElementsLocatedBy(addFolderDialog,By.id("addFolderInputName")));
        WebElement folderInput = addFolderDialog.findElement(By.id("addFolderInputName"));
        folderInput.clear();
        folderInput.sendKeys(name);
        addFolderBtnAdd.click();
        waitForPageLoad();
        return this;
    }


}

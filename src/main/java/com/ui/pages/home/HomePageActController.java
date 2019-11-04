package com.ui.pages.home;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.ApplicationContext;
import org.testng.Assert;

import java.util.List;

import static com.DataContext.getData;
import static com.DriverSingleton.getChromeDriver;
import static com.DriverSingleton.getWebDriverWait;

public class HomePageActController {

    private WebDriver driver = getChromeDriver();
    private WebDriverWait wait = getWebDriverWait();
    ApplicationContext data = getData();

    private static final String searchResults = "Search Results";
    private static final String repository = "Repository";
    private static final String schedules = "Schedules";
    private static final String messages = "Messages";

    private static final String dataSourcesFolderText = "Data Sources";

    @FindBy(id="foldersTree") WebElement foldersTree;

    @FindBy(css = "#main_view > p") WebElement view;
    @FindBy(css="#menuList") WebElement menu;
    @FindBy(xpath = "//*[@id='menuList']/li/p[contains(., 'Search Results')]") WebElement searchOpt; //useless

    // @FindBy(xpath = "li/p[contains(., '"+searchResultsText+"')]") WebElement searchOptRelative;
 //   @FindBy(xpath="//ul[@id=foldersTree]/li//li[contains(@class, 'node')]") List<WebElement> options;




    public HomePageActController() {
        PageFactory.initElements(driver, this);
       // PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);
    }

    public HomePageActController openSearchResults() {
        openMenuItem(searchResults);
        return this;
    }

    public HomePageActController openRepository() {
        openMenuItem(repository);
        return this;
    }

    public HomePageActController openSchedules() {
        openMenuItem(schedules);
        return this;
    }


    public HomePageActController openMessages() {
        openMenuItem(messages);
        return this;
    }

    private HomePageActController openMenuItem(String menuItemText) {
        Actions action = new Actions(driver);
        action.moveToElement(view).perform();

        By allItems = By.xpath("li/p");
//        By relativeItemLocator = By.xpath("(li/p[contains(., '"+menuItemText+"')])[1]");
        By relativeItemLocator = By.xpath("li/p[contains(., '"+menuItemText+"')]");

        wait.until(
                ExpectedConditions.visibilityOfNestedElementsLocatedBy(menu, allItems));

        WebElement item = driver.findElement(By.xpath("//*[@id='menuList']/li/p[contains(., '"+menuItemText+"')]"));
    //    WebElement item = menu.findElement(relativeItemLocator);

        action.click(item).perform();

//        action.moveToElement(item)
//                .click(item).perform();



//        String e = elementFoundByAbsoluteXpath.getText();
//        String er = item.getText();


        return this;
    }

    public HomePageActController openSearchResultsNoPageFactory() {

        WebElement viewOption = driver.findElement(By.cssSelector("#main_view > p"));
        Actions action = new Actions(driver);
        action.moveToElement(viewOption).perform();

        WebElement menuList = driver.findElement(By.cssSelector("#menuList"));

        By menuItemLocator = By.xpath("li/p[contains(., '"+searchResults+"')]");

        wait.until(
                ExpectedConditions.visibilityOfNestedElementsLocatedBy(menuList, menuItemLocator));

        WebElement menuItem = menuList.findElement(menuItemLocator);
        String s = menuItem.getText();
        //menuItem.click();
        action.moveToElement(menuItem)
                .click(menuItem).perform();

//       for (WebElement menuItem:menuItems) {
//            String menuText = menuItem.getText();
//            System.out.println(menuText);
//            if (menuText.contains("Search Results")) {
//                menuItem.click();
//            }
//
//        }

//        Actions action = new Actions(driver);
//        action.moveToElement(viewOption).click(menuItems.get(0)).perform();
        return this;
    }

    public HomePageActController openRepository_() {
        Actions action = new Actions(driver);
    //    action.moveToElement(viewOption).moveByOffset(0, 50).click().perform();
        return this;
    }

    public HomePageActController localeDataSources() {
        Actions actions = new Actions(driver);
        actions.moveToElement(foldersTree).perform();
        List<WebElement> listByXpath = foldersTree.findElements(By.xpath("li/ul/li/p[contains(., '"+dataSourcesFolderText+"')]"));
        // List<WebElement> listByXpath = foldersTree.findElements(By.xpath("li/ul/li[contains(@class,'node')]/p[contains(@class, 'button')]"));
//        List<WebElement> listFolderFirstLevel = foldersTree.findElements(By.cssSelector("li > ul > li > p"));
    //    List<WebElement> listFolderFirstLevelClass = foldersTree.findElements(By.cssSelector("li > ul > li > p.wrap.button.draggable"));
     //   List<WebElement> listFolderFirstLevelClass2 = foldersTree.findElements(By.cssSelector("li > p.wrap.button.draggable"));
        if (listByXpath.isEmpty()) {
            Assert.fail("There is no folder named: " + dataSourcesFolderText);
        } else {
            WebElement folder = listByXpath.get(0);
            WebElement folderIcon = folder.findElement(By.cssSelector("b.icon"));
            Actions dataSourceActions = new Actions(driver);
            // dataSourceActions.moveToElement(folder).contextClick(folderIcon).perform();
            dataSourceActions.click(folderIcon).perform();
        }
        return this;

    }



}

package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.EtsyHomePage;
import pages.GoogleSearchPage;
import pages.GoogleSearchResultPage;
import pages.Project2Page;
import utils.Driver;

public class Base {

    public static WebDriver driver;
    public static Actions actions;

    public static Project2Page project2Page;
    public static GoogleSearchPage googleSearchPage;
    public static GoogleSearchResultPage googleSearchResultPage;
    public static EtsyHomePage etsyHomePage;

    @BeforeMethod
    public void setUp(){
        driver = Driver.getDriver();
    }

    @AfterMethod
    public void tearDown(){
        Driver.quitDriver();
    }
}

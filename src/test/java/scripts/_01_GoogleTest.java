package scripts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class _01_GoogleTest {
    /*
    validate that user see a search input box
     */

    public static WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup(); // Set up Chrome driver

        driver = new ChromeDriver(); // Launch a Chrome driver
        driver.manage().window().maximize(); // Maximizes the Chrome window
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); // implicit wait

        driver.get("https://www.google.com/");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
    @Test (priority = 2)
    public void ValidateSearchBar() throws InterruptedException {

        //WebElement searchInputBox = driver.findElement(By.id("APjFqb"));
        WebElement searchInputBox = driver.findElement(By.name("q"));

        Assert.assertTrue(searchInputBox.isDisplayed());

    }

    /*
    go to https://www.google.com/
    validate title is google
    validate that the URL is google
     */

    @Test (priority = 1)
    public void validateTitleAndURL(){

        //validate of title and URL
        System.out.println("The title is = " + driver.getTitle());
        System.out.println("The current URL is = " + driver.getCurrentUrl());

       Assert.assertEquals(driver.getTitle(),"Google");
       Assert.assertEquals(driver.getCurrentUrl(),"https://www.google.com/");

    }

    /*
    go to google
    refresh the page
    navigate to amazon.com
    navigate back and forward
     */

    @Test
    public void validateNavigation()throws InterruptedException{
     Thread.sleep(2000);
     driver.navigate().refresh();

     Thread.sleep(2000);
     driver.navigate().to("https://www.amazon.com/");

     Thread.sleep(2000);
     driver.navigate().back();

     Thread.sleep(2000);
     driver.navigate().forward();

        System.out.println("The title is = " + driver.getTitle());
     Assert.assertEquals(driver.getTitle(),"Amazon.com. Spend less. Smile more.");
    }
    /*
    go to google
    validate that the user "google search" button
    validate its text is google search
    validate that it is clickable
     */

    @Test
    public void validateSearchButton(){
        WebElement searchButton = driver.findElement(By.xpath("(//input[@name='btnK'])[2]"));
        Assert.assertTrue(searchButton.isDisplayed());
        System.out.println(searchButton.getAttribute("value")); // google search

        Assert.assertEquals(searchButton.getAttribute("value"),"Google Search");
        Assert.assertTrue(searchButton.isEnabled());
    }
}

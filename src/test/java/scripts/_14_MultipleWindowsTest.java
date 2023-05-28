package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;
import utils.WindowHandler;

import java.util.List;

public class _14_MultipleWindowsTest extends Base{
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/");
        System.out.println(driver.getWindowHandle()); //1
        driver.findElement(By.id("card-10")).click();
    }

    @Test(priority = 1, description = "TC32 validate the Apple navigation")
    public void validateTheAppleNavigation(){
        WebElement appleLink = driver.findElement(By.id("apple"));
        appleLink.click();

        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getWindowHandles().size()); //2

        WindowHandler.switchToChildWindow();

        WebElement appleLogo = driver.findElement(By.cssSelector(".globalnav-link-apple"));

        Assert.assertTrue(appleLogo.isDisplayed());
        }

    @Test(priority = 2,description = "TC322 validate the Mircosoft navigation")
    public void validateTheMicrosoftNavigation(){
        WebElement microsoftLink = driver.findElement(By.id("microsoft"));
        microsoftLink.click();

        WindowHandler.switchToChildWindow();

        Assert.assertTrue(driver.getCurrentUrl().contains("microsoft"));
     }

     /*
    TEST CASE
    Go to https://techglobal-training.com/frontend
    Click on "Multiple Windows" card
    Click on "Tesla"
    Validate the title is "Electric Cars, Solar & Clean Energy | Tesla"
    Navigate back to https://techglobal-training.com/frontend/multiple-windows
    Validate the URL contains "techglobal"
    Validate the main heading is "Multiple Windows"
      */
     @Test(priority = 3,description = "TC323 validate the Tesla navigation")
    public void validateTheTeslaNavigation(){
        WebElement teslaLink = driver.findElement(By.id("tesla"));
        teslaLink.click();
         WindowHandler.switchToChildWindow();

         Assert.assertEquals(driver.getTitle(),"Electric Cars, Solar & Clean Energy | Tesla");

        WindowHandler.switchToMainWindow();
        Assert.assertTrue(driver.getCurrentUrl().contains("techglobal"));
        Assert.assertEquals(driver.findElement(By.id("main_heading")).getText(),"Multiple Windows");
     }

    /*
     TEST CASE
      Go to https://techglobal-training.com/frontend
    Click on "Multiple Windows" card
    Validate the links "Apple", "Microsoft" and "Tesla" navigates user to
    "https://www.apple.com/", "https://www.microsoft.com/en-us/", "https://www.tesla.com/"
     */

     @Test(priority = 4, description = "TC324 validate Link URL")
    public void validateTheLinkURLs(){
         List<WebElement> links = driver.findElements(By.cssSelector(".MultipleWindows_link__JB372"));
        String[] expectedResults ={"https://www.apple.com/","https://www.microsoft.com/en-us/","https://www.tesla.com/"};

         for (int i = 0; i < 3; i++) {
             links.get(i).click();
             WindowHandler.switchToChildWindow();
             Assert.assertEquals(driver.getCurrentUrl(),expectedResults[i]);
             driver.close();
             WindowHandler.switchToMainWindow();
             Waiter.pause(2);
         }
     }
    }
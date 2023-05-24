package scripts;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Driver;

public class _08_TGWaitTest extends Base{

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElement(By.id("card-4")).click();
    }

    @Test
    public void RedBox(){
        WebElement redBoxButton = driver.findElement(By.cssSelector("button[id='red']"));
        redBoxButton.click();

        WebElement redBoxShown = driver.findElement(By.cssSelector("button[class*='Box']"));
        Assert.assertTrue(redBoxShown.isDisplayed());
    }

    @Test
    public void waitForBlueBox(){
        WebElement blueBoxButton = driver.findElement(By.id("blue"));
        blueBoxButton.click();


        WebElement blueBoxShown = driver.findElement(By.cssSelector("button[class*='blue_box']"));

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 40);
        wait.until(ExpectedConditions.visibilityOf(blueBoxShown));

        Assert.assertTrue(blueBoxShown.isDisplayed());
    }
}

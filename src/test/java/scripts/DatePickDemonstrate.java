package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.Waiter;

public class DatePickDemonstrate extends Base {

    @BeforeMethod
    public void setPage() {
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-20")).click();
        actions = new Actions(driver);

    }
    @Test
    public void datePickerExample(){
        WebElement month = driver.findElement(By.name("month"));
        WebElement day = driver.findElement(By.name("day"));
        WebElement year = driver.findElement(By.name("year"));

        month.sendKeys("10");
        day.sendKeys("5");
        year.sendKeys("1995");
        Waiter.pause(3);

        year.sendKeys(Keys.ESCAPE);

        Waiter.pause(5);

        //Assert.assertEquals();
    }
}

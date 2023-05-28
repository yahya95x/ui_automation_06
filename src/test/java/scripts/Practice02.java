package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Practice02 extends Base{
    @BeforeMethod
    public void setPage(){
        driver.get("https://ultimateqa.com/complicated-page");
    }

    @Test
    public void validateToggle(){
        WebElement toggle = driver.findElement(By.cssSelector("a[href='#A_toggle']>span[class='lwptoc_item_label']"));

        Assert.assertTrue(toggle.isDisplayed());
        Assert.assertTrue(toggle.isEnabled());
        toggle.click();

    }
}

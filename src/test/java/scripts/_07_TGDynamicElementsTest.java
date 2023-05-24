package scripts;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;

public class _07_TGDynamicElementsTest extends Base{
    /*
    Test case
    go to TechGlobal
    click on dynamic elements
    validate both box1 is displayed
    validate both box2 is displayed
     */

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElement(By.id("card-3")).click();
    }

    @Test
    public void validateDynamicElementBox1(){
        WebElement box1 = driver.findElement(By.cssSelector("[id^='box_1_']"));
        Assert.assertTrue(box1.isDisplayed());
        Assert.assertEquals(box1.getText(),"Box 1");
    }

    @Test
    public void validateDynamicElementBox2(){
        WebElement box2 = driver.findElement(By.cssSelector("[id^='box_2_']"));
        Assert.assertTrue(box2.isDisplayed());
        Assert.assertEquals(box2.getText(),"Box 2");
    }

    @Test
    public void validateDynamicElementBox(){
        //p[id*='element'] // contains[id*='#root']
       List<WebElement> boxes = driver.findElements(By.cssSelector("p[id*='box_']"));

       String[] expectedTexts = {"Box 1", "Box 2"};
        for (int i = 0; i < boxes.size(); i++) {
            Assert.assertTrue(boxes.get(i).isDisplayed());
            Assert.assertEquals(boxes.get(i).getText(),expectedTexts[i]);
        }

    }
}

package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class _09_TGCheckboxTest extends Base{

    /*
    Go to https://techglobal-training.com/frontend/
Click on the "Checkboxes" card
Validate "Apple" and "Microsoft" checkboxes are displayed, enabled, and not selected
Select both and validate they are both selected
Deselect both and validate they are deselected
     */

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElement(By.id("card-7")).click();
    }

    @Test
    public void checkBoxes(){
        List<WebElement> checkboxInput = driver.findElements(By.cssSelector("#checkbox-button-group_1 input"));
        List<WebElement> checkboxLabel = driver.findElements(By.cssSelector("#checkbox-button-group_1 label"));
        checkboxLabel.forEach(web -> {
           Assert.assertTrue(web.isDisplayed());
           Assert.assertTrue(web.isEnabled());
           Assert.assertFalse(web.isSelected());

        });

        for (int i = 0; i < checkboxInput.size() ; i++) {
            checkboxInput.get(i).click();
            Assert.assertTrue(checkboxInput.get(i).isSelected());
        }
    }

    @Test
    public void checkBoxes2(){
        List<WebElement> checkboxInput2 = driver.findElements(By.cssSelector("#checkbox-button-group_2 input"));
        List<WebElement> checkboxLabel2 = driver.findElements(By.cssSelector("#checkbox-button-group_2 label"));
        checkboxLabel2.forEach(cb -> {
            Assert.assertTrue(cb.isDisplayed());
            Assert.assertTrue(cb.isEnabled());
            Assert.assertFalse(cb.isSelected());
        });

        for (int i = 0; i < checkboxInput2.size(); i++) {
            checkboxInput2.get(i).click();
            Assert.assertTrue(checkboxInput2.get(i).isSelected());
        }
    }
}

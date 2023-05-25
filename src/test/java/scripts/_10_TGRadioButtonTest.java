package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class _10_TGRadioButtonTest extends Base{
    /*
    Go to https://techglobal-training.com/frontend/
Click on the "Radio Buttons" card
Validate that "Java", "JavaScript" and "C#" radio buttons are displayed, enabled, and not selected
Select "Java" and validate it is selected but the other 2 are deselected
Select "JavaScript" to validate it is selected but the other 2 are deselected
     */

    @BeforeMethod
    public void setPage(){
            driver.get("https://techglobal-training.com/frontend/");
            driver.findElement(By.id("card-6")).click();
    }

    @Test
    public void Radioinput(){
    List<WebElement> radioInput = driver.findElements(By.cssSelector("#radio-button-group_1 input"));
    List<WebElement> radioLabel = driver.findElements(By.cssSelector("#radio-button-group_1 label"));
        radioLabel.forEach(rl ->{
        Assert.assertTrue(rl.isDisplayed());
        Assert.assertTrue(rl.isEnabled());
        Assert.assertFalse(rl.isSelected());

    });
            radioLabel.get(0).click();
        for (int i = 0; i < 3; i++) {
            Assert.assertTrue(radioInput.get(0).isSelected());
            Assert.assertFalse(radioInput.get(1).isSelected());
            Assert.assertFalse(radioInput.get(2).isSelected());
        }

        radioLabel.get(1).click();
        for (int i = 0; i < 3; i++) {
            Assert.assertFalse(radioInput.get(0).isSelected());
            Assert.assertTrue(radioInput.get(1).isSelected());
            Assert.assertFalse(radioInput.get(2).isSelected());
        }
    }

    /*
    Go to https://techglobal-training.com/frontend/
Click on the "Radio Buttons" card
Validate that "Selenium", "Cypress" and "Playwright" radio buttons are displayed, enabled, and not selected
Select "Cypress" and validate it is selected but the other 2 are deselected
Select "Playwright" to validate it is selected but the other 2 are deselected
     */

    @Test
    public void radioInput2(){
        List<WebElement> radioInput2 = driver.findElements(By.cssSelector("#radio-button-group_2 input"));
        List<WebElement> radioLabel2 = driver.findElements(By.cssSelector("#radio-button-group_2 label"));

        radioLabel2.forEach(rl ->{
            Assert.assertTrue(rl.isDisplayed());
            Assert.assertTrue(rl.isEnabled());
            Assert.assertFalse(rl.isSelected());

        });

        radioLabel2.get(0).click();
        Assert.assertTrue(radioInput2.get(0).isSelected());
        for (int i = 0; i < 3; i++) {

            Assert.assertFalse(radioInput2.get(1).isSelected());
            Assert.assertFalse(radioInput2.get(2).isSelected());
        }

        radioLabel2.get(1).click();
        Assert.assertTrue(radioInput2.get(1).isSelected());
        for (int i = 0; i < 3; i++) {
            if (i ==1) continue;
            Assert.assertFalse(radioInput2.get(i).isSelected());


    }
}}

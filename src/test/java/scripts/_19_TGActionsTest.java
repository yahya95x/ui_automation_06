package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

import static utils.Waiter.pause;

public class _19_TGActionsTest extends Base{

    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-15")).click();
        actions = new Actions(driver);

    }

    @Test
    public void mouseActions(){
        Actions actions = new Actions(driver);

        actions.moveToElement(driver.findElement(By.id(""))).click().perform();
        actions.dragAndDrop(driver.findElement(By.id("")), driver.findElement(By.id(""))).perform();
    }
    /*
     * Test Case 1: Click Action
     * Go to https://techglobal-training.com/frontend/
     * Click on the "Actions" card
     * Verify that the user is redirected to the Actions page

     * Perform a click action on the first web element labeled "Click on me"
     * Verify that a message appears next to the element stating, "You clicked on a button!"

    Verify that the user is redirected to the Actions page
    Verify that the first three web elements are present and labeled as "Click on me", "Right-Click on me", and "Double-Click on me"
    Perform a click action on the first web element labeled "Click on me"
    Verify that a message appears next to the element stating, "You clicked on a button!"
    Perform a right-click action on the second web element labeled "Right-Click on me"
    Verify that the message appears next to the element stating, "You right-clicked on a button!"
    Perform a double-click action on the third web element labeled "Double-Click on me"
    Verify that the message appears next to the element stating, "You double-clicked on a button!"
     */

    @Test
    public void mouseActions2(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://techglobal-training.com/frontend/actions");

        WebElement clickOnMeButton = driver.findElement(By.id("click"));
        WebElement rightClick = driver.findElement(By.id("right-click"));
        WebElement leftClick = driver.findElement(By.id("double-click"));

        actions.moveToElement(clickOnMeButton).click().perform();
        actions.moveToElement(rightClick).contextClick().perform();
        actions.moveToElement(leftClick).doubleClick().perform();

        WebElement clickResult = driver.findElement(By.id("click_result"));
        WebElement rightClickResult = driver.findElement(By.id("right_click_result"));
        WebElement doubleClickResult = driver.findElement(By.id("double_click_result"));


        Assert.assertEquals(clickResult.getText(),"You clicked on a button!");
        Assert.assertEquals(rightClickResult.getText(),"You right-clicked on a button!");
        Assert.assertEquals(doubleClickResult.getText(),"You double-clicked on a button!");
    }

    /*
    TEST CASE 2
    Go to https://techglobal-training.com/frontend/
    Click on the "Actions" card
    Verify that the last two web elements are present and labeled as "Drag Me", and "Drop Here",
    Perform a Drag and Drop action on the "Drag Me" web element, and drop it to "Drop Here"
    Verify that the first web element "Drag me" is successfully dropped into the second web element "Drop Here"
    Verify that a message appears next to the web element stating, "An element dropped here!"
     */
    @Test
    public void validateDragMe(){
        WebElement dragMe = driver.findElement(By.id("drag_element"));
        WebElement dropMe = driver.findElement(By.id("drop_element"));

        actions.dragAndDrop(dragMe,dropMe).perform();
    //  actions.moveToElement(dragMe).clickAndHold().moveToElement(dropMe).release().perform();

        WebElement dragAndDropResult = driver.findElement(By.id("drag_and_drop_result"));
        Assert.assertEquals(dragAndDropResult.getText(),"An element dropped here!");

//        actions.keyDown(Keys.SHIFT)
//                .sendKeys(dropMe,"techglobal")
//                .pause(Duration.ofSeconds(2))
//                .keyUp(Keys.SHIFT)
//                .sendKeys(dragAndDropResult,"techglobal");
    }

    /*
    Go to https://techglobal-training.com/frontend/
    Click on the "Actions" card
    Go to the input box, and remove if there is an existing text inside
    First, enter “h” to the input box in upper case using keyboard actions
    Then complete the word by sending “ello” as a key
    Validate value attribute of the input box is “Hello”
     */
    @Test
    public void keyBoardActions(){
        WebElement inputBox = driver.findElement(By.id("input_box"));
        actions.keyDown(Keys.SHIFT)
                .sendKeys(inputBox,"h")
                .keyUp(Keys.SHIFT)
                .sendKeys("ello")
                .perform();
        Assert.assertEquals(inputBox.getAttribute("value"),"Hello");
    }

    @Test
    public void keyBoardActions2(){
        WebElement inputBox = driver.findElement(By.id("input_box"));
        actions.keyDown(Keys.SHIFT)
                .sendKeys(inputBox,"techglobal")
                .keyUp(Keys.SHIFT)
                .keyDown(Keys.CONTROL).sendKeys("Acvv")
                .keyUp(Keys.CONTROL)
                .perform();
        Assert.assertEquals(inputBox.getAttribute("value"),"TECHGLOBALTECHGLOBAL");
    }
}


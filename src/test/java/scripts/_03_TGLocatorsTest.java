package scripts;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


import static org.openqa.selenium.By.*;

public class _03_TGLocatorsTest extends Base {
    /*
    Test case 1:
    go to Techglobal website
    Validate the "Kiwi"
     */


    @BeforeMethod
    public void setPage() {

        driver.get("https://techglobal-training.com/frontend/locators");
    }

    @Test
    public void validateKiwiParagraph() {
        WebElement kiwi_paragraph = driver.findElement(id("item_kiwi"));

        Assert.assertTrue(kiwi_paragraph.isDisplayed()); // Expected by requirements
        Assert.assertEquals(kiwi_paragraph.getText(),"Kiwi");
    }

    /*
    test case 2
    validate "Orange" paragraph
     */

    @Test
    public void validateOrangeParagraph(){
        WebElement orange_paragraph = driver.findElement(name("item_orange"));

        Assert.assertTrue(orange_paragraph.isDisplayed());
        Assert.assertEquals(orange_paragraph.getText(),"Orange");

        System.out.println(orange_paragraph.getAttribute("id")); //empty
        System.out.println(orange_paragraph.getAttribute("name")); // item-orange
        System.out.println(orange_paragraph.getTagName()); //p

        System.out.println(orange_paragraph.getCssValue("font-size"));  //14.4 px
        System.out.println(orange_paragraph.getCssValue("color"));
        System.out.println(orange_paragraph.getCssValue("line-height"));
        System.out.println(orange_paragraph.getCssValue("font-family"));
        System.out.println(orange_paragraph.getCssValue("box-sizing"));
    }

     /*
    Test case 3:
    Go to "https://techglobal-training.com/frontend/locators"
    Validate the "Grapes" paragraph
     */

    @Test
    public void validateGrapesParagraph() {
        WebElement grapes_paragraph = driver.findElement(className("item_grapes"));

        Assert.assertTrue(grapes_paragraph.isDisplayed());
        Assert.assertEquals(grapes_paragraph.getText(),"Grapes");
    }

    /*
    go to website TechGlobal
    validate all "orange, grapes, Kiwi"
     */

    @Test
    public void ValidateAllParagraph(){
       List<WebElement> allParagraphs = driver.findElements(tagName("p"));

//       System.out.println(allParagraphs.size());

//        for (WebElement element:allParagraphs){
//            Assert.assertTrue(element.isDisplayed());
//            System.out.println(element.getText());
//        }
        String [] expectedTexts = {"Kiwi", "Orange", "Grapes"};
        for (int i = 0; i <= 2; i++) {
            Assert.assertTrue(allParagraphs.get(i).isDisplayed());
            Assert.assertEquals(allParagraphs.get(i).getText(), expectedTexts[i]);
        }
    }

    /*
    Test case5:
    validate the redApple Link
     */

    @Test
    public void validateRedAppleLink(){
        WebElement redApple = driver.findElement(By.linkText("Red Apple"));

        Assert.assertTrue(redApple.isDisplayed());
        Assert.assertTrue(redApple.isEnabled());

//        one way-

//        Assert.assertEquals(driver.getCurrentUrl(),"https://en.wikipedia.org/wiki/Red_apple");
//
        Assert.assertEquals(redApple.getAttribute("href"),"https://en.wikipedia.org/wiki/Red_apple");
    }

    /*
Test case 6:
Go to "https://techglobal-training.com/frontend/locators"
Validate the "Red Apple", "Green Apple" and "Pineapple" links (displayed and enabled)
Validate they navigate user to the "https://en.wikipedia.org/wiki/Red_apple", "https://en.wikipedia.org/wiki/Green_apple" and "https://en.wikipedia.org/wiki/Pineapple"
 */

    @Test
    public void validateAllLinks(){
        List<WebElement> allLinks = driver.findElements(By.partialLinkText("ple"));

        String [] expectedVisibleTexts = {"Red Apple", "Green Apple", "Pineapple"};
        String [] expectedLinks = {"https://en.wikipedia.org/wiki/Red_apple","https://en.wikipedia.org/wiki/Green_apple", "https://en.wikipedia.org/wiki/Pineapple"};
        for (int i = 0; i <= 2; i++) {
            Assert.assertTrue(allLinks.get(i).isEnabled());
            Assert.assertTrue(allLinks.get(i).isDisplayed());
            Assert.assertEquals(allLinks.get(i).getText(),expectedVisibleTexts[i]);
            Assert.assertEquals(allLinks.get(i).getAttribute("href"), expectedLinks[i]);
        }
    }
}

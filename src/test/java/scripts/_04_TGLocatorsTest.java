package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;


public class _04_TGLocatorsTest extends Base{

    @BeforeMethod

    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElement(By.id("card-2")).click();
    }

    @Test
    public void validateTheHeader(){

        WebElement header = driver.findElement(By.cssSelector("#main_heading"));

        Assert.assertTrue(header.isDisplayed());
        Assert.assertEquals(header.getText(),"Xpath-CSS Locators");
    }

    /*
    Test case 2:
    validate the languages are"Java", "JavaScript", "C#"
     */

    @Test
    public void validateLanguages(){
        List<WebElement> languages = driver.findElements(By.xpath("(//h3[@class='Xpath_subheader__VOtsU'])[1]/../ul/li"));

        String [] expectedTexts = {"Java","JavaScript","C#"};

        for (int i = 0; i <= 2; i++) {
            Assert.assertTrue(languages.get(i).isDisplayed());
            Assert.assertEquals(languages.get(i).getText(),expectedTexts[i]);

        }
    }

    /*
    Test case 3:
    Go to "https://techglobal-training.com/frontend/"
    Click on "Xpath-CSS Locators" card
    Validate the automation tools are "Selenium WebDriver", "WebDriverIO", "Cypress", "Playwright"
     */

    @Test
    public void ValidateAutomationTools() {


        List<WebElement> automationTools = driver.findElements(By.xpath("(//h3[@class='Xpath_subheader__VOtsU'])[2]/..//li"));

        String[] expectedTools = {"Selenium WebDriver", "WebDriverIO", "Cypress", "Playwright"};

        for (int i = 0; i <= 3; i++) {
            Assert.assertTrue(automationTools.get(i).isDisplayed());
            Assert.assertEquals(automationTools.get(i).getText(),expectedTools[i]);
        }
    }

    /*
    Test case 4:
    Validate headings
     */

    @Test
    public void validateListHeaders(){
        List<WebElement> headers = driver.findElements(By.tagName("h3"));
        String[] expectedHeaders = {"Programming Languages", "Automation Tools"};

        for (int i = 0; i <= 1; i++) {
            Assert.assertTrue(headers.get(i).isDisplayed());
            Assert.assertEquals(headers.get(i).getText(),expectedHeaders[i]);

        }

    }

}

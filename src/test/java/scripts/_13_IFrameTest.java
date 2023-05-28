package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _13_IFrameTest extends Base{
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/iframes");
    }


    @Test (priority = 1, description = "TC123: Validate the IFrame Page content paragraph")
    public void validateTheParagraph() {
        WebElement iframe = driver.findElement(By.id("form_frame"));
        driver.switchTo().frame(iframe);

        WebElement title = driver.findElement(By.cssSelector(".mb-4"));

        Assert.assertTrue(title.isDisplayed());
        Assert.assertEquals(title.getText(), "Please fill out your information below");

        WebElement firstName = driver.findElement(By.cssSelector("label[for='first_name']"));
        Assert.assertTrue(firstName.isDisplayed());


        WebElement firstNameInput = driver.findElement(By.id("first_name"));
        Assert.assertTrue(firstNameInput.isDisplayed());

        WebElement lastName = driver.findElement(By.cssSelector("label[for='last_name']"));
        Assert.assertTrue(lastName.isDisplayed());

        WebElement lastNameInput = driver.findElement(By.id("last_name"));
        Assert.assertTrue(lastNameInput.isDisplayed());
    }

        @Test (priority = 2, description = "TC345 Validate the form submission")
        public void validateTheFormSubmission(){
        WebElement iframe = driver.findElement(By.id("form_frame"));
        driver.switchTo().frame(iframe);

        WebElement firstNameInput = driver.findElement(By.id("first_name"));
        WebElement lastNameInput = driver.findElement(By.id("last_name"));

        firstNameInput.sendKeys("John");
        lastNameInput.sendKeys("Doe");

        WebElement submit = driver.findElement(By.id("submit"));
        Assert.assertTrue(submit.isDisplayed());
        submit.click();

        driver.switchTo().parentFrame();

        WebElement result = driver.findElement(By.id("result"));
        Assert.assertTrue(result.isDisplayed());
        Assert.assertEquals(result.getText(),"You entered: John Doe");


        }
}

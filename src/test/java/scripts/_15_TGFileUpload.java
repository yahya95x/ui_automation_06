package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _15_TGFileUpload extends Base {
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-13")).click();
    }

    @Test
    public void validateUpload(){
        WebElement input = driver.findElement(By.id("file_upload"));
        input.sendKeys("C:\\Users\\yahya\\OneDrive\\Desktop\\bday.png");
        WebElement uploadButton = driver.findElement(By.id("file_submit"));
        uploadButton.click();
    }

    @Test
    public void hello(){
        WebElement input = driver.findElement(By.id("file_upload"));
        WebElement uploadButton = driver.findElement(By.id("file_submit"));

        String filePath = "C:\\Users\\yahya\\IdeaProjects\\ui_automation_6\\hello.txt";

        input.sendKeys(filePath);
        uploadButton.click();

        WebElement result = driver.findElement(By.id("result"));
        Assert.assertEquals(result.getText(),"You Uploaded '" + filePath.substring(filePath.lastIndexOf('\\') +1) + "'");


    }
}

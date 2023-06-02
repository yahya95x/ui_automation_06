package scripts;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _16_TGFileDownload extends Base{
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-14")).click();
    }

    @Test
    public void validateDownload(){
        driver.findElement(By.id("file_download")).click();
    }
}

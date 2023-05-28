package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Practice extends Base{
    @BeforeMethod
    public void setPage(){
        driver.get("https://www.saucedemo.com/");
    }

    @Test
    public void validateAddCart(){
        WebElement loginUserName =driver.findElement(By.id("user-name"));
        WebElement loginPassword =driver.findElement(By.id("password"));
        WebElement login = driver.findElement(By.id("login-button"));

        Assert.assertTrue(loginUserName.isDisplayed());
        loginUserName.sendKeys("standard_user");
        Assert.assertTrue(loginPassword.isDisplayed());
        loginPassword.sendKeys("secret_sauce");
        Assert.assertTrue(login.isDisplayed());
        login.click();

        WebElement cart = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));

        Assert.assertTrue(cart.isDisplayed());
        Assert.assertTrue(cart.isEnabled());
        cart.click();
        WebElement remove = driver.findElement(By.id("remove-sauce-labs-backpack"));
        Assert.assertEquals(remove.getText(),"Remove");
    }
}

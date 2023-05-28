package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.DropDownHandler;

import java.util.List;

public class _11_TGDropdownsTest extends Base{
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend/");
        driver.findElement(By.id("card-5")).click();
    }

    @Test
    public void productDropDownTest() {

//        Select select = new Select(driver.findElement(By.id("product_dropdown"))); old school
//        select.selectByVisibleText("iPhone 14 Pro Max");

        WebElement dropdown = driver.findElement(By.id("product_dropdown"));
        DropDownHandler.selectByVisibleText(dropdown, "iPhone 14 Pro Max");  // new way
    }
    @Test
    public void productColorTest() {
//            Select select2 = new Select(driver.findElement(By.id("color_dropdown")));
//            select2.selectByIndex(1);

        WebElement dropdown = driver.findElement(By.id("color_dropdown"));
        DropDownHandler.selectByIndex(dropdown, 2);
        }

    @Test
    public void productDeliveryTest(){
        WebElement dropdown = driver.findElement(By.id("shipment_dropdown"));
//        dropdown.click();
//
//        WebElement dropdownOption = driver.findElement(By.cssSelector("#shipment_dropdown span:last-child"));
//        dropdownOption.click();
//
//        WebElement dropdownOption2 = driver.findElement(By.cssSelector("#shipment_dropdown span:first-child"));
//        dropdownOption2.click();

        List<WebElement> dropdownOption = driver.findElements(By.cssSelector("#shipment_dropdown span"));

        DropDownHandler.clickDropdownOption(dropdown, dropdownOption, "Delivery");
    }
    /*
    Test case 55
    Go to https://techglobal-training.com/frontend/
Click on the "Dropdowns" card
Select the "MacBook Pro 13" option from the "Product" dropdown.
Select the "Green" option from the "Color" dropdown.
Open the "Shipping" dropdown and click on the "Delivery" option.
Click on the "Submit" button.
Validate result message displays "Your Green MacBook Pro 13 will be delivered to you." (edited)
     */
    @Test
    public void validateResult() {

        WebElement dropdown = driver.findElement(By.id("product_dropdown"));
        DropDownHandler.selectByVisibleText(dropdown,"MacBook Pro 13");

        WebElement dropdown2 = driver.findElement(By.id("color_dropdown"));
        DropDownHandler.selectByVisibleValue(dropdown2,"Green");


        WebElement dropdown3 = driver.findElement(By.id("shipment_dropdown"));
        dropdown3.click();

        List<WebElement> deliveryOptions = driver.findElements(By.cssSelector("#shipment_dropdown span"));
        deliveryOptions.get(0).click();

        driver.findElement(By.id("submit")).click();
        String actualText = driver.findElement(By.id("result")).getText();

        Assert.assertEquals(actualText,"Your Green MacBook Pro 13 will be delivered to you.");
    }
}

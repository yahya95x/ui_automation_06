package Projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import scripts.Base;
import utils.DropDownHandler;

import java.util.List;

public class Project3 extends Base {
    @BeforeMethod
    public void setPage(){
        driver.get("https://techglobal-training.com/frontend");
        driver.findElement(By.id("card-23")).click();
    }

    /*
    Navigate to https://techglobal-training.com/frontend/project-3
    Validate that the “One way” radio button is displayed enabled and selected by default
    Validate that the “Round trip” radio button is displayed enabled and not selected by default
    Validate that the “Cabin Class” label and dropdown are displayed
    Validate that the “From” label and dropdown are displayed
    Validate that the “To” label and dropdown are displayed
    Validate that the “Depart” label and date picker is displayed
    Validate that the “Return” label and date picker is displayed and disabled
    Validate that the “Number of passengers” label and dropdown are displayed and 1 is the default
    Validate that the “Passenger 1” category label and dropdown are displayed and “Adult (16-64)” is the default
    Validate that the “BOOK” button is displayed and enabled
     */
    @Test(priority = 1)
    public void  validateTheDefaultBookYourTrip(){
        WebElement oneWayButton = driver.findElement(By.cssSelector("label [value=\"One way\"]"));

        Assert.assertTrue(oneWayButton.isDisplayed());
        Assert.assertTrue(oneWayButton.isEnabled());
        Assert.assertTrue(oneWayButton.isSelected());

        WebElement roundTripButton = driver.findElement(By.cssSelector("label [value=\"Round trip\"] "));

        Assert.assertTrue(roundTripButton.isDisplayed());
        Assert.assertTrue(roundTripButton.isEnabled());
        Assert.assertFalse(roundTripButton.isSelected());

        WebElement cabinClassLabel = driver.findElement(By.cssSelector(".field:nth-child(2) label"));
        Assert.assertTrue(cabinClassLabel.isDisplayed());

        WebElement cabinClassDropDown = driver.findElement(By.cssSelector(".field:nth-child(2) option"));
        Assert.assertTrue(cabinClassDropDown.isDisplayed());

        WebElement fromLabel = driver.findElement(By.cssSelector(".field:nth-child(3) label"));
        Assert.assertTrue(fromLabel.isDisplayed());

        WebElement fromDropDown = driver.findElement(By.cssSelector(".field:nth-child(3) option"));
        Assert.assertTrue(fromDropDown.isDisplayed());

        WebElement toLabel = driver.findElement(By.cssSelector(".field:nth-child(4) label"));
        Assert.assertTrue(toLabel.isDisplayed());

        WebElement toDropDown = driver.findElement(By.cssSelector(".field:nth-child(4) option"));
        Assert.assertTrue(toDropDown.isDisplayed());

        WebElement departLabel = driver.findElement(By.cssSelector(".field:nth-child(5) label"));
        Assert.assertTrue(departLabel.isDisplayed());

        WebElement departDatePicker = driver.findElement(By.cssSelector(".field:nth-child(5) .control"));
        Assert.assertTrue(departDatePicker.isDisplayed());

        WebElement returnLabel = driver.findElement(By.cssSelector(".field:nth-child(6) label"));
        Assert.assertTrue(returnLabel.isDisplayed());

        WebElement returnDatePicker = driver.findElement(By.cssSelector(".field:nth-child(6) .control"));
        Assert.assertTrue(returnDatePicker.isDisplayed());
        Assert.assertTrue(returnDatePicker.isEnabled());

        WebElement numberOfPassengerLabel = driver.findElement(By.cssSelector(".field:nth-child(7) label"));
        Assert.assertTrue(numberOfPassengerLabel.isDisplayed());

        WebElement numberOfPassengerDropDown = driver.findElement(By.cssSelector(".field:nth-child(7) option"));
        Assert.assertTrue(numberOfPassengerDropDown.isDisplayed());
        Assert.assertEquals(numberOfPassengerDropDown.getAttribute("value"),"1");

        WebElement passengerOneLabel = driver.findElement(By.cssSelector(".field:nth-child(8) label"));
        Assert.assertTrue(passengerOneLabel.isDisplayed());

        WebElement passengerOneDropDown = driver.findElement(By.cssSelector(".field:nth-child(8) option"));
        Assert.assertTrue(passengerOneDropDown.isDisplayed());
        Assert.assertEquals(passengerOneDropDown.getText(),"Adult (16-64)");

        WebElement book = driver.findElement(By.cssSelector("button[type='submit']"));
        Assert.assertTrue(book.isDisplayed());
        Assert.assertTrue(book.isEnabled());
    }

    /*
    Navigate to https://techglobal-training.com/frontend/project-3
    Click on the “Round trip” radio button and validate it is selected
    Validate that the “One way” radio button is not selected
    Validate that the “Cabin Class” label and dropdown are displayed
    Validate that the “From” label and dropdown are displayed
    Validate that the “To” label and dropdown are displayed
    Validate that the “Depart” label and date picker is displayed
    Validate that the “Return” label and date picker is displayed
    Validate that the “Number of passengers” label and dropdown are displayed and 1 is the default
    Validate that the “Passenger 1” label and dropdown are displayed and “Adult (16-64)” is the default
    Validate that the “BOOK” button is displayed and enabled
     */
    @Test(priority = 2)
    public void validateTheBookYourTripFormWhenRoundTripIsSelected(){
        WebElement roundTripButton = driver.findElement(By.cssSelector("label [value=\"Round trip\"] "));
        roundTripButton.click();

        WebElement oneWayButton = driver.findElement(By.cssSelector("label [value=\"One way\"]"));
        Assert.assertFalse(oneWayButton.isSelected());

        WebElement cabinClassLabel = driver.findElement(By.cssSelector(".field:nth-child(2) label"));
        Assert.assertTrue(cabinClassLabel.isDisplayed());

        WebElement cabinClassDropDown = driver.findElement(By.cssSelector(".field:nth-child(2) option"));
        Assert.assertTrue(cabinClassDropDown.isDisplayed());

        WebElement fromLabel = driver.findElement(By.cssSelector(".field:nth-child(3) label"));
        Assert.assertTrue(fromLabel.isDisplayed());

        WebElement fromDropDown = driver.findElement(By.cssSelector(".field:nth-child(3) option"));
        Assert.assertTrue(fromDropDown.isDisplayed());

        WebElement toLabel = driver.findElement(By.cssSelector(".field:nth-child(4) label"));
        Assert.assertTrue(toLabel.isDisplayed());

        WebElement toDropDown = driver.findElement(By.cssSelector(".field:nth-child(4) option"));
        Assert.assertTrue(toDropDown.isDisplayed());

        WebElement departLabel = driver.findElement(By.cssSelector(".field:nth-child(5) label"));
        Assert.assertTrue(departLabel.isDisplayed());

        WebElement departDatePicker = driver.findElement(By.cssSelector(".field:nth-child(5) .control"));
        Assert.assertTrue(departDatePicker.isDisplayed());

        WebElement returnLabel = driver.findElement(By.cssSelector(".field:nth-child(6) label"));
        Assert.assertTrue(returnLabel.isDisplayed());

        WebElement returnDatePicker = driver.findElement(By.cssSelector(".field:nth-child(6) .control"));
        Assert.assertTrue(returnDatePicker.isDisplayed());
        Assert.assertTrue(returnDatePicker.isEnabled());

        WebElement numberOfPassengerLabel = driver.findElement(By.cssSelector(".field:nth-child(7) label"));
        Assert.assertTrue(numberOfPassengerLabel.isDisplayed());

        WebElement numberOfPassengerDropDown = driver.findElement(By.cssSelector(".field:nth-child(7) option"));
        Assert.assertTrue(numberOfPassengerDropDown.isDisplayed());
        Assert.assertEquals(numberOfPassengerDropDown.getAttribute("value"),"1");

        WebElement passengerOneLabel = driver.findElement(By.cssSelector(".field:nth-child(8) label"));
        Assert.assertTrue(passengerOneLabel.isDisplayed());

        WebElement passengerOneDropDown = driver.findElement(By.cssSelector(".field:nth-child(8) option"));
        Assert.assertTrue(passengerOneDropDown.isDisplayed());
        Assert.assertEquals(passengerOneDropDown.getText(),"Adult (16-64)");

        WebElement book = driver.findElement(By.cssSelector("button[type='submit']"));
        Assert.assertTrue(book.isDisplayed());
        Assert.assertTrue(book.isEnabled());
    }
    /*
    Select the “One way” radio button
    Select “Business” for the “Cabin Class” dropdown
    Select “Illinois” for the “From” dropdown
    Select “Florida” for the “To” dropdown
    Select the next week for the ”Depart”
    Select “1” for the “Number of passengers” dropdown
    Select “Senior (65+)” for the Passenger 1 dropdown
    Click on the “BOOK” button
    Validate the booking information displayed below
    DEPART
    IL to FL
    {dynamic date}
    Number of passengers: 1
    Passenger 1: Senior (65+)
    Cabin Class: Business
     */

    @Test(priority = 3)
    public void validateTheBookingFor1PassengerAndOneWay(){
        WebElement oneWayButton = driver.findElement(By.cssSelector("label [value=\"One way\"]"));
        oneWayButton.click();


        List<WebElement> cabinClass = driver.findElements(By.cssSelector(".field:nth-child(2) option"));
        cabinClass.get(2).click();


        List<WebElement> fromState = driver.findElements(By.cssSelector(".field:nth-child(3) option"));
        //fromState.get()

        WebElement toDropDown = driver.findElement(By.cssSelector(".field:nth-child(4) option"));
        DropDownHandler.selectByVisibleText(toDropDown,"Florida");

        WebElement departDatePicker = driver.findElement(By.cssSelector(".field:nth-child(5) .control"));

        WebElement month = driver.findElement(By.cssSelector(".field:nth-child(5) .control input[name='month']"));
        WebElement day = driver.findElement(By.cssSelector(".field:nth-child(5) .control input[name='day']"));
        WebElement year = driver.findElement(By.cssSelector(".field:nth-child(5) .control input[name='year']"));

        month.sendKeys("6");
        day.sendKeys("13");
        year.sendKeys("2023");

        WebElement numberOfPassengerDropDown = driver.findElement(By.cssSelector(".field:nth-child(7) option"));
        DropDownHandler.selectByVisibleText(numberOfPassengerDropDown,"1");

        WebElement passengerOneDropDown = driver.findElement(By.cssSelector(".field:nth-child(8) option"));
        DropDownHandler.selectByVisibleText(passengerOneDropDown,"Senior (65+)");

        WebElement book = driver.findElement(By.cssSelector("button[type='submit']"));
        book.click();


//        System.out.println((driver.findElements(By.cssSelector(".ml-3:nth-child(3)")).get);
    }

    @Test(priority = 4)
    public void validateTheBookingFor1PassengerAndRoundTrip(){

    }

    @Test(priority = 5)
    public void validateTheBookingFor2PassengerAndOneWay(){

    }
}

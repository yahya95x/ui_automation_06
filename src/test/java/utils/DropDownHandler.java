package utils;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownHandler {
    public static void clickDropdownOption(WebElement dropdown, List<WebElement>dropdownOptions, String optionText){
        dropdown.click();
        for (WebElement dropdownOption:dropdownOptions) {
            if(dropdownOption.getText().equals(optionText)) {
                dropdownOption.click();
                break;
            }
        }
    }

    public static void selectByVisibleText(WebElement dropdown, String text){
        new Select(dropdown).selectByVisibleText(text);
    }

    public static void selectByIndex(WebElement dropdown, int index){
        new Select(dropdown).selectByIndex(index);
    }

    public static void selectByVisibleValue(WebElement dropdown, String text){
        new Select(dropdown).selectByValue(text);
    }
}

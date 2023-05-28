package utils;

public class AlertHandler {
    public static void acceptAlert(){
        Driver.getDriver().switchTo().alert().accept();
    }

    public static void dismissAlert(String key){
        Driver.getDriver().switchTo().alert().dismiss();
    }

    public static void sendKeys (String key){
        Driver.getDriver().switchTo().alert().sendKeys(key);
    }

    public static String getAlertText(){
        return Driver.getDriver().switchTo().alert().getText();
    }
}

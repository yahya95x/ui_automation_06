package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private static WebDriver driver;

    private Driver(){}

    public static WebDriver getDriver(){
        if(driver == null){
//            WebDriverManager.firefoxdriver().setup();  // Old school for one browser
//            driver = new FirefoxDriver();

            String browser = ConfigurationReader.getProperty("browser"); // for multiple browsers

            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup(); // Set up driver
                    driver = new FirefoxDriver(); // Launch a driver
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class);
                    driver = new SafariDriver();
                    break;
                case "edge":
                    // TODO implement Microsoft Edge driver instantiation
                    //WebDriverManager.edgedriver().setup();
                    break;
                default:
                    throw new IllegalStateException(browser + " browser does not match any case!!!");
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Integer.parseInt(ConfigurationReader.getProperty("implicit_wait")), TimeUnit.SECONDS);

        }
        return driver;
    }

    public static void quitDriver(){
        if(driver != null){
            driver.manage().deleteAllCookies();
            driver.quit();
            driver = null;
        }
    }
}

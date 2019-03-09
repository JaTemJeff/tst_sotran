package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class WebDriverFactory {

    private static WebDriver driver;

    private WebDriverFactory() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
           
            switch (AppSettings.BROWSER) {
                case CHROME:
                    driver = new ChromeDriver();
                    break;

                case PHATOMJS:
                    driver = new PhantomJSDriver();
                    break;

                case CHROME_HEADLESS:
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("headless");
                    options.addArguments("window-size=1920x1080");
                    driver = new ChromeDriver(options);
                    break;
            }
            
            driver.manage().window().maximize();
            //driver.manage().window().setSize(AppSettings.RESOLUCAO_BROWSER);
        }
        return driver;
    }

    public static void killDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

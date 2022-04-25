package test_utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestUtils {

    public ChromeDriver getConfiguredChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        ChromeDriver driver = new ChromeDriver(chromeOptions);
        driver.executeScript("Object.defineProperty(navigator, 'webdriver', {get: () => undefined})");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        return driver;
    }
}
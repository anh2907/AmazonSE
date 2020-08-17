package seleniumCore.drivers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {
    @Override
    public void createWebDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anhntnguyen\\drivers\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }
}

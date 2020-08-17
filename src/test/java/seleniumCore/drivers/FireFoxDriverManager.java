package seleniumCore.drivers;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FireFoxDriverManager extends DriverManager {
    @Override
    public void createWebDriver() {
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
    }
}

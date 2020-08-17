package seleniumCore.commonLibraries;

import org.openqa.selenium.WebDriver;
import seleniumTest.configuration.UIMap;
import seleniumTest.dataDriven.ReadExcelFile;
import seleniumTest.pageObjectModel.LoginPage;

public class LoginLibrary {
    WebDriver driver;
    LoginPage loginPage;
    ReadExcelFile config;
    String workingDir = System.getProperty("user.dir");
    String configFilePath = workingDir + "\\datafile.properties";
    UIMap uiMap;
    public LoginLibrary(WebDriver driver){
        this.driver = driver;
    }
    public void login() throws Exception {
        loginPage = new LoginPage(driver);
        uiMap = new UIMap(configFilePath);
        config = new ReadExcelFile(uiMap.getData("testDataPath"));
        String userName = config.getData("ValidLoginData", 1,0);
        String password = config.getData("ValidLoginData",1,1);
        loginPage.login(userName, password);
    }
}

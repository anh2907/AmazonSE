package seleniumTest.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import seleniumCore.commonLibraries.LoginLibrary;
import seleniumCore.drivers.DriverManager;
import seleniumCore.drivers.DriverManagerFactory;
import seleniumCore.drivers.DriverType;
import seleniumTest.configuration.UIMap;
import seleniumTest.dataDriven.LoginDataProvider;
import seleniumTest.dataDriven.ReadExcelFile;
import seleniumTest.pageObjectModel.LoginPage;
//@Listeners (seleniumTest.reports.TestListeners.class)
public class LoginValidationTests {
    DriverManager driverManager;
    public WebDriver driver;
    LoginPage loginPage;
    LoginLibrary loginLibrary;
    ReadExcelFile readExcelFile;
    public UIMap uiMap;

    @BeforeMethod
    public void setUp() throws Exception {
        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getWebDriver();
        loginPage = new LoginPage(driver);
        loginLibrary = new LoginLibrary(driver);
        String workingDir = System.getProperty("user.dir");
        String configFilePath = workingDir +"\\datafile.properties";
        uiMap = new UIMap(configFilePath);
        readExcelFile = new ReadExcelFile(uiMap.getData("testDataPath"));
        driver.get(uiMap.getData("url"));
        driver.manage().window().maximize();
        Assert.assertEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more",driver.getTitle());
    }
    @Test(description = "Verify login test with valid credentials")
    public void loginSuccessTest() throws Exception {
        loginLibrary.login();
        Thread.sleep(700);
        String loginSuccessMsg = loginPage.getLoginSuccessMsg();
        Assert.assertEquals(loginSuccessMsg, "Hello, Nguyen");
    }
    @Test(dataProvider = "InValidEmail", dataProviderClass = LoginDataProvider.class)
    public void verifyLoginWithInvalidEmail (String email){
        loginPage.clickSignInLink();
        loginPage.setEmailInput(email);
        loginPage.clickContinueButton();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.inValidEmailMessage));
        Assert.assertEquals(loginPage.getInvalidEmailMsg(),"We cannot find an account with that email address");

    }
    @Test (description = "Verify login with blank email")
    public void verifyLoginWithBlankEmail()
    {
        loginPage.clickSignInLink();
        loginPage.setEmailBlank();
        loginPage.clickContinueButton();
        WebDriverWait wait = new WebDriverWait(driver, 1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.blankEmailMessage));
        Assert.assertEquals(loginPage.getBlankEmailMsg(),"Enter your email or mobile phone number");
    }
    @Test (dataProvider = "InValidPassword", dataProviderClass = LoginDataProvider.class)
    public void verifyLoginWithInvalidPassword(String password) throws InterruptedException {
        loginPage.clickSignInLink();
        String userName = readExcelFile.getData("ValidLoginData", 1,0);
        loginPage.setEmailInput(userName);
        loginPage.clickContinueButton();
        //Thread.sleep(30000);
        loginPage.setPasswordInput(password);
        loginPage.clickSignInButton();
        WebDriverWait wait = new WebDriverWait(driver,1);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.inValidPasswordMessage));
        Assert.assertEquals(loginPage.getInvalidPasswordMsg(),"Your password is incorrect");
    }
    @AfterMethod
    public void tearDown(){
        driverManager.quitWebDriver();
    }
}

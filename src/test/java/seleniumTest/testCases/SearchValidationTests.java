package seleniumTest.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import seleniumCore.commonLibraries.LoginLibrary;
import seleniumCore.commonLibraries.SearchLibrary;
import seleniumCore.drivers.DriverManager;
import seleniumCore.drivers.DriverManagerFactory;
import seleniumCore.drivers.DriverType;
import seleniumTest.configuration.UIMap;
import seleniumTest.dataDriven.SortOptionData;

import seleniumTest.pageObjectModel.SearchPage;
//@Listeners(seleniumTest.reports.SearchValidationListeners.class)
public class SearchValidationTests {
    DriverManager driverManager;
    public WebDriver driver;
    SearchPage searchPage;
    LoginLibrary loginLibrary;
    SearchLibrary searchLibrary;
    UIMap uiMap;

    @BeforeMethod
    public void setUp() throws Exception {
        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getWebDriver();

        String workingDir = System.getProperty("user.dir");
        String configFilePath = workingDir + "\\datafile.properties";
        uiMap = new UIMap(configFilePath);
        driver.get(uiMap.getData("url"));
        driver.manage().window().maximize();
        searchPage = new SearchPage(driver);
        loginLibrary = new LoginLibrary(driver);
        searchLibrary = new SearchLibrary(driver);
    }

    @Test
    public void verifyPaging() throws Exception {
        loginLibrary.login();
        Thread.sleep(600);
        searchLibrary.performSearch();
        Assert.assertEquals(searchPage.getResultList(), 16);
        searchPage.clickNextButton();
        Assert.assertEquals(searchPage.getResultList(), 16);

    }
    @Test()
    public void verifySortByOption() throws Exception {
        loginLibrary.login();
        Thread.sleep(600);
        searchLibrary.performSearch();
        Thread.sleep(600);
        searchPage.clickSortList();
        searchPage.clickOptionPriceLowToHigh();
        Thread.sleep(600);
        //Assert.assertEquals(searchResultPage.getSelectedSortItem(),"Price: Low to High");
        Assert.assertEquals(searchPage.getSelectedSortItem(), SortOptionData.OptionPriceLowToHigh.getSortOption());

    }
    @AfterMethod
    public void tearDown(){
        driverManager.quitWebDriver();
    }
}

package seleniumCore.commonLibraries;

import org.openqa.selenium.WebDriver;
import seleniumTest.configuration.UIMap;
import seleniumTest.dataDriven.ReadExcelFile;
import seleniumTest.pageObjectModel.SearchPage;

public class SearchLibrary {
    ReadExcelFile config;
    SearchPage searchPage;
    WebDriver driver;
    String workingDir = System.getProperty("user.dir");
    String configFilePath = workingDir + "\\datafile.properties";
    UIMap uiMap;
    public SearchLibrary(WebDriver driver){
        this.driver = driver;
    }
    public void performSearch() throws Exception {
        uiMap = new UIMap(configFilePath);
        config = new ReadExcelFile(uiMap.getData("testDataPath"));
        searchPage = new SearchPage(driver);
        String keyword;
        config = new ReadExcelFile(uiMap.getData("testDataPath"));
        keyword = config.getData("Search",1,1);
        searchPage.performSearch(keyword);
    }
}

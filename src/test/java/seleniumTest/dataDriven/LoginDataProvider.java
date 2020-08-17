package seleniumTest.dataDriven;

import org.testng.annotations.DataProvider;
import seleniumTest.configuration.UIMap;

public class LoginDataProvider {
    String workingDir = System.getProperty("user.dir");
    String configFilePath = workingDir + "\\datafile.properties";
    UIMap uiMap;
    @DataProvider(name = "ValidLoginData")
    public Object[][] getLoginData() throws Exception {
        //Object[][] data ={{"sunflower837@yahoo.com", "Kms@2018"}};
        uiMap = new UIMap(configFilePath);
        ReadExcelFile config = new ReadExcelFile(uiMap.getData("testDataPath"));
        int rows = config.getRowCount("ValidLoginData");
        Object[][] data = new Object[rows][2];
        for(int i=0;i<rows;i++)
        {
            data[i][0] = config.getData("ValidLoginData", i, 0);
            data[i][1] = config.getData("ValidLoginData", i, 1);
        }
        return data;
    }
    @DataProvider(name = "InValidEmail")
    public Object[][] getInvalidEmail() throws Exception {
        //Object[][] data = {{"abc@yahoo"},{"testabc@"},{"~!@#$%^&*()"}};
        uiMap = new UIMap(configFilePath);
        ReadExcelFile config = new ReadExcelFile(uiMap.getData("testDataPath"));
        int rows = config.getRowCount("InValidEmail");
        Object[][] data = new Object[rows][1];
        for(int i=0;i<rows;i++)
        {
            data[i][0] = config.getData("InValidEmail", i, 0);
        }
        return data;
    }
    @DataProvider(name="InValidPassword")
    public Object[][] getInvalidPassword() throws Exception {
        //Object[][] data = {{"123456"},{"testabc"},{"!@#$%^&*"}};
        uiMap = new UIMap(configFilePath);
        ReadExcelFile config = new ReadExcelFile(uiMap.getData("testDataPath"));
        int rows = config.getRowCount("InValidPassword");
        Object[][] data = new Object[rows][1];
        for(int i=0;i<rows;i++)
        {
            data[i][0] = config.getData("InValidPassword", i, 0);
        }
        return data;
    }
}

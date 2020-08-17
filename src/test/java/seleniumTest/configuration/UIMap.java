package seleniumTest.configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class UIMap {
    Properties properties;

    public UIMap(String filePath) {

        try {
            File src = new File(filePath);
            FileInputStream fis = new FileInputStream(src);
            properties= new Properties();
            properties.load(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public String getData(String elementName) throws Exception {
        // Read value using the logical name as Key
        String data = properties.getProperty(elementName);
        return data;
    }
}

package seleniumTest.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.util.Date;

public class ExtentManager {
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentReports createInstance()
    {
        String fileName = getReportName();
        String directory = System.getProperty("user.dir") + "/reports/";
        new File(directory).mkdirs();
        String path = directory + fileName;
        htmlReporter = new ExtentHtmlReporter(path);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setDocumentTitle("Automation Reports");
        htmlReporter.config().setReportName("Automation Test Results");
        htmlReporter.config().setTheme(Theme.STANDARD);
        extent = new ExtentReports();
        extent.setSystemInfo("Organization", "KMS");
        extent.setSystemInfo("Host", "local");
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester", "Anh Nguyen");
        extent.setSystemInfo("Browser", "Chrome");
        extent.attachReporter(htmlReporter);
        return extent;
    }
    public static String getReportName(){
        Date d= new Date();
        String fileName = "AutomationReport_"+ d.toString().replace(":","_").replace(" ", "_")+ ".html";
        return fileName;
    }
}

Exercise#3 (Automation testing)
This exercise is done by using Selenium Web Driver, Testng framework and Maven to manage project (dependencies/versions)

I have just finished 2 test cases: 
	+ TC1: Verify there are 3 options for "Loại BĐS" when user selects "Loại hình giao dịch" is "Bán"
	+ TC2: Verify there are 2 options for "Loại BĐS" when user selects "Loại hình giao dịch" is "Cho thuê"

Please review below steps to run the test scripts:
----------------------

1. Open the project by an IDE (IntelliJ IDEA)
2. Install/Reload all Maven projects
3. On the file AmazonSE\src\test\java\seleniumCore\drivers
Change System.setProperty("webdriver.chrome.driver", "C:\\Users\\anhntnguyen\\drivers\\chromedriver.exe"); 
to your chromedriver path
4. Run testng.xml file

 
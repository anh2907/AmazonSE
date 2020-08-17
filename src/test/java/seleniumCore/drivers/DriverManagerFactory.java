package seleniumCore.drivers;

public class DriverManagerFactory {

    public static DriverManager getDriverManager(DriverType type){
        DriverManager driverManager;
        switch (type){
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case SAFARI:
                driverManager = new SafariDriverManager();
                break;
            default:
                driverManager = new FireFoxDriverManager();
                break;
        }
        return driverManager;
    }
}

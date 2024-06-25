package baseDir.driverUtils;

import utils.DataReader;
import utils.LogUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.io.File;
import java.net.URL;

public class DriverManager {
    private static DriverManager instance;
    private static AndroidDriver driver;

    private DriverManager() {
    }

    public static synchronized DriverManager getInstance() {
        if (instance == null) {
            instance = new DriverManager();
        }
        return instance;
    }

    private void initializeDriver() {
        LogUtils.info("initialization of driver started");
        try {
            AppiumServer appiumServer = new AppiumServer();
            appiumServer.start();

            String relativePath = DataReader.readCapabilities("app");
            File file = new File(relativePath);
            String absolutePath = file.getAbsolutePath();

            UiAutomator2Options options = new UiAutomator2Options()
                    .setPlatformName(DataReader.readCapabilities("platformName"))
                    .setPlatformVersion(DataReader.readCapabilities("platformVersion"))
                    .setAutomationName(DataReader.readCapabilities("automationName"))
                    .setApp(absolutePath)
                    .setAppPackage(DataReader.readCapabilities("appPackage"))
                    .setAutoGrantPermissions(true)
                    .setAppActivity(DataReader.readCapabilities("appActivity"));

            driver = new AndroidDriver(new URL(DataReader.readConfig("port")), options);
        } catch (Exception e) {
            LogUtils.error("Exception occurred during initializeDriver method: " + e.getMessage());
        }
    }

    public synchronized AndroidDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    public synchronized void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}

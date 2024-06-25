package baseDir;

import baseDir.driverUtils.DriverManager;
import utils.DataReader;
import utils.LogUtils;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class WaitUtils {

    private static AppiumDriver getDriver() {
        return DriverManager.getInstance().getDriver();
    }

    private static WebDriverWait getWait() {
        Duration timeout = Duration.ofSeconds(Integer.parseInt(DataReader.readConfig("timeout")));
        return new WebDriverWait(getDriver(), timeout);
    }

    public static void waitForElementToBeClickable(By locator) {
        try {
            getWait().until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException e) {
            LogUtils.warn("Element " + locator + " not clickable within timeout");
            throw e;
        }
    }

    public static void waitForElementToBeVisible(By locator) {
        try {
            getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            LogUtils.warn("Element " + locator + " not visible within timeout");
            throw e;
        }
    }

    public static boolean waitForTextToBePresentInElement(By locator, String expectedString) {
        try {
            return getWait().until(ExpectedConditions.textToBePresentInElementLocated(locator, expectedString));
        } catch (TimeoutException e) {
            LogUtils.warn("Element " + locator + " not present within timeout");
            throw e;
        }
    }

    public static boolean waitForInvisibilityOfElementLocated(By locator) {
        try {
            return getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            LogUtils.warn("Element " + locator + " not invisible within timeout");
            throw e;
        }
    }

    public static void waitForPresenceOfElementLocated(By locator) {
        try {
            getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
        } catch (TimeoutException e) {
            LogUtils.warn("Element " + locator + " not presence within timeout");
            throw e;
        }
    }
}



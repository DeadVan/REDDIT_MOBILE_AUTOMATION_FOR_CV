package baseDir;

import baseDir.elements.BaseElement;
import utils.LogUtils;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;

public abstract class BaseForm {
    protected AndroidDriver driver;
    BaseElement uniqueFormLocator;
    String formName;
    public BaseForm(BaseElement locator, String name,AndroidDriver driver){
        uniqueFormLocator = locator;
        formName = name;
        this.driver = driver;

    }

    public boolean isFormOpen() {
        try {
            WaitUtils.waitForPresenceOfElementLocated(uniqueFormLocator.getLocator());
            LogUtils.info("checking if form is open " + uniqueFormLocator.getText());
            return uniqueFormLocator.isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            LogUtils.error("form was not open");
            return false;
       }
    }
}
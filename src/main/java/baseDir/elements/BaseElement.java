package baseDir.elements;
import baseDir.WaitUtils;
import baseDir.driverUtils.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.*;

import java.util.List;

public class BaseElement {
    protected AndroidDriver driver;
    protected By uniquelocator;


    public BaseElement(By locator) {
        this.driver = DriverManager.getInstance().getDriver();
        this.uniquelocator = locator;
    }

    protected WebElement findElement() {
        return driver.findElement(uniquelocator);
    }
    public List<WebElement> findElements(By uniquelocator){
        return driver.findElements(uniquelocator);
    }

    public void click() {
        findElement().click();
    }


    public String getText() {
        return findElement().getText();
    }


    public boolean isDisplayed() {
        try {
            WaitUtils.waitForElementToBeVisible(uniquelocator);
            return findElement().isDisplayed();
        } catch (NoSuchElementException | StaleElementReferenceException | TimeoutException e) {
            return false;
        }
    }

    public WebElement toWebElement() {
        return findElement();
    }

    public By getLocator() {
        return uniquelocator;
    }
}

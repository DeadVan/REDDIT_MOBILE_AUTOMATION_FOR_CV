package pom;

import baseDir.BaseForm;
import baseDir.WaitUtils;
import baseDir.elements.Button;
import baseDir.elements.Label;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;


public class SettingsPage extends BaseForm {
    public SettingsPage(AndroidDriver driver) {
        super(new Label(AppiumBy.xpath("//android.widget.TextView[@text=\"Settings\"]")), "settings label", driver);
    }
    private final Button accSettings = new Button(AppiumBy.xpath("(//android.widget.ImageView[@resource-id=\"com.reddit.frontpage:id/arrow\"])[1]"));

    public void clickAccSettingBtn() {
        WaitUtils.waitForElementToBeVisible(accSettings.getLocator());
        accSettings.click();
    }
}
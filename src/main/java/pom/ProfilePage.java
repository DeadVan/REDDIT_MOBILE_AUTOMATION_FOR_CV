package pom;

import baseDir.BaseForm;
import baseDir.WaitUtils;
import baseDir.elements.Button;
import baseDir.elements.Label;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;


public class ProfilePage extends BaseForm {
    public ProfilePage(AndroidDriver driver) {
        super(new Label(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.reddit.frontpage:id/nav_user_name\"]")), "username", driver);
    }
    private final Button settingsBtn = new Button(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.reddit.frontpage:id/drawer_nav_settings\"]"));


    public void clickSettingBtn() {
        WaitUtils.waitForElementToBeVisible(settingsBtn.getLocator());
        settingsBtn.click();
    }
}
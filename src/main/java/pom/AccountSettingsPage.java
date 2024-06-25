package pom;

import baseDir.BaseForm;
import baseDir.WaitUtils;
import baseDir.elements.Button;
import baseDir.elements.Label;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;


public class AccountSettingsPage extends BaseForm {
    public AccountSettingsPage(AndroidDriver driver) {
        super(new Label(AppiumBy.xpath("//android.widget.TextView[@text=\"Account settings\"]")), "account settings label", driver);
    }

    private final Button switchAppBtn = new Button(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.reddit.frontpage:id/setting_title\" and @text=\"Switch accounts\"]"));
    private final Button removeAccBtn = new Button(AppiumBy.accessibilityId("Remove account"));
    private final Button logoutBtn = new Button(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.reddit.frontpage:id/confirm_remove_account_logout\"]"));


    public void clickSwitchAppBtn() {
        WaitUtils.waitForElementToBeVisible(switchAppBtn.getLocator());
        switchAppBtn.click();
    }

    public void clickRemoveAccBtn() {
        WaitUtils.waitForElementToBeVisible(removeAccBtn.getLocator());
        removeAccBtn.click();
    }

    public void clickLogoutBtn() {
        WaitUtils.waitForElementToBeVisible(logoutBtn.getLocator());
        logoutBtn.click();
    }
}
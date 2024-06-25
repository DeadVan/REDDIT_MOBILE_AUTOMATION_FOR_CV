package pom;

import baseDir.BaseForm;
import baseDir.WaitUtils;
import baseDir.elements.Button;
import baseDir.elements.Checkbox;
import baseDir.elements.Label;
import baseDir.elements.TextBox;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AuthorizationPage extends BaseForm {
    public AuthorizationPage(AndroidDriver driver) {
        super(new Label(AppiumBy.xpath("//android.widget.TextView[@text='Enter your login information']")),"enter info text", driver);
    }

    private final TextBox emailUsernameField = new TextBox(AppiumBy.xpath("//android.widget.EditText[@resource-id='text_auto_fill']"));
    private final TextBox passwordField = new TextBox(AppiumBy.xpath("//android.view.View[@resource-id='password_text_field']/android.widget.EditText"));
    private final Button continueBtn = new Button(AppiumBy.xpath("//android.widget.TextView[@resource-id='continue_button_label' and @text='Continue']"));

    public void fillEmailUsernameField(String emailOrUsername){
        WaitUtils.waitForElementToBeVisible(emailUsernameField.getLocator());
        emailUsernameField.setText(emailOrUsername);
    }

    public void fillPasswordField(String password){
        WaitUtils.waitForElementToBeVisible(passwordField.getLocator());
        passwordField.setText(password);
    }

    public void clickContinueBtn(){
        WaitUtils.waitForElementToBeClickable(continueBtn.getLocator());
        continueBtn.click();
    }


}
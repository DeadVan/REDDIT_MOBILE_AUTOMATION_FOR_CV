package pom;

import baseDir.BaseForm;
import baseDir.elements.Button;
import baseDir.elements.Checkbox;
import baseDir.elements.Label;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
public class LandingPage extends BaseForm {
    public LandingPage(AndroidDriver driver) {
        super(new Label(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"onboarding_title\"]")),"login title", driver);
    }

    private final Button googleAuth = new Button(AppiumBy.accessibilityId("Continue with Google"));
    private final Button mailAuth = new Button(AppiumBy.accessibilityId("Use email or username"));
    private final Label privacyPolicy = new Label(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"onboarding_agreement\"]"));

    private final Label emailSubscriptionText = new Label(AppiumBy.xpath("//android.view.View[@resource-id=\"onboarding_email_subscription_label\"]"));
    private final Checkbox emailSubscriptionCheck = new Checkbox(AppiumBy.xpath("//android.view.View[@resource-id=\"onboarding_email_subscription_checkbox\"]"));
    private final Button signUpBtn = new Button(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"login_signup_button\"]"));


    public boolean googleAuthIsDisplayed(){
        return googleAuth.isDisplayed();
    }
    public boolean mailAuthIsDisplayed(){
        return mailAuth.isDisplayed();
    }
    public boolean privacyPolicyIsDisplayed() {
        return privacyPolicy.isDisplayed();
    }
    public boolean emailSubscriptionTextIsDisplayed(){
        return emailSubscriptionText.isDisplayed();
    }

    public boolean emailSubscriptionCheckIsDisplayed(){
        return emailSubscriptionCheck.isDisplayed();
    }
    public boolean signUpBtnIsDisplayed(){
        return signUpBtn.isDisplayed();
    }

    public void clickMailAuthBtn(){
        mailAuth.click();
    }
}
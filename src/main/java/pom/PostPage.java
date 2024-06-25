package pom;

import baseDir.BaseForm;
import baseDir.elements.Button;
import baseDir.elements.Label;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;


public class PostPage extends BaseForm {
    public PostPage(AndroidDriver driver) {
        super(new Label(AppiumBy.xpath("//android.view.View[@resource-id=\"share_button\"]/android.view.View/android.widget.Button")), "share button", driver);
    }

    private final Label postedWhenAndByWho = new Label(AppiumBy.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id=\"com.reddit.frontpage:id/detail_list\"]//android.widget.LinearLayout"));
    private final Label commentText = new Label(AppiumBy.xpath("//android.view.View[@resource-id=\"comments_count\"]//android.widget.TextView"));
    private final Button profileLogoBtn = new Button(AppiumBy.accessibilityId("Logged in avatar"));


    public String getInfo() {
        return postedWhenAndByWho.getText();
    }

    public String getCommentQuantity() {
        return commentText.getText();
    }

    public void clickProfileLogoBtn(){
        profileLogoBtn.click();
    }


}
package pom;

import baseDir.Actions;
import baseDir.BaseForm;
import baseDir.WaitUtils;
import baseDir.elements.Button;
import baseDir.elements.Label;
import baseDir.elements.TextBox;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import utils.LogUtils;
import java.util.List;


public class HomePage extends BaseForm {
    public HomePage(AndroidDriver driver) {
        super(new Label(AppiumBy.accessibilityId("Home feed")), "reddit Title", driver);
    }

    private final Button searchBtn = new Button(AppiumBy.accessibilityId("Search"));
    private final TextBox searchField = new TextBox(AppiumBy.xpath("//android.widget.EditText[@resource-id='com.reddit.frontpage:id/search']"));
    private final Button sortBtn = new Button(AppiumBy.accessibilityId("Sort by Most relevant"));
    private final Button hotOption = new Button(AppiumBy.xpath("//android.widget.Button[@content-desc='Sort by Hot']"));
    private final Label hotOptionLabel = new Label(AppiumBy.accessibilityId("Sort by Hot"));
    private final Label feedContainer = new Label(AppiumBy.xpath("//android.view.View[@resource-id=\"feed_lazy_column\"]"));


    public void clickSearchBtn() {
        searchBtn.click();
    }

    public void fillSearchField(String keyword) {
        searchField.setText(keyword);
        driver.executeScript("mobile: performEditorAction", ImmutableMap.of("action", "search"));

    }

    public void clickSortBtn() {
        WaitUtils.waitForElementToBeVisible(sortBtn.getLocator());
        sortBtn.click();
    }

    public void clickHotSortingOption() {
        WaitUtils.waitForElementToBeVisible(hotOption.getLocator());
        hotOption.click();
    }

    public boolean hotOptionIsChosen() {
        WaitUtils.waitForPresenceOfElementLocated(hotOptionLabel.getLocator());
        return hotOptionLabel.isDisplayed();
    }

    public List<WebElement> getListOfPosts() {
        return feedContainer.findElements(AppiumBy.xpath("//android.view.View[@resource-id='search_post_section']"));
    }

    public void clickMostUpVotedPost(String xpathValue) {
        LogUtils.info("scroll to most upVoted post and click");
        boolean found = false;
        int maxScrollAttempts = 10;
        int attempts = 0;

        while (!found && attempts < maxScrollAttempts) {
            try {
                Button post = new Button(AppiumBy.xpath("//android.view.View[@content-desc=\"" + xpathValue + "\"]"));
                WaitUtils.waitForElementToBeVisible(post.getLocator());
                post.click();
                found = true;
            } catch (TimeoutException e) {
                Actions.scrollUp();
                attempts++;
            }
        }
    }
}
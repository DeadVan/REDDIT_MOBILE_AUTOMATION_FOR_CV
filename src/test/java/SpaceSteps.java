
import baseDir.Actions;
import baseDir.driverUtils.DriverManager;
import utils.Helper;
import utils.LogUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import java.util.*;

import static utils.PostDto.postDto;

public class SpaceSteps extends BaseTest {

    @Step("verify that landing page was open")
    public void assertVerifyLandingPageIsOpen() {
        LogUtils.info("verify that landing page was open");
        Assert.assertTrue(landingPage.isFormOpen(), "reddit landing page was not open!");
    }

    @Step("verify that authorization options displayed")
    public void assertVerifyAuthorizationOptionsDisplayed() {
        LogUtils.info("verify that authorization options displayed");
        Assert.assertTrue(landingPage.googleAuthIsDisplayed(), "google authorization was not open!");
        Assert.assertTrue(landingPage.mailAuthIsDisplayed(), "mail authorization was not open!");
    }

    @Step("verify that landing page title and privacy policy displayed")
    public void assertVerifyPrivacyPolicyAndSignUpIsDisplayed() {
        LogUtils.info("verify that landing page title and privacy policy displayed");
        Assert.assertTrue(landingPage.privacyPolicyIsDisplayed());
        Assert.assertTrue(landingPage.emailSubscriptionTextIsDisplayed());
        Assert.assertTrue(landingPage.emailSubscriptionCheckIsDisplayed());
        Assert.assertTrue(landingPage.signUpBtnIsDisplayed());

    }

    @Step("navigate to mail authorization")
    public void navigateToMailAuthorization() {
        LogUtils.info("navigate to mail authorization");
        landingPage.clickMailAuthBtn();
    }

    @Step("verify authorization page was open")
    public void assertVerifyAuthorizationPageIsOpen() {
        LogUtils.info("verify authorization page was open");
        Assert.assertTrue(authorizationPage.isFormOpen(), "Authorization page was not open!");

    }

    @Step("fill authorization fields")
    public void fillEmailAndPasswordFieldsAndClickContinue(String email, String password) {
        LogUtils.info("fill authorization fields");
        authorizationPage.fillEmailUsernameField(email);
        authorizationPage.fillPasswordField(password);
        authorizationPage.clickContinueBtn();
    }

    @Step("verify home page was open")
    public void assertVerifyHomePageIsOpen() {
        LogUtils.info("verify home page was open");
        Assert.assertTrue(homePage.isFormOpen(), "home page was not open!");
    }

    @Step("using searching option")
    public void searchWithDesiredWord(String word) {
        LogUtils.info("using searching option");
        homePage.clickSearchBtn();
        homePage.fillSearchField(word);
    }

    @Step("sort using hot option")
    public void sortWithHotOptionAndAssertItWasChosen() {
        LogUtils.info("sort using hot option");
        homePage.clickSortBtn();
        homePage.clickHotSortingOption();
        Assert.assertTrue(homePage.hotOptionIsChosen(), "hot option was not chosen");
    }

    @Step("getting unique 20 posts from feed")
    public void getUniquePosts(int desiredCount) {
        LogUtils.info("getting unique 20 posts from feed");
        Set<String> uniqueTags = new HashSet<>();
        List<WebElement> uniqueElements = new ArrayList<>();
        int maxAttempts = 8;
        int attempts = 0;

        while (uniqueElements.size() < desiredCount && attempts < maxAttempts) {
            List<WebElement> posts = homePage.getListOfPosts();

            for (WebElement post : posts) {
                String postTag = post.getTagName();
                if (!uniqueTags.contains(postTag)) {
                    uniqueTags.add(postTag);
                    uniqueElements.add(post);
                }

                if (uniqueElements.size() == desiredCount) {
                    break;
                }
            }
            if (uniqueElements.size() < desiredCount) {
                Actions.scroll(DriverManager.getInstance().getDriver(), "down", 454, 1885, 462, 900);
                attempts++;
            }
        }
        for (String tag : uniqueTags) {
            LogUtils.info(tag);
        }
        postDto.setPostTagName(Helper.findTagWithMostUpVotes(uniqueTags));
        LogUtils.warn("MOST UPVOTED TAGNAME _ >>>>> " + postDto.getPostTagName());
    }

    @Step("scroll to most upVoted post and click")
    public void scrollToMostUpVotedPostAndClick() {
        LogUtils.info("scroll to most upVoted post and click");
        homePage.clickMostUpVotedPost(postDto.getPostTagName());
    }

    @Step("verify post page was open")
    public void assertVerifyPostPageIsOpen() {
        LogUtils.info("verify post page was open");
        Assert.assertTrue(postPage.isFormOpen(), "Authorization page was not open!");
    }

    @Step("getting info about post")
    public void getAndLogPostTimeCommentAndUser() {
        LogUtils.info("getting info about post");
        LogUtils.warn("Commented - - > " + postPage.getCommentQuantity());
        LogUtils.warn("Info about Who posted when and how many comments are there  -- " + postPage.getInfo());
    }

    @Step("logout flow")
    public void logoutFlow(){
        LogUtils.info("logout flow");
        postPage.clickProfileLogoBtn();
        profilePage.clickSettingBtn();
        settingsPage.clickAccSettingBtn();
        accountSettingsPage.clickSwitchAppBtn();
        accountSettingsPage.clickRemoveAccBtn();
        accountSettingsPage.clickLogoutBtn();
    }

}

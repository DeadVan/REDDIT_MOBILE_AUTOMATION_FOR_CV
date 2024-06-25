import utils.DataReader;
import io.qameta.allure.*;
import org.testng.annotations.Test;

public class RedditTest extends BaseTest{

    private static final SpaceSteps spaceSteps = new SpaceSteps();


    @Test(testName = "Test Space Flow")
    @Epic("reddit")
    @Severity(SeverityLevel.BLOCKER)
    @Story("testing hottest posts")
    @Description("see hottest post and get info flow")
    public void RedditTestPlease() {
        spaceSteps.assertVerifyLandingPageIsOpen();
        spaceSteps.assertVerifyAuthorizationOptionsDisplayed();
        spaceSteps.assertVerifyPrivacyPolicyAndSignUpIsDisplayed();
        spaceSteps.navigateToMailAuthorization();
        spaceSteps.assertVerifyAuthorizationPageIsOpen();
        spaceSteps.fillEmailAndPasswordFieldsAndClickContinue(DataReader.readCredentials("mail"), DataReader.readCredentials("password"));
        spaceSteps.assertVerifyHomePageIsOpen();
        spaceSteps.searchWithDesiredWord("banking");
        spaceSteps.sortWithHotOptionAndAssertItWasChosen();
        spaceSteps.getUniquePosts(20);
        spaceSteps.scrollToMostUpVotedPostAndClick();
        spaceSteps.assertVerifyPostPageIsOpen();
        spaceSteps.getAndLogPostTimeCommentAndUser();
        spaceSteps.logoutFlow();
    }
}

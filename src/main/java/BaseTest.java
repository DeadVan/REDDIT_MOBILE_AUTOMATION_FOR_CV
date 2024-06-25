import baseDir.driverUtils.DriverManager;
import pom.*;
import utils.LogUtils;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    static LandingPage landingPage;
    static AuthorizationPage authorizationPage;
    static HomePage homePage;
    static PostPage postPage;
    static ProfilePage profilePage;
    static SettingsPage settingsPage;
    static  AccountSettingsPage accountSettingsPage;

    @BeforeMethod
    public void setup(){
        LogUtils.info("Starting driver and pom initialization");
        AndroidDriver driver = DriverManager.getInstance().getDriver();
        landingPage = new LandingPage(driver);
        authorizationPage = new AuthorizationPage(driver);
        homePage = new HomePage(driver);
        postPage = new PostPage(driver);
        profilePage = new ProfilePage(driver);
        settingsPage = new SettingsPage(driver);
        accountSettingsPage = new AccountSettingsPage(driver);

    }


    @AfterMethod
    public void quitDriver(){
        LogUtils.info("Starting to finish and quit driver");
        DriverManager.getInstance().quitDriver();
    }
}

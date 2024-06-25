package baseDir;

import baseDir.driverUtils.DriverManager;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Actions {

    private static AndroidDriver getDriver() {
        return DriverManager.getInstance().getDriver();
    }

    public static void tap(){
        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var tapPoint = new Point(775, 1563);
        var tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new Pause(finger, Duration.ofMillis(50)));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        getDriver().perform(List.of(tap));
    }

    public static void scroll(AppiumDriver driver,String direction, int startX, int startY, int endX, int endY) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Dimension dimension = getDriver().manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        Map<String, Object> params = new HashMap<>();
        params.put("direction", direction);
        params.put("percent", 0.75);
        params.put("left", 0);
        params.put("top", 0);
        params.put("width", width);
        params.put("height", height);
        params.put("startX", startX);
        params.put("startY", startY);
        params.put("endX", endX);
        params.put("endY", endY);
        js.executeScript("mobile: scrollGesture", params);
    }

    public static void scrollUp(){
        final var finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        var start = new Point(458, 722);
        var end = new Point (458, 1700);
        var swipe = new Sequence(finger, 1);
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), start.getX(), start.getY()));
        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), end.getX(), end.getY()));
        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        getDriver().perform(Arrays.asList(swipe));
    }
}


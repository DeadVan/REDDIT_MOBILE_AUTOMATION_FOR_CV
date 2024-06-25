package baseDir.elements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Checkbox extends BaseElement {
    public Checkbox(By locator) {
        super(locator);
    }

    public void check() {
        if (!isSelected()) {
            click();
        }
    }

    public void uncheck() {
        if (isSelected()) {
            click();
        }
    }

    private boolean isSelected() {
        WebElement checkbox = findElement();
        return checkbox.isSelected();
    }
}

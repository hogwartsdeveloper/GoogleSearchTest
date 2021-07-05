import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ImagePage {
    private WebDriver driver;

    public ImagePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//span[text()='Картинки']")
    private WebElement heading;

    public String getHeading() {
        return heading.getText();
    }
}
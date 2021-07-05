import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MailPage {
    private WebDriver driver;

    public MailPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//h1[starts-with(text(), 'Успевайте больше')]")
    private WebElement heading;

    public String getHeading() {
        return heading.getText();
    }
}

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultSearchPage {
    private WebDriver driver;

    public ResultSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//div[@eid='htHhYP-zLaHKlAa885SADQ']/div")
    private WebElement notResult;

    @FindBy(xpath = "//div[@id='result-stats']")
    private WebElement result;

    public String checkNoResult() {
        return notResult.getText();
    }

    public String checkResult() {
        return result.getText().substring(0, 21);
    }
}

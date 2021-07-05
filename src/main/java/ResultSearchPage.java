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
    private List<WebElement> resultList;

    public int checkResult() {
        return resultList.size();
    }
}

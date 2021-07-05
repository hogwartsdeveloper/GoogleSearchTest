import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@type='text']")
    private WebElement searchField;

    @FindBy(xpath = "//center/input[1]")
    private List<WebElement> searchButton;

    @FindBy(xpath = "//center/input[2]")
    private WebElement luckyButton;

    @FindBy(xpath = "//ul[@role='listbox']/li")
    private List<WebElement> presentationList;

    @FindBy(xpath = "//a[text()='Почта']")
    private WebElement gmailLink;

    @FindBy(xpath = "//a[text()='Картинки']")
    private WebElement imagesLink;



    public ResultSearchPage clickSearchButton() {
        searchButton.get(1).click();
        return new ResultSearchPage(driver);
    }

    public MainPage typeSearch(String searchText) {
        searchField.sendKeys(searchText);
        return this;
    }

    public int searchPresentation(String searchText) {
        this.typeSearch(searchText);
        return presentationList.size();
    }

    public ResultSearchPage search(String searchText) {
        this.typeSearch(searchText);
        this.clickSearchButton();
        ResultSearchPage resultSearchPage = PageFactory.initElements(driver, ResultSearchPage.class);
        return resultSearchPage;
    }

    public MailPage clickGmail() {
        gmailLink.click();
        MailPage mailPage = PageFactory.initElements(driver, MailPage.class);
        return mailPage;
    }

    public ImagePage clickImage() {
        imagesLink.click();
        ImagePage imagePage = PageFactory.initElements(driver, ImagePage.class);
        return imagePage;
    }
}

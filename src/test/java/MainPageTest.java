import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainPageTest {
    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver",
                "C:\\Users\\jannu\\IdeaProjects\\TestSelenium\\drivers\\geckodriver.exe");

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://google.com/");
        mainPage = PageFactory.initElements(driver, MainPage.class);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void checkSearchTest() {
        ResultSearchPage resultSearchPage = mainPage.search("java_love");
        String searchResult = resultSearchPage.checkResult();
        Assert.assertEquals("Результатов: примерно", searchResult);
    }

    @Test
    public void checkIncorrectSearchTest() {
        ResultSearchPage resultSearchPage = mainPage.search("#@$@#$$#$");
        String searchResult = resultSearchPage.checkNoResult();
        Assert.assertNotEquals("Результатов: примерно", searchResult);
    }

    @Test
    public void checkSearchPresentationTest() {
        int sizePresentation = mainPage.searchPresentation("One Piece");
        Assert.assertEquals(10, sizePresentation);
    }
    @Test
    public void checkIncorrectSearchPresentationTest() {
        int sizePresentation = mainPage.searchPresentation("порно");
        Assert.assertEquals(0, sizePresentation);
    }

    @Test
    public void checkGmailLink() {
        MailPage mailPage = mainPage.clickGmail();
        Assert.assertEquals("Успевайте больше с почтой Gmail", mailPage.getHeading());
    }

    @Test
    public void checkImageLink() {
        ImagePage imagePage = mainPage.clickImage();
        Assert.assertEquals("Картинки", imagePage.getHeading());
    }
}

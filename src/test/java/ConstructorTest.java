import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.LoginPage;
import pageobject.MainPage;

@RunWith(Parameterized.class)
public class ConstructorTest {

    private By tab;

    private static WebDriver driver;
    private static MainPage mainPageForInitializingTestData = new MainPage(driver);
    private static MainPage testMainPage;

    public ConstructorTest(By tab) {
        this.tab = tab;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][] {
                {mainPageForInitializingTestData.sauceTab()},
                {mainPageForInitializingTestData.fillingTab()},
                {mainPageForInitializingTestData.bunsTab()}
        };
    }


    @BeforeClass
    public static void startPageInitialize() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage", "--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dalum\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver(options);
        driver.get("https://stellarburgers.nomoreparties.site/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm("dalumesandelur@mail.ru", "62276227Om");
        loginPage.clickOnAuthorizationButton();
        driver.get("https://stellarburgers.nomoreparties.site/");
        testMainPage = new MainPage(driver);
    }

    @Test
    public void checkChangeTabsByClick(){
        testMainPage.changeTab(tab);
        Assert.assertTrue("Таб не был выбран", testMainPage.checkThatTabWasChanged(tab));
    }
}

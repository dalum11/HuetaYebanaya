import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.LoginPage;
import pageobject.MainPage;

public class RedirectInPersonalAccountInfoTest {

    private static WebDriver driver;

    @BeforeClass
    public static void startPageInitialize() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage", "--remote-allow-origins=*");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dalum\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver(options);
    }

    @Before
    public void openHomePage() {
        String url = "https://stellarburgers.nomoreparties.site";
        driver.get(url);
    }

    @Test
    public void checkRedirectInPersonalAccountInfoByButton(){
        driver.get("https://stellarburgers.nomoreparties.site/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm("dalumesandelur@mail.ru", "62276227Om");
        loginPage.clickOnAuthorizationButton();
        driver.get("https://stellarburgers.nomoreparties.site/");
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnPersonalAccountInfoButton();
        driver.get("https://stellarburgers.nomoreparties.site/account/profile");
        Assert.assertEquals("Перехода в личный кабинет не было",
                "https://stellarburgers.nomoreparties.site/account/profile", driver.getCurrentUrl());
    }
}

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.PersonalAccountPage;

import java.util.HashMap;
import java.util.Map;

public class LogoutTest {

    private static WebDriver driver;

    @BeforeClass
    public static void startPageInitialize() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--headless", "--disable-dev-shm-usage", "--remote-allow-origins=*");
        Map<String, Integer> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings.cookies", 2);
        prefs.put("profile.default_content_setting_values.javascript", 2);
        options.setExperimentalOption("prefs", prefs);
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\dalum\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver(options);
    }

    @Before
    public void openHomePage() {

    }

    @Test
    public void checkLogoutByButtonInPersonalAccount(){
        driver.get("https://stellarburgers.nomoreparties.site/login");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm("dalumesandelur@mail.ru", "62276227Om");
        loginPage.clickOnAuthorizationButton();
        MainPage mainPage = new MainPage(driver);
        mainPage.clickOnPersonalAccountInfoButton();
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.waitUntilAccountPageDownload();
        personalAccountPage.clickOnLogoutButton();
        driver.get("https://stellarburgers.nomoreparties.site/login");
        Assert.assertEquals("Перехода на страницу логина не было",
                "https://stellarburgers.nomoreparties.site/login", driver.getCurrentUrl());
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }
}

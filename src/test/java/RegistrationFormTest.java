import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageobject.RegistrationPage;

public class RegistrationFormTest {

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
    public void checkRegistrationWithValidPassword(){
        driver.get("https://stellarburgers.nomoreparties.site/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillRegistrationForm("Наталья", "olegmakarow@gmail.com", "123b56");
        registrationPage.clickOnRegistrationButton();
        driver.get("https://stellarburgers.nomoreparties.site/");
        Assert.assertEquals("Не было перехода на домашнюю страницу сайта",
                "https://stellarburgers.nomoreparties.site/", driver.getCurrentUrl());
    }

    @Test
    public void checkRegistrationWithInvValidPassword(){
        driver.get("https://stellarburgers.nomoreparties.site/register");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.fillRegistrationForm("Наталья", "olegmakarow65@gmail.com", "123b56c");
        registrationPage.clickOnRegistrationButton();
        Assert.assertEquals("Получилось зарегистрироваться с невалидными данными",
                "https://stellarburgers.nomoreparties.site/register", driver.getCurrentUrl());
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }
}

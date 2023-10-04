package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By emailInput = By.xpath(".//fieldset[1]/div/div/input");
    private By passwordInput = By.xpath(".//input[@name='Пароль']");
    private By authorizationButton = By.xpath(".//button[text()='Войти']");
    private By forgotPasswordButton = By.xpath(".//a[text()='Восстановить пароль']");
    private By registrationButton = By.xpath(".//a[text()='Зарегистрироваться']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnRegistrationButton(){
        driver.findElement(registrationButton).click();
    }

    public void clickOnAuthorizationButton(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        String script = "document.evaluate(\".//button[text()='Войти']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click();";
        javascriptExecutor.executeScript(script);
    }

    public void fillEmailInput(String email){
        driver.findElement(emailInput).sendKeys(email);
    }

    public void fillPasswordInput(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void fillLoginForm(String email, String password){
        fillEmailInput(email);
        fillPasswordInput(password);
    }

    public void clickOnForgotPasswordButton(){
        driver.findElement(forgotPasswordButton).click();
    }
}

package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage {

    private WebDriver driver;
    private By nameInput = By.xpath(".//fieldset[1]/div/div/input");
    private By emailInput = By.xpath(".//fieldset[2]/div/div/input");
    private By passwordInput = By.name("Пароль");
    private By registrationButton = By.xpath(".//button[text()='Зарегистрироваться']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnRegistrationButton(){
        driver.findElement(registrationButton).click();
    }

    public void fillNameInput(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void fillEmailInput(String email){
        driver.findElement(emailInput).sendKeys(email);
    }

    public void fillPasswordInput(String password){
        driver.findElement(emailInput).sendKeys(password);
    }

    public void fillRegistrationForm(String name, String email, String password){
        fillNameInput(name);
        fillEmailInput(email);
        fillPasswordInput(password);
    }
}

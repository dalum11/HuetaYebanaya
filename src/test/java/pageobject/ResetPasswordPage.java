package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResetPasswordPage {

    private WebDriver driver;
    private By passwordInput = By.xpath(".//input[@type='password']");
    private By codeInput = By.xpath(".//fieldset[2]/div/div/input");
    private By saveButton = By.xpath(".//button[text()='Сохранить']");

    public ResetPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnSaveButton(){
        driver.findElement(saveButton).click();
    }

    public void fillCodeInput(String code){
        driver.findElement(codeInput).sendKeys(code);
    }

    public void fillPasswordInput(String newPassword){
        driver.findElement(passwordInput).sendKeys(newPassword);
    }

    public void fillResetPasswordForm(String newPassword, String code){
        fillPasswordInput(newPassword);
        fillCodeInput(code);
    }

    public void waitUntilResetPasswordPageDownload(){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(passwordInput));
    }
}

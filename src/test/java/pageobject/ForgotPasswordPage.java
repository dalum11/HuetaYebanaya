package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private WebDriver driver;
    private By emailInput = By.xpath(".//input[@name='name']");
    private By resetPasswordButton = By.xpath(".//button[text()='Восстановить']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillEmailInput(String email){
        driver.findElement(emailInput).sendKeys(email);
    }

    public void clickOnResetPasswordButton(){
//        driver.findElement(resetPasswordButton).click();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        String script = "document.evaluate(\".//button[text()='Восстановить']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click();";
        javascriptExecutor.executeScript(script);
    }
}

package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PersonalAccountPage {

    private WebDriver driver;
    private By constructorButton = By.xpath(".//header/nav/ul/li[1]/a");
    private By logoutButton = By.xpath(".//button[text()='Выход']");

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnConstructorButton(){
        driver.findElement(constructorButton).click();
    }

    public void clickOnLogoutButton(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        String script = "document.evaluate(\"//button[text()='Выход']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click();";
        javascriptExecutor.executeScript(script);

    }

    public void waitUntilAccountPageDownload() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton));
    }
}

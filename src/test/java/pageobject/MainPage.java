package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;
    private By personalAccountInfoButton = By.xpath(".//p[text()='Личный Кабинет']");
    private By bunsTab = By.xpath(".//span[text()='Булки']");
    private By sauceTab = By.xpath(".//span[text()='Соусы']");
    private By fillingTab = By.xpath(".//span[text()='Начинки']");
    private By bunsHeader = By.xpath(".//h2[text()='Булки']");
    private By sauseHeader = By.xpath(".//h2[text()='Соусы']");
    private By fillingHeader = By.xpath(".//h2[text()='Начинки']");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnPersonalAccountInfoButton(){
        driver.findElement(personalAccountInfoButton).click();
    }

    public void changeTab(By newTab){
        driver.findElement(newTab).click();
    }

    public By bunsTab() {
        return bunsTab;
    }

    public By sauceTab() {
        return sauceTab;
    }

    public By fillingTab() {
        return fillingTab;
    }

    public boolean checkThatTabWasChanged(By tab){
        if (tab.equals(bunsTab)) {
            return driver.findElement(bunsHeader).isDisplayed();
        } else if (tab.equals(sauceTab)) {
            return driver.findElement(sauseHeader).isDisplayed();
        } else if (tab.equals(fillingTab)){
            return driver.findElement(fillingHeader).isDisplayed();
        } else {
            return false;
        }
    }
}

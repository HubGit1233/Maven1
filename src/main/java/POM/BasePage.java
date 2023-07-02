package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BasePage {

    protected static WebDriver driver;

    static {
        driver = Browser.getDriver();

    }

    public static void clickOnElement (WebElement element) {
        element.click();
    }
    public static void clickOnElementByLocator (By locator) {
        driver.findElement(locator).click();
    }
}

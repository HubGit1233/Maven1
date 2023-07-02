package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

public class Wait {
    private static final WebDriver driver;

    static {
        driver = Browser.getDriver();
    }

    public static WebElement waitForElementVisibility(By locator, long timeToWait) {
        WebDriverWait wait = new WebDriverWait(driver, timeToWait);
        wait.pollingEvery(3,TimeUnit.SECONDS);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }
}

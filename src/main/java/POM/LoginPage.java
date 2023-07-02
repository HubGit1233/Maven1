package POM;

import POM.BasePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import POM.Browser;

public class LoginPage extends BasePage {

    private static final By USERNAME_INPUT_FIELD =  By.id("input-username");
    private static final By PASSWORD_INPUT_FIELD = By.id("input-password");
    private static final By LOGIN_INPUT_BUTTON = By.className("btn-primary");
    private static final By LOGIN_VALIDATION_ERROR = By.cssSelector(".alert-danger");
    private static final String LOGIN_PAGE_URL = "http://shop.pragmatic.bg/admin/";


    public static void goToLoginPage() {
//        Browser.getDriver().get(LOGIN_PAGE_URL);
        driver.get(LOGIN_PAGE_URL);
    }
    public static void writeTextInUsernameInputField(String username) {
        driver.findElement(USERNAME_INPUT_FIELD).sendKeys(username);
    }

    public static void writeTextInPasswordInputField(String password) {
        driver.findElement(PASSWORD_INPUT_FIELD).sendKeys(password);
    }

    public static void clickLoginButton() {
        clickOnElementByLocator(LOGIN_INPUT_BUTTON);
    }

    public static void verifyValidationMessage(String expectedValidationMessage) {
        String actualValidationMessage = driver.findElement(LOGIN_VALIDATION_ERROR).getText();
        Assert.assertTrue(actualValidationMessage.contains(expectedValidationMessage));
    }

}

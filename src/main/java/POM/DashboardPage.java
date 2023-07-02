package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DashboardPage extends BasePage {
    @FindBy(xpath = "//img[@id='user-profile']/ ..")
    private static WebElement usernameLink;

    @FindBy(xpath = "//*[@id='menu-customer']/a")
    private static WebElement customersLabel;

    static {
        PageFactory.initElements(driver, DashboardPage.class);
    }

    public static void verifyUsernameLabelText(String expectedText) {
        Wait.waitForElementVisibility(By.xpath("//img[@id='user-profile']/ .."), 3);
        Assert.assertEquals(usernameLink.getText(), expectedText);
    }
    public void clickOnCustomersLabel() {
        clickOnElement(customersLabel);
    }
}

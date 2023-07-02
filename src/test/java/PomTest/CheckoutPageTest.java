package PomTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPageTest {
    WebDriver driver;

    @BeforeClass
    public void setUpBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void BuyAsGuest() {

        driver.get("http://shop.pragmatic.bg/index.php?route=product/product&product_id=43");

        WebElement addToCart = driver.findElement(By.id("button-cart"));
        addToCart.click();

        WebElement cart = driver.findElement(By.xpath("//i[contains(@class, 'fa fa-shopping-cart')]"));
        cart.click();

        WebElement checkout = driver.findElement(By.xpath("//a[@href=\"https://shop.pragmatic.bg/index.php?route=checkout/checkout\" and contains(@class, \"btn\") and contains(@class, \"btn-primary\")]"));
        checkout.click();

        String expectedUrl = "https://shop.pragmatic.bg/index.php?route=checkout/checkout";
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrl);

        WebElement guestCheckout = driver.findElement(By.xpath("//input[@type='radio' and @name='account' and @value='guest']"));
        guestCheckout.click();
        WebElement continueButton = driver.findElement(By.xpath("//input[@id='button-account']"));
        continueButton.click();

        WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstname.sendKeys("Martin");
        WebElement lastname = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastname.sendKeys("Ivanov");
        WebElement email = driver.findElement(By.xpath("//input[@id='input-payment-email']"));
        email.sendKeys("martinivanov@abv.bg");
        WebElement telephone = driver.findElement(By.xpath("//input[@name='telephone']"));
        telephone.sendKeys("0123456789");
        WebElement address1 = driver.findElement(By.xpath("//input[@name='address_1']"));
        address1.sendKeys("Downing Street №10");
        WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
        city.sendKeys("London");
        WebElement postcode = driver.findElement(By.xpath("//input[@name='postcode']"));
        postcode.sendKeys("SW1A 2AA");
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='input-payment-country']"));
        Select country = new Select(dropdown);
        country.selectByValue("222");
        WebElement dropdown2 = driver.findElement(By.xpath("//select[@id='input-payment-zone']"));
        Select zoneId = new Select(dropdown2);
        zoneId.selectByValue("3608");
        WebElement continueButton2 = driver.findElement(By.xpath("//input[@id='button-guest']\n"));
        continueButton2.click();

        WebDriverWait wait = new WebDriverWait(driver, 2);

        WebElement termsAndConditions = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='checkbox'][name='agree']")));
        termsAndConditions.click();
        WebElement continueButton3 = driver.findElement(By.xpath("//input[@id='button-payment-method']\n"));
        continueButton3.click();

        //Кодът приключва до тук, защото при опит да продължа с Continue на Payment Method ми излиза следната грешка: Warning: Payment method required! при положение,
        //че няма изброени опции за плащане.
    }
}

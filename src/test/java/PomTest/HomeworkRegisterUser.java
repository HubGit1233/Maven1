package PomTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import java.util.Random;

public class HomeworkRegisterUser {
    WebDriver driver;

    @BeforeClass
    public void setUpBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @Test
    public void CreateUser() {

        driver.get("http://shop.pragmatic.bg/index.php?route=common/home");
        WebElement registryIcon = driver.findElement(By.xpath("//i[contains(@class, 'fa fa-user')]"));
        registryIcon.click();
        WebElement register = driver.findElement(By.xpath("//a[text()='Register']"));
        register.click();

        Random random = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder stringBuilder = new StringBuilder();
        int minLength = 4;
        int maxLength = 20;
        int length = random.nextInt(maxLength - minLength + 1) + minLength;
        for (int i = 0; i < length; i++) {
            char randomChar = alphabet.charAt(random.nextInt(alphabet.length()));
            stringBuilder.append(randomChar);
        }

        String randomString = stringBuilder.toString();

        WebElement firstname = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstname.sendKeys(randomString);
        WebElement lastname = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastname.sendKeys(randomString);
        WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
        email.sendKeys(randomString + "@abv.bg");
        WebElement telephone = driver.findElement(By.xpath("//input[@name='telephone']"));
        telephone.sendKeys("012345678910");
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys(randomString);
        WebElement confirm = driver.findElement(By.xpath("//input[@name='confirm']"));
        confirm.sendKeys(randomString);
        WebElement subscribe = driver.findElement(By.xpath("//input[@type='radio' and @name='newsletter']"));
        subscribe.click();
        WebElement terms = driver.findElement(By.xpath("//input[@type='checkbox']"));
        terms.click();
        WebElement continueButton = driver.findElement(By.xpath("//input[@type='submit' and @value='Continue']"));
        continueButton.click();

        String expectedUrl = "http://shop.pragmatic.bg/index.php?route=account/success";
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrl);
    }
}
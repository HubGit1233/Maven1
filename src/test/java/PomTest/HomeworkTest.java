/* package PomTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomeworkTest {
    WebDriver driver = new ChromeDriver();

    @Test
        public void Test1() {
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            driver.get("http://shop.pragmatic.bg/admin/");

            WebElement Username = driver.findElement(By.id("input-username"));
            Username.click();
            Username.sendKeys("admin");

            WebElement Password = driver.findElement(By.id("input-password"));
            Password.click();
            Password.sendKeys("parola123!");

            WebElement Login = driver.findElement(By.xpath("//button[contains(text(), 'Login')]"));
            Login.click();

            WebElement salesElement = driver.findElement(By.xpath("//a[contains(text(), 'Sales')]"));
            salesElement.click();
            WebDriverWait wait = new WebDriverWait(driver, 3);
            wait.until(ExpectedConditions.attributeContains(By.id("collapse4"), "class", "in"));

            WebElement ordersLink = driver.findElement(By.xpath("//a[contains(text(), 'Orders')]"));
            ordersLink.click();

            WebElement dropdownElement = driver.findElement(By.id("input-order-status"));
            dropdownElement.click();
            WebDriverWait wait2 = new WebDriverWait(driver, 3);
            Select select = new Select(dropdownElement);

            List<WebElement> options = select.getOptions();

            for (WebElement option : options) {
                System.out.println(option.getText());
            }
            int expectedOptionsCount = 16;
            int actualOptionsCount = options.size();

            Assert.assertEquals(actualOptionsCount, expectedOptionsCount);
        }

    @Test
    public void Test2() {
        driver.get("http://pragmatic.bg/automation/lecture13/Config.html");
        WebElement selector = driver.findElement(By.name("airbags"));
        selector.click();

        WebElement selector2 = driver.findElement(By.name("parksensor"));
        selector2.click();

        boolean isCheckSelected1 = selector.isSelected();
        boolean isCheckSelected2 = selector2.isSelected();

        Assert.assertTrue(isCheckSelected1);
        Assert.assertTrue(isCheckSelected2);
    }
}


 */
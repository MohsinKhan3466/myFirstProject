import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LogLoginTest {

    WebDriver driver;
    @BeforeTest
    public void initialization(){
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver\\chromedriver.exe");

        driver= new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
    }
    @Test
    public void login(){
        driver.findElement(By.xpath("//a[@class='login']")).click();

        driver.findElement(By.xpath("//*[@id='email']")).sendKeys("Hiuyuou@gmail.com");

        driver.findElement(By.xpath("//*[@id='passwd']")).sendKeys("Test@1234");

        driver.findElement(By.xpath("//*[@class='icon-lock left']")).click();

        String actualurl="http://automationpractice.com/index.php?controller=my-account";

        String expecedurl=driver.getCurrentUrl();

        Assert.assertEquals(expecedurl,actualurl);

    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}

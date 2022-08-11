import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class OpenCartTest {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","D:\\chromedriver\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30 ,TimeUnit.SECONDS);

        driver.get("https://computer-database.gatling.io/computers");

        driver.findElement(By.xpath("//*[@id='add']")).click();


        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("AMD A8");

        driver.findElement(By.xpath("//*[@id=\"introduced\"]")).sendKeys("2020-01-10");

        driver.findElement(By.xpath("//*[@id=\"discontinued\"]")).sendKeys("2022-03-03");

        Select sc = new Select(driver.findElement(By.xpath("//*[@id=\"company\"]")));
        sc.selectByVisibleText("IBM");

        driver.findElement(By.xpath("//*[@id=\"main\"]/form/div/input")).click();

        WebElement w= driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]"));

        String s= w.getText();

        System.out.println("Validation Text is:"+s);
    }
}

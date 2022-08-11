import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class Test1 {

    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver","D:\\chromedriver\\chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();

        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        Properties pr= new Properties();
        FileInputStream is= new FileInputStream("C:\\Users\\mohsin.khan\\IdeaProjects\\SeleniumTest\\src\\config.properties");
        pr.load(is);


        driver.get(pr.getProperty("url"));

        driver.findElement(By.xpath(pr.getProperty("xpath1"))).click();

        driver.findElement(By.xpath(pr.getProperty("xpath2"))).sendKeys(pr.getProperty("firstname"));

        driver.findElement(By.xpath(pr.getProperty("xpath3"))).sendKeys(pr.getProperty("lastname"));

        driver.findElement(By.xpath(pr.getProperty("xpath4"))).sendKeys(pr.getProperty("add"));

        driver.findElement(By.xpath(pr.getProperty("xpath5"))).sendKeys(pr.getProperty("city"));

        driver.findElement(By.xpath(pr.getProperty("xpath6"))).sendKeys(pr.getProperty("State"));

        driver.findElement(By.xpath(pr.getProperty("xpath7"))).sendKeys(pr.getProperty("pin"));

        driver.findElement(By.xpath(pr.getProperty("xpath8"))).sendKeys(pr.getProperty("phone"));

        driver.findElement(By.xpath(pr.getProperty("xpath9"))).sendKeys(pr.getProperty("ssn"));

        driver.findElement(By.xpath(pr.getProperty("xpath10"))).sendKeys(pr.getProperty("username"));

        driver.findElement(By.xpath(pr.getProperty("xpath11"))).sendKeys(pr.getProperty("password"));

        driver.findElement(By.xpath(pr.getProperty("xpath12"))).sendKeys(pr.getProperty("cnf"));

        driver.findElement(By.xpath(pr.getProperty("xpath13"))).click();

        WebElement w= driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p"));

        String s= w.getText();

        System.out.println("Validation Text is:"+s);

        System.out.println("Username Entered is"+pr.getProperty("username"));
        System.out.println("Entered Password is:"+pr.getProperty("password"));

        driver.quit();

    }
}

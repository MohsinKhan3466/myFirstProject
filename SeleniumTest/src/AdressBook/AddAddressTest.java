package AdressBook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AddAddressTest {

    WebDriver driver;

    Properties pr=new Properties();
    FileInputStream inputStream=new FileInputStream("C:\\Users\\mohsin.khan\\IdeaProjects\\SeleniumTest\\src\\AdressBook\\adressbookframework.properties");

    public AddAddressTest() throws IOException {

        pr.load(inputStream);
    }


    @BeforeTest
    public void setUp(){

        System.setProperty("webdriver.chrome.driver","D:\\chromedriver\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30 , TimeUnit.SECONDS);
        driver.get("http://a.testaddressbook.com/addresses");
    }
    @Test
    public void signing(){

        driver.findElement(By.xpath("//*[@id='session_email']")).sendKeys(pr.getProperty("email"));
        driver.findElement(By.xpath("//*[@id='session_password']")).sendKeys(pr.getProperty("password"));
        driver.findElement(By.xpath("//*[@name='commit']")).click();
    }
    @Test
    public void addAddress(){


        driver.findElement(By.xpath("//*[@id='address_first_name']")).sendKeys("Fatik");
        driver.findElement(By.xpath("//*[@id='address_last_name']")).sendKeys("shah");
        driver.findElement(By.xpath("//*[@id='address_street_address']")).sendKeys("Narsingpur");
        driver.findElement(By.xpath("//*[@id='address_secondary_address']")).sendKeys("Gangapur");
        driver.findElement(By.xpath("address_city")).sendKeys("Seattle");

        Select sc= new Select(driver.findElement(By.xpath("//Select[@id='address_state']")));
        sc.selectByVisibleText("New York");

        driver.findElement(By.xpath("address_zip_code")).sendKeys("98121");
        driver.findElement(By.xpath("//*[@id='address_country_us']")).click();
        driver.findElement(By.xpath("//*[@id='address_birthday']")).sendKeys("10-01-1995");
        driver.findElement(By.xpath("//*[@id='address_age']")).sendKeys("27");
        driver.findElement(By.xpath("//*[@id='address_website']")).sendKeys("wwww.sanpada.com");

        WebElement pic= driver.findElement(By.xpath("address_picture"));
        pic.sendKeys("C:\\Users\\mohsin.khan\\Downloads\\Yash.png");

        driver.findElement(By.xpath("address_phone")).sendKeys("0223173113");
        driver.findElement(By.xpath("//*[@id='address_interest_dance']")).click();
        driver.findElement(By.xpath("//*[@name='commit']")).click();
    }

    @AfterTest
    public void tearDown(){

        driver.quit();
    }

}

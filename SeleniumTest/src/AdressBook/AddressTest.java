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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class AddressTest {

Properties pr= new Properties();
FileInputStream inputStream= new FileInputStream("C:\\Users\\mohsin.khan\\IdeaProjects\\SeleniumTest\\src\\AdressBook\\adressbookframework.properties");
    WebDriver driver;

    public AddressTest() throws IOException {

        pr.load(inputStream);
    }

    @BeforeTest
    public void setup(){
     System.setProperty("webdriver.chrome.driver","D:\\chromedriver\\chromedriver.exe");
     driver= new ChromeDriver();

     driver.manage().deleteAllCookies();
     driver.manage().window().maximize();
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

     driver.get("http://a.testaddressbook.com/");
    }

    @Test
    public void clickSigningButton(){

        driver.findElement(By.xpath("//a[@id='sign-in' ]")).click();
    }

    @Test
    public void createAccount(){
        driver.findElement(By.xpath("//a[@href='/sign_up' ]")).click();

        driver.findElement(By.xpath("//*[@id='user_email']")).sendKeys(pr.getProperty("email"));
        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys(pr.getProperty("password"));
        driver.findElement(By.xpath("//*[@name='commit']")).click();
    }

    @Test
    public void welcomeMessage(){
        WebElement msg= driver.findElement(By.xpath("//*[text()='Welcome to Address Book']"));
        String s= msg.getText();
        System.out.println("Welcome Message is:"+s);
    }
    @AfterTest
    public void tearDown(){

        driver.quit();

    }
}

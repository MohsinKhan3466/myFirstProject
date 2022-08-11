package oldAssignmentTest;

import LastAssignment.LocatorsClass;
import LastAssignment.ReusableFunctions;
import LastAssignment.ValueFile;
import files.EmailGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestYourLoga {
    String emailId= EmailGenerator.createEmailAddress();

    public static WebDriver driver ;
    ReusableFunctions action = new ReusableFunctions();
    LocatorsClass element= new LocatorsClass();
    ValueFile value= new ValueFile();
    @BeforeTest
    public void setUP(){
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void registration() throws Exception {

        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        action.enterValue(driver,element.createEmail,emailId);
        action.clickElement(driver,element.createButton);

        action.clickElement(element.gender,driver.findElement(By.xpath(element.gender)),driver);

        action.enterValue(driver, element.firstName, value.first_name);
        action.enterValue(driver, element.lastName, value.last_name);
        action.enterValue(driver, element.password, value.password);

        action.selectDropDownValues(driver, element.day, value.date);
        action.selectDropDownValues(driver, element.month, value.month);
        action.selectDropDownValues(driver, element.year, value.year);

        action.clickElement( element.checkbox,driver.findElement(By.xpath(element.checkbox)),driver);

        action.enterValue(driver, element.company, value.company);
        action.enterValue(driver, element.address, value.c_address);
        action.enterValue(driver, element.city, value.city);

        action.selectDropDownValues(driver, element.state, value.state);

        action.enterValue(driver, element.zipcode, value.zip_code);

        action.selectDropDownValues(driver, element.country, value.country);
        action.enterValue(driver, element.mobile, value.mobile_no);

        action.clear(driver, element.alies);
        action.enterValue(driver, element.alies, value.alies);

        action.clickElement(driver, element.register);


        if (driver.getPageSource().contains("Welcome to your account. Here you can manage all of your personal information and orders."))
        {
            System.out.println("Registration Is Successful");
        }
        else
        {
            System.out.println("Registration Is Failed");
        }
        WebElement uname= driver.findElement(By.xpath("//a[@class='account']"));
        String userName=uname.getText();
        System.out.println("Username Is:"+userName);
        System.out.println("Password Is:Test@1234");

        action.clickElement(driver, element.logout);


    }
    @Test(priority = 1)
    public void login() throws Exception {
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        action.enterValue(driver, element.email, emailId);
        action.enterValue(driver, element.epassword, value.password);
        action.clickElement(driver, element.login);

        String actualurl="http://automationpractice.com/index.php?controller=my-account";
        String expecedurl=driver.getCurrentUrl();
        Assert.assertEquals(expecedurl,actualurl);
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}

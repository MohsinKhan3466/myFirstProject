import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


import java.util.concurrent.TimeUnit;

public class LogNewUserTest {

    public static void main(String[] args) {

        //1:-Launch : http://automationpractice.com/index.php (Chrome)
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver","D:\\chromedriver\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

       //2:-Click ‘Sign in’
        driver.findElement(By.xpath("//a[@class='login']")).click();

        //3:-Enter a unique email address and click on ‘Create an Account’ button
        driver.findElement(By.xpath("//*[@id='email_create']")).sendKeys("Hiuyuou@gmail.com");
        driver.findElement(By.xpath("//*[@class='icon-user left']")).click();

        //4:-Enter all the required fields and click on ‘Register’
        WebElement gender= driver.findElement(By.xpath("//*[@id='id_gender1']"));
        gender.click();

        driver.findElement(By.xpath("//*[@id='customer_firstname']")).sendKeys("Tom");

        driver.findElement(By.xpath("//*[@id='customer_lastname']")).sendKeys("Wilson");

        driver.findElement(By.xpath("//*[@id='passwd']")).sendKeys("Test@1234");

        Select s1= new Select(driver.findElement(By.xpath("//Select[@name='days']")));
        s1.selectByVisibleText("3  ");

        Select s2= new Select(driver.findElement(By.xpath("//Select[@id='months']")));
        s2.selectByVisibleText("March ");

        Select s3= new Select(driver.findElement(By.xpath("//Select[@id='years']")));
        s3.selectByVisibleText("1996  ");

        WebElement rcv= driver.findElement(By.xpath("//*[@id='optin']"));
        rcv.click();

        driver.findElement(By.xpath("//*[@id='company']")).sendKeys("Amazon");

        driver.findElement(By.xpath("//*[@id='address1']")).sendKeys( " 410 Terry Ave N, Seattle 98109" );

        driver.findElement(By.xpath("//*[@id='city']")).sendKeys("Seattle");

        Select state= new Select(driver.findElement(By.xpath("//Select[@id='id_state']")));
        state.selectByVisibleText("Washington");

        driver.findElement(By.xpath("//*[@id='postcode']")).sendKeys("98121");

        Select country = new Select(driver.findElement(By.xpath("//Select[@id='id_country']")));
        country.selectByVisibleText("United States");

        driver.findElement(By.xpath("//*[@id='phone_mobile']")).sendKeys("2025550144");

        driver.findElement(By.xpath("//*[@id='alias']")).clear();
        driver.findElement(By.xpath("//*[@id='alias']")).sendKeys("Texas,USA");

        driver.findElement(By.xpath("//*[text()='Register']")).click();

        //5:-Validate the confirmation message
        WebElement vText= driver.findElement(By.xpath("//*[text()='Welcome to your account. Here you can manage all of your personal information and orders.']"));
        String s= vText.getText();
        System.out.println("Validation Text Is:"+s);


        //6:-Print the user_name and password in the console
        WebElement uname= driver.findElement(By.xpath("//a[@class='account']"));
        String s4=uname.getText();
        System.out.println("Username Is:"+s4);
        System.out.println("Password Is:Test@1234");

        driver.quit();

    }
}

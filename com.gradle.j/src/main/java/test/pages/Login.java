package test.pages;
import files.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class Login extends TestBase {
    String username=Registration.email;
    @FindBy(xpath = "//*[@id='email']")
    public WebElement EmailId;
    @FindBy(xpath = "//*[@id='passwd']")
    public WebElement Password;
    @FindBy(xpath = "//*[@class='icon-lock left']")
    public WebElement Login;
    @FindBy(xpath = "//a[@class='login']")
    WebElement SignIN;

    /*****Page Methods******/
@Step("LogIn step with username{0},password{1},for method:{method} steps...")

    public HomePage logIntoYourLoga() throws IOException {
    Properties pr= new Properties();
    FileInputStream is=new FileInputStream("D:\\com.gradle.j\\src\\main\\java\\files\\Values.properties");
    pr.load(is);

    SignIN.click();
    EmailId.sendKeys(username);
    Password.sendKeys(pr.getProperty("password"));
    Login.click();
    return new HomePage();
}
    public Login(){


    PageFactory.initElements(driver,this);
    }
}

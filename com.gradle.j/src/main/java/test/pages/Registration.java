package test.pages;
import files.EmailGenerator;
import files.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Registration extends TestBase {
    static String email= EmailGenerator.createEmailAddress();
    @FindBy(xpath ="//*[@id='email_create']")
        public WebElement CreateEmail;
        @FindBy(xpath = "//*[@class='icon-user left']")
        public WebElement CreateEmailButton;
        @FindBy(xpath = "//*[@id='id_gender1']")
        public WebElement ClickGender;
        @FindBy(xpath = "//*[@id='customer_firstname']")
        public WebElement FirstName;
        @FindBy(xpath = "//*[@id='customer_lastname']")
        public WebElement LastName;
        @FindBy(xpath = "//*[@id='passwd']")
        public WebElement Password;
        @FindBy(xpath = "//Select[@name='days']")
        public WebElement Days;
        @FindBy(xpath = "//Select[@id='months']")
        public WebElement Month;
        @FindBy(xpath = "//Select[@id='years']")
        public WebElement Year;
        @FindBy(xpath = "//*[@id='optin']")
        public WebElement CheckBox;
        @FindBy(xpath = "//*[@id='company']")
        public WebElement CompanyName;
        @FindBy(xpath = "//*[@id='address1']")
        public WebElement CompAddress;
        @FindBy(xpath = "//*[@id='city']")
        public WebElement City;
        @FindBy(xpath = "//Select[@id='id_state']")
        public WebElement State;
        @FindBy(xpath = "//*[@id='postcode']")
        public WebElement PinCode;
        @FindBy(xpath = "//Select[@id='id_country']")
        public WebElement Country;
        @FindBy(xpath = "//*[@id='phone_mobile']")
        public WebElement Mobile_No;
        @FindBy(xpath = "//*[@id='alias']")
        public WebElement Alies;
        @FindBy(xpath = "//*[text()='Register']")
        public WebElement Register;
        @FindBy(xpath = "//a[@href='http://automationpractice.com/index.php?mylogout=']")
        public WebElement LogOut;
        @FindBy(xpath = "//a[@class='login']")
        public WebElement SignIN;

    public Registration() throws FileNotFoundException {
        PageFactory.initElements(driver,this);
    }

    /*****Page Method******/
    @Step("Sign in..")
    public void signIn(){
        SignIN.click();
    }
        @Step("Registration on Your Loga")
        public void registrationOnYourLoga() throws IOException {
        Properties pr= new Properties();
        FileInputStream is=new FileInputStream("D:\\com.gradle.j\\src\\main\\java\\files\\Values.properties");
        pr.load(is);


            CreateEmail.sendKeys(email);
            CreateEmailButton.click();
            ClickGender.click();
            FirstName.sendKeys(pr.getProperty("first_name"));
            LastName.sendKeys(pr.getProperty("last_name"));
            Password.sendKeys(pr.getProperty("password"));
            Select scDays = new Select(Days);
            scDays.selectByVisibleText(pr.getProperty("date"));
            Select scMonth = new Select(Month);
            scMonth.selectByVisibleText(pr.getProperty("month"));
            Select scYear = new Select(Year);
            scYear.selectByVisibleText(pr.getProperty("year"));
            CheckBox.click();
            CompanyName.sendKeys(pr.getProperty("company"));
            CompAddress.sendKeys(pr.getProperty("c_address"));
            City.sendKeys(pr.getProperty("city"));
            State.sendKeys(pr.getProperty("state"));
            PinCode.sendKeys(pr.getProperty("zip_code"));
            Select sc = new Select(Country);
            sc.selectByVisibleText(pr.getProperty("country"));
            Mobile_No.sendKeys(pr.getProperty("mobile_no"));
            Alies.clear();
            Alies.sendKeys(pr.getProperty("alies"));
            Register.click();
        }
        @Step(value = "User Logout")
        public Login setLogOut(){
            LogOut.click();
            return new Login();
        }
    }





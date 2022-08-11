import files.TakeScreenShot;
import files.TestBase;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.pages.HomePage;
import test.pages.Login;
import test.pages.Registration;
import java.io.IOException;
public class TestLoga extends TestBase {

    @BeforeTest
    public void setUp() {
        initialization();
        driver.get("http://automationpractice.com/index.php");
    }
    @Epic("EPIC- YourLoga Verification Epic")
    @Feature("FEATURE- Doing YourLoga Verification")
    @Step(" Verifying Home Page")
    @Link("http://automationpractice.com/index.php")
    @Description("Description of Method:- Verifying that YourLoga Home page is Opening ")
    @Test(priority = 1, description = "Verifying YourLoga HomePage ")
    public void homePageTest() throws IOException {
        HomePage actions = new HomePage();
        actions.gotoYourLoga();
        Assert.assertTrue(true);
        TakeScreenShot.screenShot(driver, "HomePage_Screenshot");
    }
    @Epic("EPIC- YourLoga New User Registration")
    @Feature("FEATURE- Creating a New User")
    @Severity(SeverityLevel.CRITICAL)
    @Step("Registration of new User to YourLoga")
    @Description("Description of Method:- Creating a new User on a system")
    @Test(priority = 2)
        public void registration() throws IOException {
        Registration registration = new Registration();
        registration.signIn();
        registration.registrationOnYourLoga();
        Assert.assertTrue(true);
        TakeScreenShot.screenShot(driver, "Registration_Screenshot");
        registration.setLogOut();
    }
    @Epic("EPIC- LoginIN user")
    @Feature("FEATURE- Login with correct credentials ")
    @Step("Login to newly created user")
    @Description("Description of Method:- Login with newly generated Credentials ")
    @Test(dependsOnMethods = "registration" , priority=3)
    public void logIn() throws IOException {
        Login login = new Login();
        login.logIntoYourLoga();
        Assert.assertTrue(true);
        TakeScreenShot.screenShot(driver, "SignIn_Screenshot");
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
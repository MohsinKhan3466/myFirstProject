package test.pages;
import files.TestBase;
import io.qameta.allure.Step;
import org.openqa.selenium.support.PageFactory;
import java.io.FileNotFoundException;
public class HomePage extends TestBase {

    public HomePage(){
        PageFactory.initElements(driver,this);
    }
    @Step("Open and Verify YourLoga Home Page")
    public Registration gotoYourLoga() throws FileNotFoundException {
           String actualTitle= driver.getTitle();
       String expectedTitle = "My Store";
        if(actualTitle.equalsIgnoreCase(expectedTitle))
            System.out.println("Title Matched");
        else
            System.out.println("Title didn't match");


    return new Registration();
    }

}

package files;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;

public class TakeScreenShot{
    public static void screenShot(WebDriver driver, String filename) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(source, new File(System.getProperty("D:\\ScreenShot")+"\\ScreenShot\\"+filename+".jpg"));
        } catch (Exception e) {
            e.getMessage();
        }
    }
}

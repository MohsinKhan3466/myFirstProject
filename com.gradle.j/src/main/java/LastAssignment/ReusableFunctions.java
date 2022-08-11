package LastAssignment;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ReusableFunctions {
    public WebDriver driver;
    public void clickElement(WebDriver driver, String locator) throws Exception{
        try {
            driver.findElement(By.xpath(locator)).click();

        }
        catch (NoSuchElementException e){
            Assert.isTrue(false,"Element is not found"+locator);
        }

    }

    public void enterValue(WebDriver driver, String locator, String value){

        try {
            driver.findElement(By.xpath(locator)).sendKeys(value);
        }
        catch (NoSuchElementException e){
            Assert.isTrue(false,"Element is not found"+locator);
        }
    }
    //OverLoaded Function
    public void clickElement(String locator,WebElement webElement,WebDriver driver){
        try {
            //WebElement webElement =driver.findElement(By.xpath(locator));
            webElement.click();
        }
        catch (NoSuchElementException e){
            Assert.isTrue(false,"Element is not found"+locator);
        }
    }

    public void selectDropDownValues(WebDriver driver, String locator, String value){
        try {
            Select sc = new Select(driver.findElement(By.xpath(locator)));
            sc.selectByVisibleText(value);
        }
        catch (NoSuchElementException e){
            Assert.isTrue(false,"Element is not found"+locator);
        }
    }
    public void clear(WebDriver driver,String locator){
        try {
            driver.findElement(By.xpath(locator)).clear();
        }
        catch(NoSuchElementException e){
            Assert.isTrue(false,"Element is not found"+locator);
        }

    }


}

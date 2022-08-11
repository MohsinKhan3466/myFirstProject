package LogaTestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class reusableFunctions {

    public void clickElement(WebDriver driver, String locator) throws Exception{
        try {
            driver.findElement(By.xpath(locator)).click();

        }
        catch (NoSuchElementException e){
            Assert.assertTrue(false,"Element is not found"+locator);
        }

    }

    public void enterValue(WebDriver driver, String locator, String value){

        try {
            driver.findElement(By.xpath(locator)).sendKeys(value);
        }
        catch (NoSuchElementException e){
            Assert.assertTrue(false,"Element is not found"+locator);
        }
    }
    public void selectRadioButton(WebDriver driver, String locator){
       try {
           WebElement webElement = driver.findElement(By.xpath(locator));
           webElement.click();
       }
       catch (NoSuchElementException e){
           Assert.assertTrue(false,"Element is not found"+locator);
       }
    }
    
    public void selectDropDownValues(WebDriver driver, String locator, String value){
        try {
            Select sc = new Select(driver.findElement(By.xpath(locator)));
            sc.selectByVisibleText(value);
        }
        catch (NoSuchElementException e){
            Assert.assertTrue(false,"Element is not found"+locator);
        }
    }
    public void clear(WebDriver driver,String locator){
        try {
            driver.findElement(By.xpath(locator)).clear();
        }
        catch(NoSuchElementException e){
            Assert.assertTrue(false,"Element is not found"+locator);
        }

    }


}

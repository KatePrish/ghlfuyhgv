package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HelpSteps {

    WebDriver driver=InitialSteps.getDriver();

    public void pushButton(String button)  {

        WebElement element = driver.findElement(By.xpath("//self::node()[text()='"+ button +"']"));
        isElementPresent(element, 30);
        element.click();
    }

    public void enterData(String id, String placeholder, String data)  {
        WebElement element = driver.findElement(By.xpath("//input[@id='"+id+"'][@placeholder='"+placeholder+"']"));
        element.clear();
        element.sendKeys(data);
    }

    public void isDisplayedElement(String name)  {
        WebElement element = driver.findElement(By.xpath("//*[text()='"+name+"']"));
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(element));
        isElementPresent(element, 30);
        //element.isDisplayed();
        assertTrue(element.getText().equalsIgnoreCase(name));
    }

    public void checkLogo(String logo)  {
        driver.findElement(By.xpath("//self::node()[@title='"+ logo +"']")).isDisplayed();
    }

    public boolean isElementPresent(WebElement elementName, int timeout)  {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            Thread.sleep(1000);
            wait.until(ExpectedConditions.visibilityOf(elementName));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void chooseOptionInModalWindow(String element){
        WebElement el = driver.findElement(By.xpath("//option[text()='"+element+"']"));
        isElementPresent(el, 30);
        el.click();
    }

}



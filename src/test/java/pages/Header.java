package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import stepDefinition.HelpSteps;

import java.util.List;

public class Header extends HelpSteps{


    public Header(WebDriver driver){
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30),this);
    }

    @FindBy(how= How.XPATH, using="//img[@class='logo']")
    public WebElement logo;

    public void checkogo(String nameLogo){
        if (logo.getAttribute("title").equals(nameLogo)){
            logo.isDisplayed();
        }
    }

    @FindBy(how=How.XPATH, using = "//li[@class='dropdown']//a[@class='dropdown-toggle']")
    public List<WebElement> navigationItems;

    public void clickOnNavigationItem(String el){
        for( WebElement arg : navigationItems){
            isElementPresent(arg, 30);
        }
        for (WebElement item : navigationItems){
            if(item.getText().contains(el)){
                item.click();
            }
        }
    }

    @FindBy(how=How.XPATH, using = "//li/a[contains(@sua-access, '.list')]")
    public List<WebElement> itemsDropDownList1;

    public void itemsDropDownList(String el) throws InterruptedException {
        Thread.sleep(5000);
        for (WebElement item : itemsDropDownList1){
            if (item.getText().equals(el)){
                item.click();
            }
        }
    }
}

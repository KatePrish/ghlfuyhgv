package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import stepDefinition.HelpSteps;


import java.util.List;

import static org.junit.Assert.assertEquals;

public class ResultTable extends HelpSteps {

    public ResultTable(WebDriver driver){
        PageFactory.initElements(driver, this);
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30),this);
    }

    @FindBy (how= How.XPATH, using = "//form/ol//*]")
    public List<WebElement> tableTitle;

    public void checkTitle(String el){
        for(WebElement item : tableTitle){
            if(item.getText().equals(el)){
                isElementPresent(item, 20);
                assertEquals(item.getText(), el);
            }
        }
    }

    @FindBy(how=How.XPATH, using = "(//span[@class='ui-icon fa fa-search fa-fw'])[1]")
    public WebElement buttonSearch;

    public void pushSearchButton(){
        isElementPresent(buttonSearch, 30);
        buttonSearch.click();
    }

    @FindBy(how=How.XPATH, using = "//td[contains(text(), '202')]")
    public List<WebElement> items;

    public boolean chackItems(String el){
        for(WebElement elem : items){
            if (elem.getText().equals(el)){
                if(items.size()>=1){
                    return true;
                }
            }
            return true;
        }
        return false;
    }
}

package stepDefinition;

import cucumber.api.java.ru.Дано;
import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.Тогда;
import cucumber.api.java.ru.И;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.Header;
import pages.LoginForm;
import pages.ModalWindowSearchTable;
import pages.ResultTable;

public class InitialSteps extends HelpSteps {

    static WebDriver driver;
    public static LoginForm loginForm;
    public static Header header;
    public static ResultTable resultTable;
    public static ModalWindowSearchTable modalWindowSearchTable;

    public static WebDriver getDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("-incognito");
            options.addArguments("start-maximized");
            options.addArguments("dom.webnotifications.enabled");

          //  DesiredCapabilities capabilities = DesiredCapabilities.chrome();
         //   capabilities.setCapability(ChromeOptions.CAPABILITY, options);

            driver = new ChromeDriver(options);
            loginForm = new LoginForm(driver);
            header = new Header(driver);
            resultTable=new ResultTable(driver);
            modalWindowSearchTable = new ModalWindowSearchTable(driver);
        }
        return driver;
    }



    @Дано("^открыт браузер, переход по ссылке$")
    public void openBrowser() {
        driver = getDriver();
        driver.get("http://172.26.25.86:8081/sua/login");
    }

    @И("^осуществлен переход на эф \"([^\"]*)\"$")
    public void осуществлен_переход_на_эф(String name) throws Throwable {
        isDisplayedElement(name);
    }

    @Тогда("^браузер закрыт$")
    public void браузер_закрыт() throws InterruptedException {
   //     Thread.sleep(3000);
        driver.quit();
        driver=null;
    }




}

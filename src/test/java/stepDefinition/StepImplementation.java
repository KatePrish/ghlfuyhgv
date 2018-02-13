package stepDefinition;

import cucumber.api.java.ru.Когда;
import cucumber.api.java.ru.То;
import cucumber.api.java.ru.Тогда;
import cucumber.api.java.ru.И;
import cucumber.api.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginForm;

import java.util.List;

import static stepDefinition.InitialSteps.loginForm;
import static stepDefinition.InitialSteps.header;
import static stepDefinition.InitialSteps.resultTable;
import static stepDefinition.InitialSteps.modalWindowSearchTable;

public class StepImplementation extends HelpSteps {

    @Когда("^пользователь вводит в поле \"Имя пользователя\" значение \"([^\"]*)\"$")
    public void пользователь_вводит_в_поле_значение(String arg2) throws Throwable {
        enterData("username", "Имя пользователя", arg2);
    }


    @Когда("^пользователь вводит в поле \"Пароль\" значение \"([^\"]*)\"$")
    public void пользователь_вводит_в_поле_Пароль(String password) throws Throwable {
        enterData("password", "Пароль", password);
    }


    @Тогда("^пользователь нажимает ссылку \"([^\"]*)\" в столбце \"Краткое наименование\"$")
    @Когда("^пользователь нажимает кнопку \"([^\"]*)\"$")
    @И("^пользователь нажимает кнопочку \"([^\"]*)\"$")
    @То("^пользователь нажимает кнопку \"([^\"]*)\" в контекстном меню$")
    public void пользователь_нажимает_кнопку_Войти(String button) throws Throwable {
        pushButton(button);
    }


    @Тогда("^пользователь выбирает финансовую организацию \"([^\"]*)\"$")
    public void пользователь_выбирает_финансовую_организацию(String arg) throws Throwable {
        Thread.sleep(1000);
        driver.findElement(By.xpath("//td[text()= '" + arg + "']")).click();
    }

    @Тогда("^открывается страница с логотипом \"([^\"]*)\"$")
    public void открывается_страница_с_логотипом(String arg1) throws Throwable {
        checkLogo(arg1);
    }
/*
    @Тогда("^открывается страница с финансовой организацией \"([^\"]*)\"$")
    public void открывается_страница_с_финансовой_организацией(String arg2) throws Throwable {
        isDisplayedElement(arg2);
        WebElement element = driver.findElement(By.xpath("//span[text()='" + arg2 + "')]"));
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOf(element));
        element.isDisplayed();
    }
*/

    @Когда("^пользователь вводит в поля \"Имя пользователя\" и \"Пароль\" значения$")
    public void пользователь_вводит_в_поля_и_значения(DataTable data) throws Throwable {
        List<String> list = data.asList(String.class);
        enterData("username", "Имя пользователя", list.get(0));
        enterData("password", "Пароль", list.get(1));
    }

    @Когда("^открывается страница с финансовой организацией \"([^\"]*)\"$")
    @Тогда("^открывается страница с сообщением \"([^\"]*)\"$")
    @То("^открывается модальное окно \"([^\"]*)\"$")
    public void открывается_страница_с_сообщением(String arg1) throws Throwable {
        isDisplayedElement(arg1);
    }



    // 11118

    @Когда("^пользователь заполняет поле \"([^\"]*)\" значением \"([^\"]*)\"$")
    public void пользователь_заполняет_поле_значением(String fieldName, String value) {
        loginForm.enterDataLoginForm(fieldName, value);
    }

    @Тогда("^пользователь нажимает кнопку с выпадающим списком \"([^\"]*)\"$")
    public void пользователь_нажимает_кнопку_с_выпадающим_списком(String el)  {
        header.clickOnNavigationItem(el);
    }

    @Тогда("^пользователь выбирает пункт \"([^\"]*)\"$")
    public void пользователь_выбирает_пункт(String arg1) throws InterruptedException {
        header.itemsDropDownList(arg1);
    }

    @Тогда("^открывается страница с таблицей \"([^\"]*)\"$")
    public void открывается_страница_с_таблицей(String arg1) {
        resultTable.checkTitle(arg1);
    }

    @Тогда("^пользователь нажимает кнопку \"([^\"]*)\" в верхней панели таблицы$")
    public void пользователь_нажимает_кнопку_в_верхней_панели_таблицы(String arg1)  {
        resultTable.pushSearchButton();
    }

    @Когда("^пользователь выбирает пункт \"([^\"]*)\" в выпадающем списке \"([^\"]*)\"$")
    public void пользователь_выбирает_пункт_в_выпадающем_списке(String arg1, String arg2)  {
        chooseOptionInModalWindow(arg1);
    }

    @Когда("^пользователь заполняет поле значением \"([^\"]*)\"$")
    public void пользователь_заполняет_поле_значением(String arg1)  {
        modalWindowSearchTable.inputDate(arg1);
    }

    @Тогда("^отображается \"Номер счета 2-го порядка\" содержащий \"([^\"]*)\"$")
    public void отображается_содержащий(String arg1)  {
        resultTable.chackItems(arg1);
    }
}

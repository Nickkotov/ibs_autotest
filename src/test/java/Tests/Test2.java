package Tests;

import org.junit.Test;

import static com.codeborne.selenide.Selenide.$;

public class Test2 extends TestBase{
    @Test
    public void searchGoogle() throws InterruptedException {

        //Авторизация
        authorization.loginInsuredAccount();
        Thread.sleep(4000);

        ///Открытие плашки "Запросы в фонд"
        homePageInsured.findCard(homePageInsured.requestsFund).click();
        filters.openFilter();
        $("div.error").click();

        Thread.sleep(4000);
    }
}

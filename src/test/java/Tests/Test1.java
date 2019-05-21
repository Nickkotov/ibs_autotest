package Tests;

import Page.FundRequests;
import Page.HomePageInsured;
import appmanager.Authorization;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Test;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static sun.management.Agent.error;


public class Test1 extends TestBase {

    @Test
    public void searchGoogle() throws InterruptedException {

        //Авторизация
        authorization.loginInsuredAccount();
        Thread.sleep(4000);

        //Открытие плашки "Запросы в фонд"
        homePageInsured.findCard(homePageInsured.requestsFund).click();
        $("div.error").click();

//        //Сортировка по полям
//        ElementsCollection valuesColmnStart = fundRequests.getValueColumn();
//        //fundRequests.findTableHeader(fundRequests.requestCreationDate).click();
//        ElementsCollection valuesColmnEnd = fundRequests.getValueColumn();
//        if (!valuesColmnStart.equals(valuesColmnEnd)) {
//            error("ошибка");
//        }

//        //Смена вида отображения заявок
//        application.checkChangeView();

//        filters.openFilter();
//        filters.closeFilter();
//        filters.openFilter();
//        filters.checkFilter("Номер запроса:", fundRequests.requestNumber,"3310");


        //Требуется доработка по дроп даун меню
//        filters.dropDownFilter("Тематика запроса:", "Другие вопросы");




        Thread.sleep(4000);

    }
}

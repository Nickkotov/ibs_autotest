package appmanager;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static sun.management.Agent.error;

public class Calendars {

    //Проверка календаря текущего поля установки дат "От"
    public void checkCalendarFrom(String nameFilterField, String dateFrom) {
        //Взятие исходного значения даты
        String startDate = $(byText(nameFilterField)).closest(".filterdd__filter").$("input.datepicker__inp").getValue();
        //Открытие календаря и проверка его видимости
        $(byText(nameFilterField)).closest(".filterdd__filter").$("li.datepicker__item").click();
        $(byText(nameFilterField)).closest(".filterdd__filter").$("div.react-datepicker").shouldBe(Condition.visible);
        //Переменная исходного месяца
        String startMonth = $(byText(nameFilterField)).closest(".filterdd__filter").$("li.datepicker__item div.react-datepicker__current-month").text();
        //Клик влево
        $(byText(nameFilterField)).closest(".filterdd__filter").$("button.react-datepicker__navigation--previous").click();
        String monthPrev = $(byText(nameFilterField)).closest(".filterdd__filter").$("li.datepicker__item div.react-datepicker__current-month").text();
        if (startMonth.equals(monthPrev)) {
            error("Ошибка перевода календаря на предыдущий месяц в поле: " + nameFilterField);
        }
        //Клик вправо
        $(byText(nameFilterField)).closest(".filterdd__filter").$("button.react-datepicker__navigation--next").click();
        String monthNext = $(byText(nameFilterField)).closest(".filterdd__filter").$("li.datepicker__item div.react-datepicker__current-month").text();
        if (!startMonth.equals(monthNext)) {
            error("Ошибка перевода календаря на следующий месяц в поле: " + nameFilterField);
        }
        //Клик по первой дате
        $(byText(nameFilterField)).closest(".filterdd__filter").$("div.react-datepicker__month div.react-datepicker__day").click();
        String endDate = $(byText(nameFilterField)).closest(".filterdd__filter").$("input.datepicker__inp").getValue();
        if (startDate.equals(endDate)) {
            error("Не установилась дата поля: " + nameFilterField);
        }
        startDate = $(byText(nameFilterField)).closest(".filterdd__filter").$("input.datepicker__inp").getValue();

        //Клик по самой последней дате
        $(byText(nameFilterField)).closest(".filterdd__filter").$("li.datepicker__item").click();
        ElementsCollection dateAll = $(byText(nameFilterField)).closest(".filterdd__filter").$("div.react-datepicker__month").$$("div.react-datepicker__day");
        for (int i = 0; i < dateAll.size(); i++) {
            if (i == dateAll.size() - 1) {
                $(byText(nameFilterField)).closest(".filterdd__filter").$("div.react-datepicker__month").$("div.react-datepicker__day", i).click();
                break;
            }
        }
        endDate = $(byText(nameFilterField)).closest(".filterdd__filter").$("input.datepicker__inp").getValue();
        if (startDate.equals(endDate)) {
            error("Не установилась дата поля: " + nameFilterField);
        }
        //Ввод даты вручную
        $(byText(nameFilterField)).closest(".filterdd__filter").$("input.datepicker__inp").setValue(dateFrom);
        endDate = $(byText(nameFilterField)).closest(".filterdd__filter").$("input.datepicker__inp").getValue();
        if (!endDate.equals(dateFrom)) {
            error("Не установилась дата поля: " + nameFilterField);
        }

    }

    //Проверка календаря текущего поля установки дат "От"
    public void checkCalendarTo(String nameFilterField, String dateTo) {
        //Взятие исходного значения даты
        String startDate = $(byText(nameFilterField)).closest(".filterdd__filter").$("input.datepicker__inp", 1).getValue();
        //Открытие календаря и проверка его видимости
        $(byText(nameFilterField)).closest(".filterdd__filter").$("li.datepicker__item", 2).click();
        $(byText(nameFilterField)).closest(".filterdd__filter").$("div.react-datepicker").shouldBe(Condition.visible);
        //Переменная исходного месяца
        String startMonth = $(byText(nameFilterField)).closest(".filterdd__filter").$("li.datepicker__item div.react-datepicker__current-month").text();
        //Клик влево
        $(byText(nameFilterField)).closest(".filterdd__filter").$("button.react-datepicker__navigation--previous").click();
        String monthPrev = $(byText(nameFilterField)).closest(".filterdd__filter").$("li.datepicker__item div.react-datepicker__current-month").text();
        if (startMonth.equals(monthPrev)) {
            error("Ошибка перевода календаря на предыдущий месяц в поле: " + nameFilterField);
        }
        //Клик вправо
        $(byText(nameFilterField)).closest(".filterdd__filter").$("button.react-datepicker__navigation--next").click();
        String monthNext = $(byText(nameFilterField)).closest(".filterdd__filter").$("li.datepicker__item div.react-datepicker__current-month").text();
        if (!startMonth.equals(monthNext)) {
            error("Ошибка перевода календаря на следующий месяц в поле: " + nameFilterField);
        }
        //Клик по первой дате
        $(byText(nameFilterField)).closest(".filterdd__filter").$("div.react-datepicker__month div.react-datepicker__day").click();
        String endDate = $(byText(nameFilterField)).closest(".filterdd__filter").$("input.datepicker__inp", 1).getValue();
        if (startDate.equals(endDate)) {
            error("Не установилась дата поля: " + nameFilterField);
        }
        startDate = $(byText(nameFilterField)).closest(".filterdd__filter").$("input.datepicker__inp", 1).getValue();

        //Клик по самой последней дате
        $(byText(nameFilterField)).closest(".filterdd__filter").$("li.datepicker__item", 2).click();
        ElementsCollection dateAll = $(byText(nameFilterField)).closest(".filterdd__filter").$("div.react-datepicker__month").$$("div.react-datepicker__day");
        for (int i = 0; i < dateAll.size(); i++) {
            if (i == dateAll.size() - 1) {
                $(byText(nameFilterField)).closest(".filterdd__filter").$("div.react-datepicker__month").$("div.react-datepicker__day", i).click();
                break;
            }
        }
        endDate = $(byText(nameFilterField)).closest(".filterdd__filter").$("input.datepicker__inp", 1).getValue();
        if (startDate.equals(endDate)) {
            error("Не установилась дата поля: " + nameFilterField);
        }
        //Ввод даты вручную
        $(byText(nameFilterField)).closest(".filterdd__filter").$("input.datepicker__inp", 1).setValue(dateTo);
        endDate = $(byText(nameFilterField)).closest(".filterdd__filter").$("input.datepicker__inp", 1).getValue();
        if (!endDate.equals(dateTo)) {
            error("Не установилась дата поля: " + nameFilterField);
        }

    }
}

package appmanager;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import java.util.ArrayList;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

import static sun.management.Agent.error;

public class Filters {

    //Кнопка "Применить"
    public SelenideElement applyFilter = $("#wrapper div.cardbox div.filterdd__wrapp").$(byText("Применить"));

    //Кнопка "Сбросить все фильтры"
    public SelenideElement resetFilter = $("#wrapper div.cardbox div.filterdd__wrapp").$(byText("Сбросить все фильтры"));

    //Открытие фильтра и проверка его видимости на странице
    public void openFilter() {
        $(byText("Фильтр")).click();
        $("#wrapper div.cardbox div.filterdd__wrapp").shouldBe(Condition.visible);
    }
    //Закрытие фильтра и проверка его невидимости
    public void closeFilter() {
        $("#wrapper div.cardbox div.filterdd__wrapp").$(byText("Cкрыть фильтр")).click();
        $("#wrapper div.cardbox div.filterdd__wrapp").shouldNotBe(Condition.visible);
    }

    //Установка дат
    public void setDate(String nameFilterField, String dateFrom, String dateTo) {
        $(byText(nameFilterField)).closest(".filterdd__filter").$("input.datepicker__inp").setValue(dateFrom);
        $(byText(nameFilterField)).closest(".filterdd__filter").$("input.datepicker__inp", 1).setValue(dateTo);
    }

    //Ввод значение в текстовое поле фильтра
    public void inputFilter(String nameFilterField, String valueFilter) {
        $(byText(nameFilterField)).closest(".filterdd__filter").$("input.form__inp").setValue(valueFilter);
    }

    //Выбор значение в drop-down меню
    public void dropDownFilter(String nameFilterField, String valueFilter) {
        $(byText(nameFilterField)).closest(".filterdd__filter").$("span.Select-arrow").click();
        $(byText(nameFilterField)).closest(".filterdd__filter").$("span.Select-arrow").click();
        $(byText(nameFilterField)).closest(".filterdd__filter").$("div.Select-menu-outer").$(byText(valueFilter)).click();
    }

    //Проверка фильтра
    public void checkFilter(String nameFilterField, String nameColumn,String valueFilter) {
        //Установка значения и применение фильтра
        $(byText(nameFilterField)).closest(".filterdd__filter").$("input.form__inp").setValue(valueFilter);
        $("#wrapper div.cardbox div.filterdd__wrapp").$(byText("Применить")).click();
        //Коллекции столбцов и кол-ва получившихся строк
        ElementsCollection columnsHeader = $("#wrapper div.block__cont table._fondreq thead").$$("td");
        ElementsCollection numberLine = $("#wrapper div.block__cont table._fondreq tbody").$$("tr");
        String[] valuesColumn = new String[numberLine.size()];
        //Цикл проверки
        for (int i = 0; i<columnsHeader.size(); i++) {
            String nameColumnCurrent = $("#wrapper div.block__cont table._fondreq thead").$("td", i).text();
            if (nameColumnCurrent.equals(nameColumn)) {
                for (int j = 0; j < numberLine.size(); j++) {
                    valuesColumn[j] = ($("#wrapper div.block__cont table._fondreq tbody").$("tr", j).$("td", i).text());
                }
            }

        }
        for (int i = 0; i<valuesColumn.length; i++) {
            if (!valuesColumn[i].equals(valueFilter)) {
                error("Ошибка фильтрации поля: " + nameFilterField);
            }
        }
    }


}

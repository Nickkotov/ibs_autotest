package Page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Text;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FundRequests {
    //Наименование полей табличной части страницы
    public String requestCreationDate = "Дата создания запроса";
    public String requestNumber = "№ запроса";
    public String registeredRequest = "Зарегистрированный запрос";
    public String registrationDate = "Дата регистрации";
    public String requestType = "Тип запроса";
    public String requestSubject = "Тематика запроса";
    public String requestStatus = "Статус";

    //Кнопка создания запроса
    public SelenideElement createRequest = $("#wrapper").$(byText("Новый запрос"));

    //Блок шапки табличной части страницы
    public SelenideElement findTableHeader(String nameColumn) {
        SelenideElement column = $("#wrapper div.block__cont table._fondreq").$(byText(nameColumn));
        return column;
    }

    //Метод получения коллекции элементов в табличной части документа
    public ElementsCollection getValueColumn() {
        ElementsCollection valuesColumn = $("#wrapper div.block__cont table._fondreq tbody").$$("tr");
        return valuesColumn;
    }




}

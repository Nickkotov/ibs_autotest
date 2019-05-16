package Page;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class HomePageInsured {

    //Коллекция плашек
    public String meansRehabilitation = "Технические средства реабилитации";
    public String payoutСalculator = "Калькулятор выплат";
    public String benefits = "Пособия и выплаты";
    public String requestsFund = "Запросы в Фонд";
    public String rehabilitationPrograms = "Программы реабилитации";
    public String sanatoriumTreatment = "Санаторно-курортное лечение";
    public String accident = "Возмещение по несчастным случаям";
    public String personalNavigator = "Персональный информационный навигатор";
    public String birthCertificates = "Родовые сертификаты";
    public String appointmentsToFund = "Записи на прием в Фонд";
    public String helpMagazine = "Журнал справок";

    //Метод поиска плашки
    public SelenideElement findCard(String nameCard) {
        SelenideElement card = $("div.tiles").$(byText(nameCard));
        return card;
    }

}

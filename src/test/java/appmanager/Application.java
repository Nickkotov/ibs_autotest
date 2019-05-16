package appmanager;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class Application {

    //Проверка смены вила отображения элементов на странице
    public void checkChangeView() {
        $("#wrapper div.cardbox__right div.type-toggle div._tiles").click();
        $("#wrapper div.cardbox__tabs li.tiles__item").shouldBe(Condition.visible);
        $("#wrapper div.cardbox__right div.type-toggle div._table").click();
        $("#wrapper div.block__cont table._fondreq tbody tr").shouldBe(Condition.visible);
    }

    //Переход на новую вкладку и закрытие старой
    public void tabClose() {
        switchTo().window(0).close();
        switchTo().window(0);
    }

    //Закрытие всплывающего окна
    public void popUp() {
        org.openqa.selenium.Alert alert = WebDriverRunner.getWebDriver().switchTo().alert();
        alert.accept();
    }

}

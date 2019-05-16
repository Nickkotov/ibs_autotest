package appmanager;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class Authorization {

    protected final Application app = new Application();

    public void loginInsuredAccount() throws InterruptedException {
        $("#cabinets-inner a").click();
        app.tabClose();
        $(byText("СНИЛС")).click();
        Thread.sleep(1000);
        String[] snils = {"0", "0", "0", "0", "0", "0", "6", "0", "0", "0", "5"};
        for (int i=0; i<11; i++) {
            $("#snils").sendKeys(snils[i]);
            Thread.sleep(50);
        }
        $("#password").setValue("11111111");
        $("#loginByPwdButton").click();
        $("#namePersonRole").click();
    }
}

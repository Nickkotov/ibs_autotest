package Tests;

import Page.FundRequests;
import Page.HomePageInsured;
import appmanager.Application;
import appmanager.Authorization;
import appmanager.Calendars;
import appmanager.Filters;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import static com.codeborne.selenide.Selenide.open;


public class TestBase {

    protected Authorization authorization = null;
    protected FundRequests fundRequests = null;
    protected HomePageInsured homePageInsured = null;
    protected Application application = null;
    protected Filters filters = null;
    protected Calendars calendars = null;

    WebDriver webDriver = null;
    @Before
    public void setup() {
        chrome();
        open("https://lk-test.fss.ru/");
        authorization = new Authorization();
        fundRequests = new FundRequests();
        homePageInsured = new HomePageInsured();
        application = new Application();
        filters = new Filters();
        calendars = new Calendars();
    }

    @After
    public void close() {
        webDriver.close();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    protected byte[] saveAllureScreenshot() {
        return ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES);
    }


    public void chrome() {
        System.setProperty("webdriver.chrome.driver","C:\\Projects\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        webDriver = new ChromeDriver(options);
        WebDriverRunner.setWebDriver(webDriver);
    }

}


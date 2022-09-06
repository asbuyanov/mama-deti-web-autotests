package tests;

import common.CommonActions;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.*;

import static constants.Configuration.*;
import static constants.TestData.*;

/**
 * Базовый класс с общими основными параметрами и методами для всех тестов.
 * От этого класса будут наследоваться классы для других тестов.
 */
public class BaseTest {

    protected WebDriver driver = CommonActions.createDriver();

    protected BasePage basePage = new BasePage(driver);
    protected MainPage mainPage = new MainPage(driver);
    protected SpbMainPage spbMainPage = new SpbMainPage(driver);
    protected SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
    protected ServicePage servicePage = new ServicePage(driver);

    /**
     * Развернуть окно браузера на весь экран.
     */
    public void setUpDriver() {
        driver.manage().window().maximize();
    }

    /**
     * Устанавливает куки.
     */
    public void setCookies() {
        if (SKIP_MESSAGE_COOKIES) {
            Cookie setCookiesMessageHidden = new Cookie(NAME_MESSAGE_COOKIES_HIDDEN, VALUE_MESSAGE_COOKIES_HIDDEN);
            driver.manage().addCookie(setCookiesMessageHidden);
        }
    }

    /**
     * Удаляет все куки.
     */
    public void deleteCookies() {
        if (DELETE_COOKIES) {
            driver.manage().deleteAllCookies();
        }
    }

    /**
     * Очищает Session Storage.
     */
    public void deleteSessionStorage() {
        if (DELETE_SESSION_STORAGE) {
            JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
            javaScriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    /**
     * Закрывает браузер и выключает вебдрайвер.
     */
    public void close() {
        if (QUIT_BROWSER) {
            driver.quit();
        }
    }

    @BeforeClass
    public void testSettings() {
        setUpDriver();
    }

    @AfterMethod
    public void deleteCookiesAndSessionStorage() {
        deleteCookies();
        deleteSessionStorage();
    }

    @AfterClass (alwaysRun = true)
    public void testTearDown() {
        close();
    }
}

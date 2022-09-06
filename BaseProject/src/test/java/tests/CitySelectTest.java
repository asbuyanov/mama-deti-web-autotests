package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static constants.TestData.*;
import static pages.MainPage.*;

public class CitySelectTest extends BaseTest {

    @DataProvider
    public Object[][] citiesDomains() {
        return new Object[][]{
                {citySanktPeterburg, SPB_HOME_PAGE_URL},
                {cityNovosibirsk, NOVOSIBIRSK_HOME_PAGE_URL},
                {cityKazan, KAZAN_HOME_PAGE_URL},
        };
    }

    /**
     * [web001][web-002][web-003] Проверка: переключение городов с дефолтного (Москва) на города
     * Санкт-Петербург, Новосибирск, Казань ведут на соответствующие домены главной страницы сайта.
     * @param city город
     * @param url URL главной страницы для указанного города
     */
    @Test(description = "City selection from drop-down menu", groups = {"regress"},
            dataProvider = "citiesDomains")
    public void citySelect(By city, String url) {
        basePage.openPage(HOME_PAGE_URL);
        mainPage.cityShift(city);
        Assert.assertTrue(basePage.getActualUrl().contains(url));
    }
}
package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.TestData.*;

public class SearchTest extends BaseTest {

    /**
     * [web-006] Проверка: максимальное кол-во карточек на странице поисковой выдачи
     * не превышает заданного значения (по дефолту 10).
     */
    @Test (description = "Max card amount")
    public void maxSearchItemsTest() {
        basePage.openPage(HOME_PAGE_URL);
        Assert.assertTrue(mainPage.enterInputSearch(SEARCH_TEXT).resultItemsCount() <= MAX_SEARCH_ITEMS_AMOUNT);
    }

    /**
     * [web-007] Проверка: клик по ссылке из карточки результата поиска открывает соответствующий раздел сайта.
     */
    @Test (description = "Click on a link from search results")
    public void searchResultsLinkToServiceTest() {
        basePage.openPage(HOME_PAGE_URL);
        Assert.assertTrue(mainPage.enterInputSearch(SEARCH_TEXT)
                .clickOnSearchItemLink()
                .getCurrentUrl()
                .contains(SEARCH_TEXT_ASSERT_URL));
    }

    /**
     * [web-008] Проверка: поиск со страницы поисковой выдачи возвращает релевантный результат.
     */
    @Test (description = "Search from search results page")
    public void searchFromSearchResultsPage() {
        basePage.openPage(HOME_PAGE_URL);
        Assert.assertEquals(mainPage.enterInputSearch(SEARCH_TEXT)
                .clearInputSearchResultsPage()
                .enterInputSearchResultsPage(SEARCH_TEXT_ALTER)
                .getTitleFromSearchItem(), SEARCH_TEXT_ALTER);
    }
}

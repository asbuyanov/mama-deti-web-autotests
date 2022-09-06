package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Страница выдачи результатов поиска.
 */
public class SearchResultsPage extends BasePage {

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    private final By searchItem = By.xpath("//div[@class='search-item']");
    private final By searchItemTitle = By.xpath("//div[@class='search-item']/a/b");
    private final By searchItemLink = By.xpath("//div[@class='search-item']/a[contains(@href,'/services/eko/')]/b[text()='ЭКО']");
    private final By inputSearchResultsPage = By.cssSelector("main input[aria-label='Поиск по сайту']");

    //div[@class='search-item']/a/b

    /**
     * Возвращает кол-во карточек результатов поиска.
     * @return кол-во карточек
     */
    public int resultItemsCount() {
        return driver.findElements(searchItem).size();
    }

    /**
     * Клик по ссылке в карточке результата поиска и переход на страницу услуги.
     * @return новый экземпляр страницы услуги
     */
    public ServicePage clickOnSearchItemLink() {
        explicitlyWaitElementIsClickable(driver.findElement(searchItemLink)).click();
        implicitlyWait();
        return new ServicePage(driver);
    }

    /**
     * Очистить поле для ввода поискового запроса.
     * @return страница выдачи результатов поиска
     */
    public SearchResultsPage clearInputSearchResultsPage() {
        driver.findElement(inputSearchResultsPage).clear();
        return this;
    }

    /**
     * Поиск через основную (большую) поисковую строку.
     * @param searchString поисковый запрос
     * @return страница выдачи результатов поиска
     */
    public SearchResultsPage enterInputSearchResultsPage(String searchString) {
        driver.findElement(inputSearchResultsPage).sendKeys(searchString, Keys.ENTER);
        implicitlyWait();
        return this;
    }

    /**
     * Возвращает заголовок карточки результата поиска.
     * Для последующего сравнения сразу переведем результат в нижний регистр.
     * @return заголовок
     */
    public String getTitleFromSearchItem() {
        return driver.findElement(searchItemTitle).getText().toLowerCase();
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

/**
 * Главная страница - основная логика и параметры.
 */
public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private final By inputSearch = By.name("q");
    public static By citySelector = By.xpath("//button[@class='header__logo-city open-city-tooltip']");
    public static By citySanktPeterburg = By.xpath("//a[text()='Санкт-Петербург']");
    public static By cityNovosibirsk = By.xpath("//a[text()='Новосибирск']");
    public static By cityKazan = By.xpath("//a[text()='Казань']");
    public static By btnAppointmentHeader = By.xpath("//div[@class='header__body ']//button[contains(text(),'Записаться на приём')]");
    public static By formAppointmentPopup = By.xpath("//div[@class='form-main form-main_independent form-main_popup']");
    public static By formAppointmentPopupTitleText = By.cssSelector("div.popup div.form-main__title");

    /**
     * Поиск через поисковую строку в шапке.
     * @param searchString поисковый запрос
     * @return страница выдачи результатов поиска
     */
    public SearchResultsPage enterInputSearch(String searchString) {
        driver.findElement(inputSearch).sendKeys(searchString, Keys.ENTER);
        implicitlyWait();
        return new SearchResultsPage(driver);
    }

    /**
     * Переключить город на Санкт-Петербург.
     */
    public void spbCityShift() {
        driver.findElement(citySelector).click();
        driver.findElement(citySanktPeterburg).click();
        implicitlyWait();
    }
    /**
     * Переключить город на Новосибирск.
     */
    public void novosibCityShift() {
        driver.findElement(citySelector).click();
        driver.findElement(cityNovosibirsk).click();
        implicitlyWait();
    }
    /**
     * Переключить город на Казань.
     */
    public void kazanCityShift() {
        driver.findElement(citySelector).click();
        driver.findElement(cityKazan).click();
        implicitlyWait();
    }

    /**
     * Переключиться на желаемый город кликом по соответствующей ссылке.
     * @param locator ссылка на город в drop-down меню под лого
     */
    public void cityShift(By locator) {
        driver.findElement(citySelector).click();
        driver.findElement(locator).click();
        implicitlyWait();
    }

    /**
     * Клик по кнопке "Записаться на приём".
     * @return экземпляр главной страницы
     */
    public MainPage clickOnBtnAppointmentHeader() {
        explicitlyWaitElementIsClickable(driver.findElement(btnAppointmentHeader)).click();
        return this;
    }

    /**
     * Возвращает текст заголовка попапа записи на приём.
     * @return текст заголовка
     */
    public String getTextFromPopupAppointmentTitle() {
        explicitlyWaitElementIsVisible(driver.findElement(formAppointmentPopup));
        return driver.findElement(formAppointmentPopupTitleText).getText();
    }

}
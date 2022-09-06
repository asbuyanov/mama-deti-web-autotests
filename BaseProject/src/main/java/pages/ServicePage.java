package pages;

import org.openqa.selenium.WebDriver;

/**
 * Любая страница раздела "Направления" (https://mamadeti.ru/services/)
 */
public class ServicePage extends BasePage{

    public ServicePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Возвращает текущий URL страницы
     * @return URL страницы
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constants.Configuration.EXPLICITLY_WAIT;
import static constants.Configuration.IMPLICITLY_WAIT;

/**
 * Базовый класс, описывающий общее поведение для всех страниц.
 * От этого класса будут наследоваться классы для других страниц.
 */
public class BasePage {

    protected WebDriver driver;

    private final By btnAcceptCookies = By.xpath("//button[text()='Согласен']");

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Открыть страницу, используя URL.
     * @param url URL страницы
     */
    public void openPage (String url) {
        driver.get(url);
        implicitlyWait();
    }

    /**
     * Перезагрузить текущую страницу.
     */
    public void refreshPage() {
        driver.navigate().refresh();
        implicitlyWait();
    }

    /**
     * Подтверждение использования куков нажатием на кнопку "Согласен".
     * Если не скрыть попап о куках, взаимодействия с элементами страницы могут быть недоступны.
     */
    public void acceptCookiesMessage() {
        driver.findElement(btnAcceptCookies).click();
    }

    /**
     * Получить текущий URL страницы.
     */
    public String getActualUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Неявное ожидание появления элементов в DOM.
     */
    public void implicitlyWait() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITLY_WAIT));
    }

    /**
     * Явное ожидание видимости элемента на странице.
     * @param element элемент
     * @return элемент
     */
    public WebElement explicitlyWaitElementIsVisible(WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(EXPLICITLY_WAIT))
                .until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Явное ожидание кликабельности элемента.
     * @param element элемент
     * @return элемент
     */
    public WebElement explicitlyWaitElementIsClickable(WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(EXPLICITLY_WAIT))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

}

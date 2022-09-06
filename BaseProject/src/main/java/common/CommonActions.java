package common;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import static constants.Configuration.BROWSER;

/**
 * Общие базовые действия.
 */
public class CommonActions {
    /**
     * Создать вебдрайвер в соответствие с конфигурацией для одного из браузеров (chrome/firefox/edge).
     * @return требуемый вебдрайвер
     */
    public static WebDriver createDriver() {
        WebDriver driver = null;
        switch (BROWSER) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                /**
                 * Вывести сообщение, если введен неподдерживаемый браузер
                 * либо если браузер введен с ошибкой.
                 */
                Assert.fail("Incorrect browser: " + BROWSER);
        }
        return driver;
    }
}
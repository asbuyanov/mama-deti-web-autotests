package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static constants.TestData.CLINIC_NAME_SPB_LAHTA;
import static constants.TestData.CLINIC_NAME_SPB_MOTHER_AND_CHILD;

/**
 * Главная страница сайта для домена Санкт-Петербург (https://sankt-peterburg.mamadeti.ru/).
 */
public class SpbMainPage extends BasePage {

    public SpbMainPage(WebDriver driver) {
        super(driver);
    }

    public static By btnAppointmentHeader = By.xpath("//div[@class='header__body ']//button[contains(text(),'Записаться на приём')]");
    public static By formAppointmentPopup = By.xpath("//div[@class='form-main form-main_independent form-main_popup']");
    public static By inputUserName = By.name("name");
    public static By inputUserPhone = By.name("phone");
    public static By inputUserEmail = By.name("email");
    public static By dropdownClinic = By.xpath("//span[@class='select2-selection__arrow']");
    public static By clinicHospitalMdGroupLahta = By.xpath("//li[text()='Клинический госпиталь MD GROUP ЛАХТА']");
    public static By clinicMotherAndChildSpb = By.xpath("//li[text()='Клиника «Мать и дитя» Санкт-Петербург']");
    public static By appointmentBtnPopup = By.xpath("//div[@class='popup-container']//button[contains(text(),'Записаться на приём')]");

    public static By titlePopupAppointmentSend = By.cssSelector("div.popup h2.popup__title");

    /**
     * Вызвать попап записи на прием кликом по кнопке в шапке.
     */
    public SpbMainPage clickBtnAppointment() {
        explicitlyWaitElementIsClickable(driver.findElement(btnAppointmentHeader)).click();
        return this;
    }

    /**
     * Заполнить и отправить форму записи на прием.
     * @param userName имя
     * @param userPhone номер телефона
     * @param userEmail почта
     * @param clinic клиника
     * @return страница с заполненной формой
     */
    public SpbMainPage enterDataToAppointmentFormPopup(String userName, String userPhone, String userEmail, String clinic) {
        driver.findElement(inputUserName).sendKeys(userName);
        driver.findElement(inputUserPhone).sendKeys(userPhone);
        driver.findElement(inputUserEmail).sendKeys(userEmail);
        driver.findElement(dropdownClinic).click();
        switch (clinic) {
            case (CLINIC_NAME_SPB_LAHTA):
                driver.findElement(clinicHospitalMdGroupLahta).click();
                break;
            case (CLINIC_NAME_SPB_MOTHER_AND_CHILD):
                driver.findElement(clinicMotherAndChildSpb).click();
                break;
            default:
                Assert.fail("Incorrect clinic: " + clinic);
        }
        explicitlyWaitElementIsClickable(driver.findElement(appointmentBtnPopup));
        driver.findElement(appointmentBtnPopup).click();
        return this;
    }

    /**
     * Возвращает текст из заголовка попапа "Заявка успешно отправлена".
     * @return текст заголовка
     */
    public String getTextFromTitleAppointmentSend() {
       return explicitlyWaitElementIsVisible(driver.findElement(titlePopupAppointmentSend)).getText();
    }

}

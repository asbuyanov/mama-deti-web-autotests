package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static constants.TestData.*;

public class AppointmentTest extends BaseTest {

    /**
     * [web-004] Проверка: клик по кнопке "Записаться на прием" в шапке открывает форму для записи.
     */
    @Test (description = "Appointment form activation", groups = {"smoke", "regress"})
    public void popupAppointmentAppear() {
        basePage.openPage(HOME_PAGE_URL);
        mainPage.clickOnBtnAppointmentHeader();
        Assert.assertEquals(mainPage.getTextFromPopupAppointmentTitle(), TITLE_POPUP_APPOINTMENT_STRING);
    }

    /**
     * [web-005] Проверка: после заполнения и отправки формы записи на приём появляется попап "Заявка успешно отправлена".
     */
    @Test (description = "Fill and send the appointment form", groups = {"smoke", "regress"},
            dependsOnMethods = "popupAppointmentAppear")
    public void fillingAppointmentFormTest() {
        basePage.openPage(HOME_PAGE_URL);
        mainPage.spbCityShift();
        spbMainPage.clickBtnAppointment()
                .enterDataToAppointmentFormPopup(USER_NAME, USER_PHONE_NUMBER, USER_EMAIL, CLINIC_NAME_SPB_MOTHER_AND_CHILD);
        Assert.assertEquals(spbMainPage.getTextFromTitleAppointmentSend(), TITLE_POPUP_APPOINTMENT_SEND_STRING);
    }
}

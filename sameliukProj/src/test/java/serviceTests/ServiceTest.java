package serviceTests;

import org.junit.Test;
import parentTest.ParentTest;

public class ServiceTest extends ParentTest {

    /*Test Case 3
Summary:        На странице редактирования «Обслуживание»
		        http://v3.test.itpmgroup.com/dictionary/service/edit
                проверить наличие добавленного в Библиотеку в опцию «Аппарат» нового элемента списка
                в открывающемся drop-down списке в текстовом поле Аппарат. */

    @Test
    public void checkNewApparatInDD() {
        loginPage.userLogin("Student", "909090");
        homePage.clickOnMenueService();
        servicePage.clickOnAnyElementInList();
        editServicePage.clickOnFieldApparat();
        editServicePage.assertApparatPresent("Сломан датчик");

    }
}

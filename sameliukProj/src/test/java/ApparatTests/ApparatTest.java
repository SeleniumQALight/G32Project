package ApparatTests;

import org.junit.Test;
import parentTest.ParentTest;

public class ApparatTest extends ParentTest {

    final String apparatNumber = "15";
    final String apparatComment = "Сломан датчик";

    /* Test Case 2
     Summary:      На странице «Аппарат» проверить функцию добавления строки в список аппаратов.*/

    @Test
    public void addNewApparat() {
        loginPage.userLogin("Student", "909090");
        homePage.clickOnmenueDictionary();
        homePage.clickOnSubmenueApparat();
        apparatPage.clickOnButtonPlus();
        editApparatPage.enterApparatNumber(apparatNumber);
        editApparatPage.enterApparatComment(apparatComment);
        editApparatPage.clickOnButtonCreate();
        checkAC("New apparat is not added", apparatPage.isNewApparatAdded(apparatComment), true);
    }
    /*Test Case 4
Summary:        На странице «Аппарат» проверить функцию удаления учетной записи из списка аппаратов. */

    @Test
    public void deleteApparat() {
        loginPage.userLogin("Student", "909090");
        homePage.clickOnmenueDictionary();
        homePage.clickOnSubmenueApparat();
        editApparatPage.clickOnAnyApparatInList();
        editApparatPage.clickOnButtonDelete();
    }

    /*Test Case 5
Summary:  На странице «Аппарат» проверить функцию редактирования учетной записи из списка аппаратов. */
    @Test
    public void editApparat() {
        loginPage.userLogin("Student", "909090");
        homePage.clickOnmenueDictionary();
        homePage.clickOnSubmenueApparat();
        editApparatPage.clickOnAnyApparatInList();
        editApparatPage.enterApparatNumber(apparatNumber);
        editApparatPage.enterApparatComment(apparatComment);
        editAnyApparatPage.clickOnButtonSave();


    }
}

package spareTest;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;


public class AddNewSpareTest extends ParentTest {
    final String nameOfNewSpare = "testingSpare";

    @Test
    public void addNewSpare(){
        loginPage.userLogin("Student","909090");
        homePage.checkIsAvatarPresent();
        homePage.clickMenuDictionary();
        homePage.clickOnSubMenuSpare();
        sparesPage.checkCurrentUrl();
        sparesPage.clickAddButton();
        editSparesPage.checkCurrentUrl();
        editSparesPage.enterSpareName(nameOfNewSpare);
        editSparesPage.selectSpareType("4");
        editSparesPage.clickButtonCreate();
        sparesPage.checkCurrentUrl();
        checkAC("New spare wasn't added", true,sparesPage.isNewSpareAdded(nameOfNewSpare));

    }

    @After
    public void deletingNewSpare(){
    while (sparesPage.isNewSpareInList(nameOfNewSpare)) {
        sparesPage.clickOnSpare(nameOfNewSpare);
        editSparesPage.clickButtonDelete();
    }
    }
}

package spareTest;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {
    final String nameOfNewSpare = "Monitor";

    @Test
    public void addNewSpare (){
        loginPage.userLogin("Student", "909090");
        homePage.checkAvatarIsPresent();
        homePage.checkCurrentURL();
        homePage.clickOnMenuDictionary();
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        homePage.clickOnSubmenuSpare();
        sparesPage.checkCurrentURL();
        sparesPage.clickOnButtonAdd();
        editSapresPage.checkCurrentURL();
        editSapresPage.enterSpareName(nameOfNewSpare);
        editSapresPage.selectSpareType("4");
        editSapresPage.clickButtonCreate();
        sparesPage.checkCurrentURL();
        checkAC("New Spare was not added", sparesPage.isNewSpareAdded(nameOfNewSpare), true);
    }

    @After
    public void deletingNewSpare (){
        while (sparesPage.isSpareInList(nameOfNewSpare)){
            sparesPage.clickOnSpare(nameOfNewSpare);
            editSapresPage.clickButtonDelete();
        }
    }

}

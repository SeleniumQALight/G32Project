package spareTest;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest{
    final  String namaOfNewSpare = "SuperSpare";

    @Test
    public void addNewSpare(){
        loginPage.userLogin("Student", "909090");
        homePage.checkAvatarIsPresent();
        homePage.checkCurrentUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();
        sparesPage.checkCurrentUrl();
        sparesPage.clickOnButtonPlus();
        editeSparesPage.checkCurrentUrl();
        editeSparesPage.enterSpareName(namaOfNewSpare);
        editeSparesPage.selectSpareType("4");
        editeSparesPage.clickButtonCreate();
        sparesPage.checkCurrentUrl();

        checkAC("New Spare is wasn't added", sparesPage.isNewSpareAdded(namaOfNewSpare), true); //проверка что занеслось
    }

    @After
    public void deletingNewSpare(){
        while (sparesPage.isSpareInList(namaOfNewSpare)) {
            sparesPage.clickOnSpare(namaOfNewSpare);
            editeSparesPage.clickButtonDelete();
        }

    }
}


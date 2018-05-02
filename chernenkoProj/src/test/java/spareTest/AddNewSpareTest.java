package spareTest;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {
    final String nameOfNewSpare = "machine";

    @Test
    public void addNewSpareTest(){
        loginPage.userLogin("Student","909090");
        homePage.checkAvatarIsPresent();
        homePage.checkCurrentUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();
        sparesPage.checkCurrentUrl();
        sparesPage.deletingAllSparesWithName(nameOfNewSpare);
        sparesPage.clickOnButtonPlus();
        editSpareePage.checkCurrentUrl();
        editSpareePage.enterSpareName(nameOfNewSpare);
        editSpareePage.selectSpareType("4");
        editSpareePage.clickButtonCreate();
        sparesPage.checkCurrentUrl();

        checkAC("New Spare was not added", sparesPage.isNewSpareAdded(nameOfNewSpare), true);
    }

    @After
    public void deletingNewSpare(){
       sparesPage.deletingAllSparesWithName(nameOfNewSpare);
    }
}

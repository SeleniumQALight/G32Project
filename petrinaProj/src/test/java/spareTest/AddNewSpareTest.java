package spareTest;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;


public class AddNewSpareTest extends ParentTest {
    final String nameOfNewSpare = "firstone";

    @Test
    public void addNewSpare() {
        loginPage.userLogin("Student", "909090");
        homePage.checkAvatarIsPresent();
        homePage.ckeckCurrentUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();
        sparesPage.ckeckCurrentUrl();
        sparesPage.deletingAllSparesWithName(nameOfNewSpare);
        sparesPage.clickOnButtonPlus();
        editSparesPage.ckeckCurrentUrl();
        editSparesPage.enterSpareName(nameOfNewSpare);
        editSparesPage.selectSpareType("4");
        editSparesPage.clickButtonCreate();
        sparesPage.ckeckCurrentUrl();

        checkAC("New Spare wasn't added", sparesPage.isNewSpareAdded(nameOfNewSpare), true);

    }

    @After
    public void deletingNewSpare() {
        sparesPage.deletingAllSparesWithName(nameOfNewSpare);
    }
}

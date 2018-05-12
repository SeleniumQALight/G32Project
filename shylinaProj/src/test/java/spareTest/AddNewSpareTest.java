package spareTest;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {
    final String nameOfNewSpare = "testSpare8";

    @Test
    public void addNewSpare() {
        loginPage.userLogin("student", "909090");
        homePage.checkAvatarIsPresent();
        homePage.checkCurrentUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpare();
        sparesPage.checkCurrentUrl();
        sparesPage.deletingAllSparesWithName(nameOfNewSpare);
        sparesPage.clicOnButtoPlus();
        editSparesPage.checkCurrentUrl();
        editSparesPage.enterSpareName(nameOfNewSpare);
        editSparesPage.selectSpareType("4");
        editSparesPage.clickButtoreate();
        editSparesPage.checkCurrentUrl();

        checkAC("New spare wasn't added", sparesPage.isNewSpareAdded(nameOfNewSpare), true);
    }

    @After
    public void deletingNewSpare() {
        sparesPage.deletingAllSparesWithName(nameOfNewSpare);
    }

}



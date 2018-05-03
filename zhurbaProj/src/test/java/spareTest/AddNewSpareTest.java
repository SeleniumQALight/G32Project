package spareTest;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {
    final String nameOfNewSpare = "Orehokol";

    @Test
    public void addNewSpare() {
        loginPage.userLogIn("Student", "909090");
        homePage.checkAvatarIsPresent();
        homePage.checkCurrentUrl();
        homePage.clickOnMenuDictionary();

        homePage.clickOnSubMenuSpare();
        sparesPage.checkCurrentUrl();
        sparesPage.deletingAllSparesWithName(nameOfNewSpare);
        sparesPage.clickOnButtonPlus();
        editSparesPage.checkCurrentUrl();
        editSparesPage.enterSpareName(nameOfNewSpare);
        editSparesPage.selectSpareType("4");
        editSparesPage.clickButtonCreate();
        sparesPage.checkCurrentUrl();

        checkAC("New Spare wasn't added.", sparesPage.isNewSpareAdded(nameOfNewSpare), true);
    }

    @After
    public void deletingNewSapre() {
        sparesPage.deletingAllSparesWithName(nameOfNewSpare);
    }

    ;

}

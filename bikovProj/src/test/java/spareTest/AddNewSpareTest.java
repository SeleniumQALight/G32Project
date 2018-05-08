package spareTest;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {

    final String nameOfNewSpare = "testSpare777";

    @Test
    public void addNewSpare() {
        loginPage.userLogin("Student", "909090");
        homePage.checkAvatarIsPresent();
        homePage.checkCurrentUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();
        sparesPage.checkCurrentUrl();
        sparesPage.deletingAllSparesWithName(nameOfNewSpare);
        sparesPage.clickOnButtonPlus();
        editSparesPage.checkCurrentUrl();
        editSparesPage.enterSpareName("TestName");
        editSparesPage.selectSpareType("4");
        editSparesPage.clickButtonCreate();
        sparesPage.checkCurrentUrl();

        checkAC("New Spare wasn't added", sparesPage.isNewSpareAdded(nameOfNewSpare),true);
    }

    @After
    public void deletingNewSpare(){
        sparesPage.deletingAllSparesWithName(nameOfNewSpare);
    }
}

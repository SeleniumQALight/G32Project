package spareTest;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {
    final String nameOfNewSpare = "Levitskiy Test Spare";
    @Test
    public void addNewSpare(){
        logInPage.userLogIn("Student", "909090");
        homePage.checkAvatarIsPresent();
        homePage.checkCurrentUrl();
        homePage.clickElementDictionary();
        homePage.clickOnSubMenuSpares();
        sparesPage.checkCurrentUrl();
        sparesPage.deletingAllSparesWithName(nameOfNewSpare);
        sparesPage.clickOnButtonPlus();
        editSparesPage.checkCurrentUrl();
        editSparesPage.enterSpareName(nameOfNewSpare);
        editSparesPage.selectSpareType("4");
        editSparesPage.clickButtonCreate();
        sparesPage.checkCurrentUrl();

        checkAC("New spare did not added", sparesPage.isNewSpareAdded(nameOfNewSpare), true);
    }
    @After
    public void deletingNewSpare(){
       sparesPage.deletingAllSparesWithName(nameOfNewSpare);
    }

}

package spareTest;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest{
    final String nameOfNewSpare = "ch-spare";
    @Test
    public void addNewSpare (){
        loginPage.userLogIn("Student","909090");
        homePage.checkAvatarIsPresent();
        homePage.checkCurrentUrl();
        homePage.clickOnMenuDictionary();
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        homePage.clickOnSubMenuSpares();
        sparesPage.checkCurrentUrl();
        sparesPage.deletingAllSparesWithName(nameOfNewSpare);
        sparesPage.clickOnButtonPlus();
        editSparesPage.checkCurrentUrl();
        editSparesPage.enterSpareName(nameOfNewSpare);
        editSparesPage.selectSpareType("4");
        editSparesPage.clickButtonCreate();
        sparesPage.checkCurrentUrl();

        checkAC("New spare was not added",sparesPage.isNewSpareAdded(nameOfNewSpare), true);


    }
    @After
    public void deletingNewSpare(){
        sparesPage.deletingAllSparesWithName(nameOfNewSpare);
    }
}

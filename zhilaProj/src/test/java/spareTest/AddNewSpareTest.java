package spareTest;

import org.junit.Test;
import parentTest.ParentTest;


public class AddNewSpareTest extends ParentTest {

    @Test
    public void addNewSpare(){
        loginPage.userLogin("Student","909090");
        homePage.checkIsAvatarPresent();
        homePage.clickMenuDictionary();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.clickOnSubMenuSpare();
        sparesPage.checkCurrentUrl();
        sparesPage.clickAddButton();
        editSparesPage.checkCurrentUrl();
        editSparesPage.enterSpareName("testSpare");
        editSparesPage.selectSpareType("4");
        editSparesPage.clickButtonCreate();
        sparesPage.checkCurrentUrl();

    }
}

package spareTest;

import org.junit.Test;
import parentTest.ParentTest;


public class AddNewSpareTest extends ParentTest {
    @Test
    public void addNewSpare(){
        loginPage.userLogin("Student","909090");
        homePage.checkAvatarIsPresent();
        homePage.ckeckCurrentUrl();
        homePage.clickOnMenuDictionary();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.clickOnSubMenuSpares();
        sparesPage.ckeckCurrentUrl();
        editSparesPage.ckeckCurrentUrl();
        editSparesPage.enterSpareName("testSpare");
        editSparesPage.selectSpareType("4");
        editSparesPage.clickButtonCreate();
        sparesPage.ckeckCurrentUrl();

    }
}

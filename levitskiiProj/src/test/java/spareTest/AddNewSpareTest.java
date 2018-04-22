package spareTest;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {
    @Test
    public void addNewSpare(){
        logInPage.userLogIn("Student", "909090");
        homePage.checkAvatarIsPresent();
        homePage.checkCurrentUrl();
        homePage.clickElementDictionary();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.clickOnSubMenuSpares();
        sparesPage.checkCurrentUrl();
        sparesPage.clickOnButtonPlus();
        editSparesPage.checkCurrentUrl();
        editSparesPage.enterSpareName("Levitskiy Test Spare");
        editSparesPage.selectSpareType("4");
        editSparesPage.clickButtonCreate();
        sparesPage.checkCurrentUrl();


    }
}

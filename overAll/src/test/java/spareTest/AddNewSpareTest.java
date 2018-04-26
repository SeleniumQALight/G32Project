package spareTest;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest{
    @Test
    public void addNewSpare(){
        loginPage.userLogIn("Student","909090");
        homePage.checkAvatarIsPresent();
        homePage.checkCurrentUrl();
        homePage.clickOnMenuDictionary();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.clickOnSubMenuSpares();
        sparesPage.checkCurrentUrl();
        sparesPage.clickOnButtonPlus();
        editeSparesPage.checkCurrentUrl();
//        editeSparesPage.enterSpareName();
        editeSparesPage.selectSpareType("4");
//        editeSparesPage.clickButtonCreate();
        sparesPage.checkCurrentUrl();

    }
}

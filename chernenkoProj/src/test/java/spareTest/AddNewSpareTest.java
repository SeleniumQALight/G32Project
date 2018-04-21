package spareTest;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {
    @Test
    public void addNewSpareTest(){
        loginPage.userLogin("Student","909090");
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
        editSpareePage.checkCurrentUrl();
        editSpareePage.enterSpareName("machine");
        editSpareePage.selectSpareType("4");
        editSpareePage.clickButtonCreate();
        sparesPage.checkCurrentUrl();
    }
}

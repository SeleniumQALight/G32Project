package spareTest;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {
    @Test
    public void addNewSpare (){
        loginPage.userLogin("Student", "909090");
        homePage.checkAvatarIsPresent();
        homePage.checkCurrentURL();
        homePage.clickOnMenuDictionary();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.clickOnSubmenuSpare();
        sparesPage.checkCurrentURL();
        sparesPage.clickOnButtonAdd();
        editSapresPage.checkCurrentURL();
        editSapresPage.enterSpareName();
        editSapresPage.selectSpareType("4");
        editSapresPage.clickButtonCreate();
        sparesPage.checkCurrentURL();


    }
}

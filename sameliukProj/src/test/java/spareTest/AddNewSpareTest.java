package spareTest;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest{
    @Test
    public void addNewSpare(){
        loginPage.userLogin("Student","909090");
        homePage.checkAvatarIsPresent();
        homePage.checkCurrentURL();
        homePage.clickOnmenueDictionary();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.clickOnSubmenueSpares();
        sparesPage.checkCurrentURL();
        sparesPage.clickOnButonPlus();
        editSparesPage.checkCurrentURL();
        editSparesPage.enterSpareName("Колесо");
        editSparesPage.selectSpareType("4");
        editSparesPage.clickButtonCreate();
        sparesPage.checkCurrentURL();


    }
}

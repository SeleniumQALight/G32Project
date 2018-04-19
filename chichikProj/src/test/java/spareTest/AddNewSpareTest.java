package spareTest;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.SparesPage;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest{

    @Test
    public void addNewSpare(){
        loginPage.userLogIn("Student", "909090");
        homePage.checkAvatarIsPresent();
        homePage.checkCurrentUrl();
        homePage.clickOnMenuDictionary();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.clickOnSubMenuSpare();
        sparePage.checkCurrentUrl();
        sparePage.clickAddButton();
        editSparesPage.checkCurrentUrl();
        editSparesPage.enterSpareName("newTestSpare");
        editSparesPage.selectSpareType("4");
        editSparesPage.clickButtonCreate();
        sparePage.checkCurrentUrl();


    }

}

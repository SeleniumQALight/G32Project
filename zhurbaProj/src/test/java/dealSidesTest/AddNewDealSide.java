package dealSidesTest;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewDealSide extends ParentTest {
    @Test
    public void addNewDealSide() {
        loginPage.userLogIn("Student", "909090");
        homePage.checkAvatarIsPresent();
        homePage.checkCurrentUrl();
        homePage.clickOnMenuDictionary();

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        homePage.clickOnSubMenuDealSides();
        dealSidesPage.clickOnButtonPlus();
        editDealSidesPage.checkCurrentUrl();
        editDealSidesPage.enterProCustName("Dealer#001");
        editDealSidesPage.enterProCustPhone("AB7872200");
        editDealSidesPage.enterProCustAddress("Spring City, Yellow str., 215");
        editDealSidesPage.setPrivatePersonCheckBox("uncheck");

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        editDealSidesPage.clickButtonCreate();
    }
}

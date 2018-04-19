package spareTest;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {
    @Test
    public void addNEwSpare (){
        logInPage.userLogIn("Student", "909090");
        homePage.checkAvatarIsPresent();
        homePage.clickElementDictionary();
        homePage.clickOnSubMenuSpares();
    }
}

package loginTests;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class LoginTestWithPageObject extends ParentTest {
    @Test
    public void validLogin() {
        loginPage.openPage();
        loginPage.enerLogin("Student");
        loginPage.enterPassword("909090");
        loginPage.submitAuthorisation();

        checkAC("Avatar is not present", homePage.isAvatarPresent(), true);
    }
    @Test
    public void invalidLogin (){
        loginPage.userLogin("Student","9069090");
        checkAC("Avatar should not be present", homePage.isAvatarPresent(), false);
    }
}

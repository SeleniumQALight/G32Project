package loginTests;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginTestWithPageObject extends ParentTest {

    @Test
    public void validLogIn(){
        loginPage.openPage();
        loginPage.enterLogIn("Student");
        loginPage.enterPass("909090");
        loginPage.clickSubmitButton();

        checkAcceptanceCriteria("avatar is not present", homePage.isAvatarPresent(), true);


    }

    @Test
    public void invalidLogin(){
        loginPage.userLogIn("Student", "906090");

        checkAcceptanceCriteria("avatar should not be present", homePage.isAvatarPresent(), false);
    }
}

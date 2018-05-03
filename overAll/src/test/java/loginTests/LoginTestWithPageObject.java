package loginTests;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginTestWithPageObject extends ParentTest{

    @Test
    public void validLogIn(){
        loginPage.openPage();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        loginPage.enterLogin("Student");
        loginPage.enterPass("909090");
        loginPage.clickSubmitButton();

        checkAC("Avatar is not present", homePage.isAvatarPresent(), true);
    }

    @Test
    public void invalidLogIn(){
        loginPage.userLogIn("Student","909090");

        checkAC("Avatar should not be present", homePage.isAvatarPresent(), false);

    }



}

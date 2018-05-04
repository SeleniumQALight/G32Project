package loginTests;

//import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class LoginTestWithPageObject extends ParentTest {
    @Test
    public void validLogIn (){
        loginPage.openPage();
        loginPage.enterLogin("Student");
        loginPage.enterPass("909090");
        loginPage.clickSubmitButton();
        //Assert.assertTrue("Avatar is not present", homePage.isAvatarPresent());
        checkAC(" Avatar is not present", homePage.isAvatarPresent(),true);
    }

    @Test
    public void invalidLogIn (){
        loginPage.userLogIn("Student","906090");

        checkAC("Avatar should not be present",homePage.isAvatarPresent(),false);
    }
}

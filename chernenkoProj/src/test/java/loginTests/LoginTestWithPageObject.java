package loginTests;


import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import parentTest.ParentTest;

public class LoginTestWithPageObject extends ParentTest{

    @Test
//    @Ignore
    public void validLogin(){
        loginPage.openPage();
        loginPage.enterLogin("Student");
        loginPage.enterPassword("909090");
        loginPage.clickSubmitButton();

        checkAC("Avatar is not present",homePage.isAvatarapresent(),true );
    }

    @Test
    public void invalidLogin(){
        loginPage.userLogin("Student","906090");

        checkAC("Avatar should not be present",homePage.isAvatarapresent(),false);
    }



}

package loginTests;

import org.junit.Test;
import parentTest.ParentTest;


public class LogInTestWithPageObject extends ParentTest{

    @Test
    public void validLogin(){
        loginPage.openPage();
        loginPage.enterLogin("Student");
        loginPage.enterPassword("909090");
        loginPage.clickSubmitButton();
        checkAC("Avatar is not Present", homePage.isElementPresent(),true);
    }

    @Test
    public void invalidLogin(){
        loginPage.userLogin("Student","3333366");
        checkAC("Avatar should not be Present", homePage.isElementPresent(),false);


    }
}

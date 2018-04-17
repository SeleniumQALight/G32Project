package loginTest;

import org.junit.Test;
import parentTest.ParentTest;


public class LoginTestWithPageObject extends ParentTest{
    @Test
    public  void  validLogIn() {
        logInPage.openPage();
        logInPage.enterLogin("Student");
        logInPage.enterPass("909090");
        logInPage.clickSubmitButton();
    }
}


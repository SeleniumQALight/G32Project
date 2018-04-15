package loginTest;

import org.junit.Test;
import parentTest.ParentTest;


public class LoginTestWithPageObject extends ParentTest{
    @Test
    public  void  validLogIn() {
        LogInPage.openPage();
        LogInPage.enterLogin("Student");
    }
    public void validPassword(){
        LogInPage.openPage();
        LogInPage.enterPassword("909090");
    }
    public void buttonVhod(){
        LogInPage.openPage();
        LogInPage.clickButton();
    }
}


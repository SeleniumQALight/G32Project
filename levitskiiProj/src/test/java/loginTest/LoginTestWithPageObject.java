package loginTest;

import org.junit.Test;
import parentTest.ParentTest;


public class LoginTestWithPageObject extends ParentTest{
    @Test
    public  void  validLogIn(){
        LogInPage.openPage();
        LogInPage.enterLogin ("Student");



    }
}

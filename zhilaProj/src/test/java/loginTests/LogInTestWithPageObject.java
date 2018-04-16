package loginTests;

import org.junit.Test;
import parentTest.ParentTest;


public class LogInTestWithPageObject extends ParentTest{

    @Test
    public void validLogin(){
        loginPage.openPage();
        loginPage.enterLogin("Student");
       loginPage.enterPassword("909090");

    }
}

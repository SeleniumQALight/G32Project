package loginTests;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginTestWithPageObject extends ParentTest {

    @Test
    public void validLogin (){
        loginPage.openPage();
        loginPage.enterLogin("Student");
        loginPage.enterPass("909090");
        loginPage.clickSubmitButton();
    }

}

package loginTests;

import org.junit.After;
import org.junit.Test;
import pages.LoginPage;
import parentTest.PaentTest;

public class LoginTestWithPageObject extends PaentTest {
    @Test
    public void validLogin(){
loginPage.openPage();
        loginPage.enerLogin("Student");
    }


}

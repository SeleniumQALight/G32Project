package loginTests;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginTestWithPageObject extends ParentTest {
    @Test
    public void validLogin() {
        loginPage.openPage();
        loginPage.enerLogin("Student");
        loginPage.enterPassword("909090");
        loginPage.submitAuthorisation();
    }
}

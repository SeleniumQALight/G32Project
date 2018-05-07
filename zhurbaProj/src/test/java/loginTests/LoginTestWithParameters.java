package loginTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.ParentPage;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
/*this record say about that the class will run with parameters*/
public class LoginTestWithParameters extends ParentTest {
    String login, pass;

    public LoginTestWithParameters(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters (name = "Parameters are {0} and {1}")
    /*this record say that next method will give parameters' set for running*/
    public static Collection testData() throws IOException {
        return Arrays.asList(new Object[][]{
                {"Student", "00000"},
                {"STTudent", "909090"}
        });
    }

    @Test
    public void invalidLogIn(){
        loginPage.userLogIn(login, pass);
        checkAC("Avatar should not be present", homePage.isAvatarPresent(), false);
    }
}

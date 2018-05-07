package loginTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;


@RunWith(Parameterized.class)
public class LoginTestWithParameters extends ParentTest{
    String login, pass;

    public LoginTestWithParameters(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters(name = " Parameters are {0} and {1}")
    public static Collection testData() throws IOException {
        return Arrays.asList(new Object[][] {
                {"Student", "00000"},
                {"Login", "909090"},
                {"", "909090"}
        });
    }

    @Test
    public void invalidLogin(){
        loginPage.userLogin(login, pass);

        checkAC("Avatar should not be present",homePage.isAvatarapresent(),false);
    }
}

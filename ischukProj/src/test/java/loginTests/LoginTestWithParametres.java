package loginTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LoginTestWithParametres extends ParentTest{
    String login, pass;

    public LoginTestWithParametres(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters (name="Parametres are {0} and {1}")
    public static Collection testData() throws IOException{
        return Arrays.asList(new Object[][]{
                {"Student", "0000"},
                {"LOGIN", "909090"}
        });
    }


    @Test
    public void invalidLogin(){
        loginPage.userLogIn(login,pass);

        checkAC("Avatar should not be present", homePage.isAvatarPresent(),false);
    }
}

package loginTests;

import libs.ConfigData;
import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
/*this record say about that the class will run with parameters*/
public class LoginTestWithParametersWithExcel extends ParentTest {
    String login, pass;

    public LoginTestWithParametersWithExcel(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters (name = "Parameters are {0} and {1}")
    /*this record say that next method will give parameters' set for running*/
    public static Collection testData() throws IOException {
        InputStream spreadsheet = new FileInputStream(ConfigData.getCfgValue("DATA_FILE_PATH") + "testDataSuit.xls");
        return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();
    }

    @Test
    public void invalidLogIn(){
        loginPage.userLogIn(login, pass);
        checkAC("Avatar should not be present", homePage.isAvatarPresent(), false);
    }
}

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
public class LoginTestWithParametersWithExel extends ParentTest {
    String login, pass;

    public LoginTestWithParametersWithExel(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters(name = " Parameters are {0} and {1}")
    public static Collection testData() throws IOException {
       InputStream spreadsheet  = new FileInputStream(
               ConfigData.getCfgValue("DATA_FILE_PATH") + "testDataSuite.xls");
        return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();
    }



    @Test
    public void invalidLogIn(){
        loginPage.userLogin(login, pass);

        checkAC("Avatar should not be present", homePage.isElementPresent(), false);

    }
}

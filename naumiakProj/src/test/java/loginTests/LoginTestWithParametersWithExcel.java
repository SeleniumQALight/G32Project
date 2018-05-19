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
import java.sql.Array;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class LoginTestWithParametersWithExcel extends ParentTest {
    String login, pass;

    public LoginTestWithParametersWithExcel(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters(name = " Parameters are {0} and {1}")
    public static Collection testData() throws IOException {
//        return Arrays.asList(new Object[][] {
//                {"LOGIN", "909090"},
//                {"", "909090"}
//        });

        InputStream spreadsheet = new FileInputStream(
                ConfigData.getCfgValue("DATA_FILE_PATH") + "testDataSuit.xls");
        return new SpreadsheetData(spreadsheet, "InvalidLogOn").getData();
    }


    @Test
    public void invalidLogIn(){
        loginPage.userLogin(login, pass);

        checkAC("Avatar should not be present", homePage.isAvatarPresent(), false);

    }
}

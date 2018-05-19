package loginTest;

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
public class LoginTestWithParametersWithExcel extends ParentTest {

    String login, password;

    public LoginTestWithParametersWithExcel(String login, String pass) {
        this.login = login;
        this.password = pass;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData()throws IOException {
        InputStream spreadsheet = new FileInputStream(ConfigData.getCfgValue("DATA_FILE_PATH")+ "testDataSuit.xls");
        return  new SpreadsheetData(spreadsheet, "invalidLogOn").getData();
    }


    @Test
    public void invalidLogOn(){
        logInPage.userLogIn(login, password);
        checkAC("Avatar should not be present",homePage.isAvatarPresent(),false);

    }
}

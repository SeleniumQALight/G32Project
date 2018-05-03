package loginTests;

import libs.ConfigProperties;
import libs.ExcelDriver;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;


public class LogInTestWithPageObjectWithExel extends ParentTest{

    @Test
    public void validLogOn() throws IOException {

        ExcelDriver excelDriver = new ExcelDriver();
        ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
        Map dataForValidLogin = excelDriver.getData(configProperties.DATA_FILE(),"validLogOn");
        loginPage.openPage();
        loginPage.enterLogin(dataForValidLogin.get("login").toString());
        loginPage.enterPassword(dataForValidLogin.get("pass").toString());
        loginPage.clickSubmitButton();
        checkAC("Avatar is not Present", homePage.isElementPresent(),true);
    }

    @Test
    public void invalidLogin(){
        loginPage.userLogin("Student","3333366");
        checkAC("Avatar should not be Present", homePage.isElementPresent(),false);


    }
}

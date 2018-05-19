package loginTests;


import libs.ConfigProperties;
import libs.ExcelDriver;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class LoginTestWithPageObjectWithExel extends ParentTest{


    @Test
    public void validLogOn() throws IOException {
        ExcelDriver excelDriver = new ExcelDriver();
        ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
        Map dataForValidLogin = excelDriver.getData(configProperties.DATA_FILE(), "validLogOn");
        loginPage.openPage();
        loginPage.enterLogin(dataForValidLogin.get("login").toString());
        loginPage.enterPassword(dataForValidLogin.get("pass").toString());
        loginPage.clickSubmitButton();

        checkAC("Avatar is not present",homePage.isAvatarapresent(),true );
    }

    @Test
    public void invalidLogin(){
        loginPage.userLogin("Student","906090");

        checkAC("Avatar should not be present",homePage.isAvatarapresent(),false);
    }



}

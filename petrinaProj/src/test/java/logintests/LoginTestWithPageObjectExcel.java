package logintests;

import libs.ConfigProperties;
import libs.ExcelDriver;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class LoginTestWithPageObjectExcel extends ParentTest {
    @Test
    public void validLogOn() throws IOException {
        ExcelDriver excelDriver = new ExcelDriver();
        ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
        Map dataForValidLogin = excelDriver.getData("/Users/MaksimAndreev/Desktop/Workspace/G32Project/petrinaProj/src/main/java/data/testData.xls","validLogOn");
loginPage.openPage();
loginPage.enterLogin(dataForValidLogin.get("login").toString());
loginPage.enterPass(dataForValidLogin.get("pass").toString());
loginPage.clickSubmitButton();

        checkAC("Avatar is not present", homePage.isAvatarPresent(),true);

    }


    @Test
    public void invalidLogin(){
        loginPage.userLogin("Student","909090");
        checkAC("Avatar should not be present", homePage.isAvatarPresent(),false);

    }



}

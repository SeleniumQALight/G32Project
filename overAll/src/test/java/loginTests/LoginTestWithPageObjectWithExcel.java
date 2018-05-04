package loginTests;

import libs.ConfigProperties;
import libs.ExcelDriver;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class LoginTestWithPageObjectWithExcel extends ParentTest{

    @Test
    public void validLogOn() throws IOException {
        ExcelDriver excelDriver = new ExcelDriver();
        ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
        Map dataForValidLogIn = excelDriver.getData("C:\\workspace\\G32Project\\overAll\\src\\main\\java\\data\\testData.xls", "validLogOn");
        loginPage.openPage();
        loginPage.enterLogin(dataForValidLogIn.get("login").toString());
        loginPage.enterPass(dataForValidLogIn.get("pass").toString());
        loginPage.clickSubmitButton();

        checkAC("Avatar is not present", homePage.isAvatarPresent(), true);
    }

    @Test
    public void invalidLogIn(){
        loginPage.userLogIn("Student","909090");

        checkAC("Avatar should not be present", homePage.isAvatarPresent(), false);

    }



}
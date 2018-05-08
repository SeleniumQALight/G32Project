package loginTests;

import libs.ConfigProperties;
import libs.ExcelDriver;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class LoginTestWithPageObjectWithExcel extends ParentTest {

    @Test
    public void validLogOn() throws IOException {
        ExcelDriver excelDriver = new ExcelDriver();
        ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
        Map dataForValidLogIn = excelDriver.getData("E:\\workSpace\\G32Project\\chichikProj\\src\\main\\java\\data\\testData.xls", "validLogOn");
        loginPage.openPage();
        loginPage.enterLogIn(dataForValidLogIn.get("login").toString());
        loginPage.enterPass(dataForValidLogIn.get("pass").toString());
        loginPage.clickSubmitButton();

        checkAcceptanceCriteria("avatar is not present", homePage.isAvatarPresent(), true);


    }

    @Test
    public void invalidLogin(){
        loginPage.userLogIn("Student", "906090");

        checkAcceptanceCriteria("avatar should not be present", homePage.isAvatarPresent(), false);
    }
}

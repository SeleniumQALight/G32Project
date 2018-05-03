package loginTest;

import libs.ConfigProperties;
import libs.ExcelDriver;
import org.aeonbits.owner.ConfigFactory;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;


public class LoginTestWithPageObjectWithExcel extends ParentTest{
    @Test
    public  void  validLogOn() throws IOException {
        ExcelDriver excelDriver = new ExcelDriver();
        ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
        Map dataForValidLogOn = excelDriver.getData("E:\\workSpace\\G32Project\\levitskiiProj\\src\\main\\java\\data\\testData.xls", "validLogOn");
        logInPage.openPage();
        logInPage.enterLogin(dataForValidLogOn.get("login").toString());
        logInPage.enterPass(dataForValidLogOn.get("pass").toString());
        logInPage.clickSubmitButton();

        checkAC("Avatar is not present", homePage.isAvatarPresent(), true);
    }
    @Test
    public void invalidLogIn(){
        logInPage.userLogIn("Student","906090");
        checkAC("Avatar should not be present",homePage.isAvatarPresent(),false);

    }
}


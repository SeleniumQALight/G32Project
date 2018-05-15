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
        Map dataForValidLigon = excelDriver.getData("C:\\workSpace\\G32Project\\zhurbaProj\\src\\main\\java\\data\\testData.xls", "validLogOn");
        loginPage.openPage();
        loginPage.enterLogin(dataForValidLigon.get("login").toString());
        loginPage.enterPassword(dataForValidLigon.get("pass").toString());
        loginPage.clickSubmitButton();

        checkAC("Avatar is NOT present", homePage.isAvatarPresent(), true);
    }

    @Test
    public void invalidLogIn(){
        loginPage.userLogIn("Student", "909090");

        checkAC("Avatar should not be present", homePage.isAvatarPresent(), true);
    }
}

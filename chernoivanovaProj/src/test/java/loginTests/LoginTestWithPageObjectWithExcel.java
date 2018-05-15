package loginTests;

//import org.junit.Assert;
        import libs.ConfigProperties;
        import libs.ExcelDriver;
        import org.aeonbits.owner.ConfigFactory;
        import org.junit.Test;
        import parentTest.ParentTest;

        import java.io.IOException;
        import java.util.Map;

public class LoginTestWithPageObjectWithExcel extends ParentTest {
    @Test
    public void validLogOn () throws IOException {
        ExcelDriver excelDriver = new ExcelDriver();
        ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
        Map dataForValidLogin = excelDriver.getData(configProperties.DATA_FILE(), "validLogOn");
//        Map dataForValidLogin = excelDriver.getData("C:\\workSpace\\G32Project\\chernoivanovaProj\\src\\main\\java\\data\\testData.xls", "validLogOn");
        loginPage.openPage();
        loginPage.enterLogin(dataForValidLogin.get("login").toString());
        loginPage.enterPass(dataForValidLogin.get("pass").toString());
        loginPage.clickSubmitButton();
        //Assert.assertTrue("Avatar is not present", homePage.isAvatarPresent());
        checkAC(" Avatar is not present", homePage.isAvatarPresent(),true);
    }

    @Test
    public void invalidLogIn (){
        loginPage.userLogIn("Student","909090");

        checkAC("Avatar should not be present",homePage.isAvatarPresent(),false);
    }
}

package loginTests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import parentTest.ParentTest;

import java.util.concurrent.TimeUnit;

public class LogInTestWithPageObject extends ParentTest{

    @Test
    public void validLogin(){
        loginPage.openPage();
    }
}

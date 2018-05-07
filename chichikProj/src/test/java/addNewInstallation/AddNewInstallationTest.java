package addNewInstallation;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewInstallationTest extends ParentTest {

    @Test
    public void addNewInstallation(){
        loginPage.userLogIn("Student", "909090");
        homePage.checkAvatarIsPresent();
        homePage.checkCurrentUrl();
        homePage.clickOnMenuInstallation();
        installation.clickAddButton();
        editInstallation.checkCurrentUrl();
       // editInstallation.clickAddButton();
        editInstallation.selectDayFromDD("4");
        editInstallation.selectMonthFromDD("4");
        editInstallation.selectYearFromDD("4");
        editInstallation.selectApparatFromDD("4");
        editInstallation.selectWorkerFromDD("4");
        editInstallation.clickSubmitButton();

    }
}

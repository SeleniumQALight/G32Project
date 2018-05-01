package providerTest;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewProviderTest extends ParentTest {

    @Test
    public void addNewProvider(){
        loginPage.userLogIn("Student", "909090");
        homePage.checkAvatarIsPresent();
        homePage.checkCurrentUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubmenuProviders();
    }
}

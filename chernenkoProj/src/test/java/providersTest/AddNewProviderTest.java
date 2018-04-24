package providersTest;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewProviderTest extends ParentTest {
    @Test
    public void addNewProviderTest(){
        loginPage.userLogin("Student","909090");
        homePage.checkAvatarIsPresent();
        homePage.checkCurrentUrl();
        homePage.clickOnMenuDictionary();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.clickOnSubMenuProviders();
        providersPage.checkCurrentUrl();
        providersPage.clickOnButtonPlus();
        editProvidersPage.checkCurrentUrl();
        editProvidersPage.enterCustName("aaa");
        editProvidersPage.enterCustAddress("aaa");
        editProvidersPage.enterCustPhone("111");
        editProvidersPage.selectCheckBoxPrivatePerson("check");
        editProvidersPage.clickButtonCreate();
        providersPage.checkCurrentUrl();


    }


}

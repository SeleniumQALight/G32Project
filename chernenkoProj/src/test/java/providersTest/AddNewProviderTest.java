package providersTest;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewProviderTest extends ParentTest {
    final String nameOfCustName = "aaa";
    final String nameOfCustAddress = "aaa";
    final String numberOfCustPhone = "111";

    @Test
    public void addNewProviderTest(){
        loginPage.userLogin("Student","909090");
        homePage.checkAvatarIsPresent();
        homePage.checkCurrentUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuProviders();
        providersPage.checkCurrentUrl();
        providersPage.deletingAllProvidersWithName(nameOfCustName);
        providersPage.clickOnButtonPlus();
        editProvidersPage.checkCurrentUrl();
        editProvidersPage.enterCustName(nameOfCustName);
        editProvidersPage.enterCustAddress(nameOfCustAddress);
        editProvidersPage.enterCustPhone(numberOfCustPhone);
        editProvidersPage.selectCheckBoxPrivatePerson("check");
        editProvidersPage.clickButtonCreate();
        providersPage.checkCurrentUrl();

        checkAC("New Provider was not added",
                providersPage.isNewProviderAdded(nameOfCustName),
                true);
    }

    @After
    public void deleteInNewProvider(){
        providersPage.deletingAllProvidersWithName(nameOfCustName);
    }

}

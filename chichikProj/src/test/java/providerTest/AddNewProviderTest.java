package providerTest;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewProviderTest extends ParentTest {

    final String nameOfProvider = "AnyName";

    @Test
    public void addNewProvider() {
        loginPage.userLogIn("Student", "909090");
        homePage.checkAvatarIsPresent();
        homePage.checkCurrentUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubmenuProviders();
        providersPage.checkCurrentUrl();
        providersPage.clickAddButton();
        editProviders.checkCurrentUrl();
        editProviders.enterProCustName("AnyName");
        editProviders.enterProCustAddress("anyAddress");
        editProviders.enterProCustPhone("0123456789");
        editProviders.clickCreateButton();
        providersPage.isProviderAdded(nameOfProvider);

        checkAcceptanceCriteria("new spare wasn't added", providersPage.isProviderAdded(nameOfProvider), true);
    }

    @After
    public void deleteProvider() {
        providersPage.deleteProviderWithName(nameOfProvider);
    }


}


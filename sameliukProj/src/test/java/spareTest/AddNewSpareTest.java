package spareTest;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {
    final String nameOfNewSpare = "Карбюратор";

    @Test
    public void addNewSpare() {
        loginPage.userLogin("Student", "909090");
        homePage.checkAvatarIsPresent();
        homePage.checkCurrentURL();
        homePage.clickOnmenueDictionary();

        //  try {
        //    Thread.sleep(4000);
        //  } catch (InterruptedException e) {
        //     e.printStackTrace();
        //  }

        homePage.clickOnSubmenueSpares();
        sparesPage.checkCurrentURL();
        sparesPage.deletingAllSparesWithName(nameOfNewSpare);
        sparesPage.clickOnButonPlus();
        editSparesPage.checkCurrentURL();
        editSparesPage.enterSpareName(nameOfNewSpare);
        editSparesPage.selectSpareType("4");
        editSparesPage.clickButtonCreate();
        sparesPage.checkCurrentURL();

        checkAC("New Spare is not added", sparesPage.isNewSpareAdded(nameOfNewSpare), true);

    }

    @After
    public void deletingNewSpare() {
       sparesPage.deletingAllSparesWithName(nameOfNewSpare);
        }
    }


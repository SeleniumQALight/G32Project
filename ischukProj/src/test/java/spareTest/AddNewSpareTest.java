package spareTest;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest{
    final String nameOfNewSpare ="testSpare";
    @Test
    public void addNewSpare(){
        loginPage.userLogIn("Student", "909090");
        homePage.checkAvatarIsPresent();
        homePage.checkCurrentUrl();
        homePage.clickOnMenuDictionary();
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        homePage.clickOnSubMenuSpares();
        sparesPage.checkCurrentUrl();
        sparesPage.deletingAllSparesWithName(nameOfNewSpare);
        sparesPage.clickOnButtonPlus();
        editeSparesPage.checkCurrentUrl();
        editeSparesPage.enterSpareName(nameOfNewSpare);
        editeSparesPage.selectSpareType("4");
        editeSparesPage.clickButtonCreate();
        sparesPage.checkCurrentUrl();
        checkAC("New speare wasn`t added", sparesPage.isNewSpareAdded(nameOfNewSpare), true);
        }
        @After
    public void deletingNewSpare(){
       //loginPage.userLogin("Student", "909090");
            sparesPage.deletingAllSparesWithName(nameOfNewSpare);


        }


    }



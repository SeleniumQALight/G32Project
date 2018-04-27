package spareTest;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest{
    final  String nameOfNewSpare = "SuperS";

    @Test
    public void addNewSpare(){
        loginPage.userLogin("Student", "909090");
        homePage.checkAvatarIsPresent();
        homePage.checkCurrentUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpares();
        sparesPage.checkCurrentUrl();
        sparesPage.deletingAllSparesWithName(nameOfNewSpare);  //удаляем предварительно перед добавлением
        sparesPage.clickOnButtonPlus();
        editeSparesPage.checkCurrentUrl();
        editeSparesPage.enterSpareName(nameOfNewSpare);
        editeSparesPage.selectSpareType("4");
        editeSparesPage.clickButtonCreate();
        sparesPage.checkCurrentUrl();

        checkAC("New Spare is wasn't added", sparesPage.isNewSpareAdded(nameOfNewSpare), false); //проверка что занеслось
    }

    @After
    public void deletingNewSpare(){
        sparesPage.deletingAllSparesWithName(nameOfNewSpare);
    }
}


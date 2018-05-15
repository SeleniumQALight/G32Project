package sidebarMenuTest;

import org.junit.Test;
import parentTest.ParentTest;

public class SidebarMenu extends ParentTest {
    /*Test Case 1
    Summary:    На странице «Учет запчастей» проверить активность полей боковой панели меню. */

    @Test
    public  void sidebarMenuTest (){
        loginPage.userLogin("Student","909090" );
        homePage.checkCurrentURL();
        homePage.clickOnmenueDictionary();
        homePage.clickOnSubmenueApparat();
        homePage.assertSubmenueAparatPresent();
        apparatPage.checkCurrentURL();
        homePage.clickOnSubmenueWorkers();
        homePage.clickOnSubmenueSpareType();
        homePage.clickOnSubmenueSpares();
        sparesPage.checkCurrentURL();
        homePage.clickOnSubmenueProviders();
        homePage.clickOnSubmenueDealType();
        homePage.clickOnMenueService();
        servicePage.checkCurrentURL();
        homePage.clickOnMenueInstallation();
        homePage.clickOnMenueDeal();
        homePage.clickOnMenueStatistic();
        homePage.clickOnMenueMainPage();

    }
}

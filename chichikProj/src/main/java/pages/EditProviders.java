package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProviders extends parentPage{


    @FindBy(id = "prov_cus_proCustName")
    private WebElement inputProCustName;

    @FindBy(id = "prov_cus_proCustAddress")
    private WebElement inputProCustAddr;

    @FindBy(id = "prov_cus_proCustPhone")
    private WebElement inputProCustPhone;

    @FindBy(name = "add")
    private WebElement createButton;

    @FindBy(name = "delete")
    private WebElement deleteButton;

    public EditProviders(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers/edit");


    }


    public void enterProCustName(String proCustName){
        actionsWithOurElements.enterTextIntoElement(inputProCustName, proCustName);

    }

    public void enterProCustAddress(String proCustAddress){
        actionsWithOurElements.enterTextIntoElement(inputProCustAddr, proCustAddress);
    }

    public void enterProCustPhone(String proCustPhone){
        actionsWithOurElements.enterTextIntoElement(inputProCustPhone, proCustPhone);
    }

    /*public void checkPrivatePerson(){
       actionsWithOurElements.setCheckBoxToNeededState();

    }*/


    public void clickCreateButton(){
        actionsWithOurElements.clickOnElement(createButton);
    }

    public void clickButtonDelete() {
        actionsWithOurElements.clickOnElement(deleteButton);
    }
}

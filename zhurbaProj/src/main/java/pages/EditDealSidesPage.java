package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditDealSidesPage extends ParentPage {
    @FindBy(id = "prov_cus_proCustName")
    private WebElement proCustName;
    @FindBy(id="prov_cus_proCustAddress")
    private WebElement proCustAddress;
    @FindBy(id="prov_cus_proCustPhone")
    private WebElement proCustPhone;
    @FindBy(xpath = "//*[@id='prov_cus_proCustIsFl']")
    private WebElement checkBoxPrPerson;
    @FindBy(name = "add")
    private WebElement buttonCreate;


    public EditDealSidesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers/edit");
    }

    public void enterProCustName(String proCustNameText) {
        actionsWithOurElements.enterTextInToElement(proCustName, proCustNameText);
    }

    public void enterProCustAddress(String proCustAddressText) {
        actionsWithOurElements.enterTextInToElement(proCustAddress, proCustAddressText);
    }

    public void enterProCustPhone(String proCustPhoneText) {
        actionsWithOurElements.enterTextInToElement(proCustPhone, proCustPhoneText);
    }

    public void setPrivatePersonCheckBox(String stateToSet){
        actionsWithOurElements.setCheckBoxToNeededState(checkBoxPrPerson, stateToSet);
    }

    public void clickButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }

}

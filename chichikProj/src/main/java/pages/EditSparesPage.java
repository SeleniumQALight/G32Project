package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparesPage extends parentPage {

    @FindBy(id = ".//*[@id='spares_spareType']")
    private WebElement typeOfSpareDD;

    @FindBy(name = "add")
    private WebElement createButton;

    @FindBy(xpath = ".//*[@id='spares_spareName']")
    private WebElement enterSpareName;

    @FindBy(name = "delete")
    private WebElement clickDeleteButton;


    public EditSparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }

    public void enterSpareName(String spareName){
        actionsWithOurElements.enterTextIntoElement(enterSpareName, spareName);

    }

    public void selectSpareType(String value) {
        actionsWithOurElements.selectValueInDD(typeOfSpareDD, value);

    }

    public void clickButtonCreate() {
        actionsWithOurElements.clickOnElement(createButton);
    }

    public void clickButtonDelete() {
        actionsWithOurElements.clickOnElement(clickDeleteButton);
    }
}

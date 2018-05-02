package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparesPage extends ParentPage {
    @FindBy (tagName = "select" )
    private WebElement typeOfSpareDD;
    @FindBy (name = "delete")
    private WebElement buttonDelete;
    @FindBy (id = "spares_spareName")
    private  WebElement inputSpareName;
    @FindBy (xpath=".//*[@name=\"add\"]")
    private WebElement buttonCreate;

    public EditSparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }


    public void selectSpareType(String value) {
        actionsWithOurElements.selectValueInDD(typeOfSpareDD, value);
    }

    public void enterSpareName(String spareName) {
        actionsWithOurElements.enterTextIntoElement(inputSpareName, spareName);
    }

    public void clickButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }

    public void clickButtonDelete() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }
}

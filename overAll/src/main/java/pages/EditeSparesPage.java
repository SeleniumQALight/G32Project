package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditeSparesPage extends ParentPage{
    @FindBy(tagName = "select")
    private WebElement typeOfSpareDD;
    @FindBy(id = "spares_spareName")
    private WebElement inputSpareName;
    @FindBy(name = "add")
    private WebElement buttonCreate;
    @FindBy(name = "delete")
    private WebElement buttonDelete;

    public EditeSparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }

    public void selectSpareType(String value) {
        actionsWithOurElements.selectValueInDD(typeOfSpareDD, value);
    }

    public void enterSpareName(String spareName) {
        actionsWithOurElements.enterTextInToElement(inputSpareName, spareName);
    }

    public void clickButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }

    public void clickButtonDelete() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }
}

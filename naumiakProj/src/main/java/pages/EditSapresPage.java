package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSapresPage extends  ParentPage{

    @FindBy (tagName = "select")
    private WebElement typeOfSpareDD;

    @FindBy (id="spares_spareName")
    private WebElement nameOfSpare;

    @FindBy (name ="add")
    private WebElement buttonCreate;

    @FindBy (name = "delete")
    private WebElement buttonDelete;

    public EditSapresPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }

    public void selectSpareType(String value) {
        actionsWithOurElements.selectValueInDD(typeOfSpareDD, value);
    }

    public void enterSpareName(String spareName) {
        actionsWithOurElements.enterTextIntoElement(nameOfSpare, spareName);
    }

    public void clickButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }

    public void clickButtonDelete() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }
}

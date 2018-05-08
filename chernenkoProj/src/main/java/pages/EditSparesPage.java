package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparesPage extends ParentPage {
    @FindBy(tagName = "select")
    private WebElement typeOfSpareDD;

    @FindBy(id = "spares_spareName")
    private WebElement nameOfSpareDD;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement buttonCreate;

    @FindBy(xpath = ".//button[@type='submit'][contains(text(),'Удалить')]")
    private WebElement buttonDelete;

    public EditSparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }

    public void selectSpareType(String value) {
        actionWithOurElements.selectValueInDD(typeOfSpareDD, value);
    }

    public void enterSpareName(String name) {
        actionWithOurElements.enterTextIntoElement(nameOfSpareDD, name);
    }

    public void clickButtonCreate() {
        actionWithOurElements.clickOnElement(buttonCreate);
    }

    public void clickButtonDelete() {
        actionWithOurElements.clickOnElement(buttonDelete);
    }
}

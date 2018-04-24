package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparesPage extends ParentPage {
    @FindBy (tagName = "select")
    private WebElement typeOfSpareDD;
    @FindBy (xpath = ".//input[@id='spares_spareName']")
    private WebElement spareName;
    @FindBy (xpath = ".//button[@name='add']")
    private WebElement buttonCreate;

    public EditSparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }
    public void selectSpareType (String value){
        actionsWithOurElements.selectValueInDD (typeOfSpareDD, value);
    }

    public void enterSpareName(String text) {
        actionsWithOurElements.enterTextIntoElement(spareName, text);
    }

    public void clickButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }
}

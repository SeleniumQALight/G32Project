package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparesPage extends parentPage {
    @FindBy(xpath = ".//*[@id='spares_spareName']")
    private WebElement spareName;

    @FindBy(id = ".//*[@id='spares_spareType']")
    private WebElement typeOfSpareDD;


    @FindBy(name = "add")
    private WebElement createButton;

    public EditSparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }

    public void enterSpareName(String spare){
        actionsWithOurElements.enterTextIntoElement(spareName, spare);

    }

    public void selectSpareType(String value) {
        actionsWithOurElements.selectValueInDD(typeOfSpareDD, value);

    }

    public void clickButtonCreate() {
        actionsWithOurElements.clickOnElement(createButton);
    }
}

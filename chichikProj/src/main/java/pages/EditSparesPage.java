package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparesPage extends parentPage {
    @FindBy(id = ".//*[@id='spares_spareType']")
    private WebElement typeOfSpareDD;

    public EditSparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }

    public void enterSpareName(String spareName){

    }

    public void selectSpareType(String value) {
        actionsWithOurElements.selectValueInDD(typeOfSpareDD, value);

    }
}

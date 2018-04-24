package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparesPage extends ParentPage {
    @FindBy (id = "spares_spareName")
    protected WebElement spareName;

    @FindBy (id = "spares_spareType")
    protected WebElement typeOfSpareDD;

    @FindBy (name = "add")
    protected  WebElement addButton;

    public EditSparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }

    public void enterSpareName(String spare){
        actionWithOurElements.enterTextInToElement(spareName,spare);
    }



    public void selectSpareType(String value) {
        actionWithOurElements.selectValueInDD (typeOfSpareDD,value);
    }

    public void clickButtonCreate(){
        actionWithOurElements.clickOnElement(addButton);
    }

}

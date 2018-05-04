package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.naming.Name;
import java.rmi.Naming;

public class EditSparesPage extends ParentPage {
    @FindBy(tagName="select")
    private WebElement typeOfSpareDD;
    @FindBy(name=".//*@name='add'")
    private WebElement clickOnButtonCreate;
    @FindBy(id="spares_spareName")
    private WebElement inputSpareName;
    @FindBy(name="add")
    private WebElement buttonCreate;
    @FindBy(name="delete")
    private WebElement buttonDelete;



    public EditSparesPage(WebDriver webDriver){
        super(webDriver, "/dictionary/spares/edit");
    }

    public void selectSpareType(String value) {
              actionsWithOurElements.selectValueInDD(typeOfSpareDD, value);

    }

    public void clickButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }

    public void enterSpareName(String spareName) {
        actionsWithOurElements.enterTextInToElement(inputSpareName,spareName);
    }

    public void clickButtonDelete() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }
}

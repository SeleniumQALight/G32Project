package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditeSparesPage extends ParentPage{
        @FindBy(tagName = "select")
        private WebElement typeOfSpareDD;

        @FindBy(xpath = ".//*[@class='btn btn-info']")
        private WebElement createOfSpare;

        @FindBy(xpath = ".//input[@id='spares_spareName']")
        private WebElement enterName;

    public EditeSparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }

    public void selectSpareType(String value) {
        actionWithOurElements.selectValueInDD(typeOfSpareDD, value);
    }

    public void clickButtonCreate() {
        actionWithOurElements.clickOnElement(createOfSpare);
    }

    public void enterSpareName(String value) {
        actionWithOurElements.enterTextInToElement(enterName, value);
    }
}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparesPage extends ParentPage {
    @FindBy(xpath = ".//*[@data-original-title='Add']")
    private WebElement buttonPlus;
    private EditSparesPage editSparePage;


    public SparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
        editSparePage=new EditSparesPage(webDriver);
    }

    public void clickOnButonPlus() {
        actionsWithOurElements.clickOnElement(buttonPlus);
    }

    public boolean isNewSpareAdded(String nameOfNewSpare) {
        return actionsWithOurElements.isElementPresent(".//*[text()='" + nameOfNewSpare + "']");
    }

    public boolean isSpareInList(String nameOfNewSpare) {
        return actionsWithOurElements.isElementInList(".//*[text()='" + nameOfNewSpare + "']");
    }

    public void clickOnSpare(String nameOfNewSpare) {
        actionsWithOurElements.clickOnElement(".//*[text()='" + nameOfNewSpare + "']");


    }

    public void deletingAllSparesWithName(String nameOfNewSpare) {
        while (isSpareInList(nameOfNewSpare)) {
            clickOnSpare(nameOfNewSpare);
            editSparePage.clickButtonDelete();
            logger.info("Spare with name" + nameOfNewSpare + "was deleted");

        }
    }
}

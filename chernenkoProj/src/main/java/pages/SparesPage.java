package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparesPage extends ParentPage {
    @FindBy(xpath = ".//*[@data-original-title='Add']")
    private WebElement buttonPlus;

    @FindBy(xpath = ".//*[text()='machine']")
    private WebElement nameOfNewSpareElementText;

    public SparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
    }

    public void clickOnButtonPlus(){
        actionWithOurElements.clickOnElement(buttonPlus);
    }

    public boolean isNewSpareAdded(String nameOfNewSpare) {
        return actionWithOurElements.isElementPresent(".//*[text()='" + nameOfNewSpare + "']" );
    }

    public boolean isSpareInList(String nameOfNewSpare) {
        return actionWithOurElements.isElementInList(".//*[text()='" + nameOfNewSpare + "']" );
    }

    public void clickOnSpare(String nameOfNewSpare) {
        actionWithOurElements.clickOnElement(nameOfNewSpareElementText);
    }

}

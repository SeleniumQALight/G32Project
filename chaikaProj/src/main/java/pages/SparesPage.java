package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparesPage extends ParentPage{
    @FindBy(xpath = ".//*[@data-original-title='Add']")
    private WebElement buttonPlus;

    public SparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
    }

    public  void clickOnButtonPlus(){
        actionWithOurElements.clickOnElement(buttonPlus);
    }

    public boolean isNewSpareAdded(String namaOfNewSpare) {
        return actionWithOurElements.isElementPresent(".//*[text()=' " + namaOfNewSpare + "']");
    }

    public boolean isSpareInList(String namaOfNewSpare) {
        return actionWithOurElements.isElementInList(".//*text(='" + namaOfNewSpare + "']");
    }

    public void clickOnSpare(String namaOfNewSpare) {
        actionWithOurElements.isElementPresent(".//*text(='" + namaOfNewSpare + "']");
    }
}

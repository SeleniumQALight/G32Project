package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProvidersPage extends ParentPage {
    @FindBy(xpath = ".//a[@class='btn btn-info btn-sm']")
    private WebElement buttonPlus;
    @FindBy(xpath = ".//*[text()='aaa']")
    private WebElement nameOfNewProviderElementText;

    private EditSparesPage editProvidersPage;

    public ProvidersPage(WebDriver webDriver) {
        super(webDriver,"/dictionary/providers");
        editProvidersPage = new EditSparesPage(webDriver);
    }

    public void clickOnButtonPlus(){
        actionWithOurElements.clickOnElement(buttonPlus);
    }

    public boolean isNewProviderAdded(String nameOfCustName) {
        return actionWithOurElements.isElementPresent(".//*[text()='" + nameOfCustName + "']");
    }

    public boolean isProviderInList(String nameOfCustName) {
        return actionWithOurElements.isElementInList(".//*[text()='" + nameOfCustName + "']");
    }

    public void clickOnProvider(String nameOfCustName) {
        actionWithOurElements.clickOnElement(nameOfNewProviderElementText);
    }

    public void deletingAllProvidersWithName(String nameOfCustName){
        while (isProviderInList(nameOfCustName)){
            clickOnProvider(nameOfCustName);
            editProvidersPage.clickButtonDelete();
            logger.info("Provider with name " + nameOfCustName + " was deleted");
        }
    }
}

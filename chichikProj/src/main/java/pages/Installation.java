package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Installation extends parentPage {
    private EditInstallation editInstallation;
    //private Installation installation;

    @FindBy(xpath = ".//*[@data-original-title='Add']")
    private WebElement addButton;

    public Installation(WebDriver webDriver) {
        super(webDriver, "/dictionary/installation");
        editInstallation = new EditInstallation(webDriver);
    }

    public void clickAddButton() {
        actionsWithOurElements.clickOnElement(addButton);
    }

    public void clickOnInstallation(String nameOfInstallation) {
        actionsWithOurElements.clickOnElement(".//*[text()='" + nameOfInstallation + "']");

    }

    public void deleteInstallationWithName(String nameOfInstallation) {
        while (isInstallationAdded(nameOfInstallation)) {
            clickOnInstallation(nameOfInstallation);
            editInstallation.clickButtonDelete();
            logger.info("Installation with name " + nameOfInstallation + " was deleted");

        }
    }

    private boolean isInstallationAdded(String nameOfInstallation) {
        return actionsWithOurElements.isElementPresent(".//*[text()='" + nameOfInstallation + "']");
    }
}

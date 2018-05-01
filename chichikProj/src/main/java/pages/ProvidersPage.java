package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProvidersPage extends parentPage {

    private EditProviders editProviders;

    @FindBy(xpath = ".//*[@data-original-title='Add']")
    private WebElement addButton;
    private ProvidersPage providersPage;


    public ProvidersPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers");
        providersPage = new ProvidersPage(webDriver);

    }

    public void clickAddButton() {
        actionsWithOurElements.clickOnElement(addButton);
    }

    public boolean isProviderAdded(String nameOfProvider) {
        return actionsWithOurElements.isElementPresent(".//*[text()='" + nameOfProvider + "']");
    }

    public void clickOnProvider(String nameOfProvider) {
        actionsWithOurElements.clickOnElement(".//*[text()='" + nameOfProvider + "']");
    }


    public void deleteProviderWithName(String nameOfProvider){
            while (isProviderAdded(nameOfProvider)) {
                clickOnProvider(nameOfProvider);
                editProviders.clickButtonDelete();
                logger.info("Spare with name " + nameOfProvider + " was deleted");

            }
        }


    }


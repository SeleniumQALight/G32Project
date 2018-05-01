package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProvidersPage extends parentPage {

    @FindBy(xpath = ".//*[@data-original-title='Add']")
    private WebElement addButton;
    private ProvidersPage providersPage;


    public ProvidersPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers");
        providersPage = new ProvidersPage(webDriver);

    }

    public void clickAddButton(){
        actionsWithOurElements.clickOnElement(addButton);
    }

    public boolean isProviderAdded(String nameOfProvider){
        return actionsWithOurElements.isElementPresent(".//*[text()='" + nameOfProvider + "']");

    }


}

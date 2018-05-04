package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditInstallation extends parentPage {

    @FindBy(name = "delete")
    private String deleteButton;

    @FindBy(name = "add")
    private WebElement addButton;

    @FindBy(xpath = ".//*[@id='installation_installationDate_date_day']")
    private WebElement selectDay;

    @FindBy(xpath = ".//*[@id='installation_installationDate_date_month']")
    private WebElement month;

    @FindBy(xpath = ".//*[@id='installation_installationDate_date_year']")
    private WebElement year;

    @FindBy(xpath = ".//*[@id='installation_apparat']")
    private WebElement apparat;

    @FindBy(xpath = ".//*[@id='installation_worker']")
    private WebElement worker;

    @FindBy(name = "add")
    private WebElement submitButton;


    public EditInstallation(WebDriver webDriver) {
        super(webDriver, "/dictionary/installation/edit");
    }

    public void clickButtonDelete() {
        actionsWithOurElements.clickOnElement(deleteButton);
    }

    public void clickAddButton() {
        actionsWithOurElements.clickOnElement(addButton);
    }

    public void selectDayFromDD(String value) {
        actionsWithOurElements.selectValueInDD(selectDay, value);
    }

    public void selectMonthFromDD(String value){
        actionsWithOurElements.selectValueInDD(month, value);
    }

    public void selectYearFromDD(String value) {
        actionsWithOurElements.selectValueInDD(year, value);
    }

    public void selectApparatFromDD(String value) {
        actionsWithOurElements.selectValueInDD(apparat, value);
    }

    public void selectWorkerFromDD(String value) {
        actionsWithOurElements.selectValueInDD(worker, value);
    }

    public void clickSubmitButton() {
        actionsWithOurElements.clickOnElement(submitButton);

    }
}

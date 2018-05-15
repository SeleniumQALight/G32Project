package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditApparatPage extends ParentPage {
    @FindBy(xpath = ".//input[@id='apparat_apparatNumber']")
    private WebElement apparatNumber;
    @FindBy(xpath = ".//input[@id='apparat_apparatComment']")
    private WebElement apparatComment;
    @FindBy(xpath = ".//*[@name='add']")
    private WebElement buttonCreate;
    @FindBy(xpath = ".//tr[21]")
    private WebElement anyApparatInList;
    @FindBy(xpath = ".//button[@name='delete']")
    private WebElement buttonDelete;


    public EditApparatPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/apparat/edit");
    }

    public void enterApparatNumber(String text) {
        actionsWithOurElements.enterTextIntoElement(apparatNumber, text);
    }

    public void enterApparatComment(String text) {
        actionsWithOurElements.enterTextIntoElement(apparatComment, text);
    }

    public void clickOnButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }

    public void clickOnAnyApparatInList() {
        actionsWithOurElements.clickOnElement(anyApparatInList);
    }

    public void clickOnButtonDelete() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }

}

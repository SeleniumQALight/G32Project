package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class EditAnyApparatPage extends ParentPage {
    @FindBy (xpath = ".//button[@type='submit' and @name='save']")
    private WebElement buttonSave;

    public EditAnyApparatPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/apparat/edit/1");
    }
    public void clickOnButtonSave() {
        actionsWithOurElements.clickOnElement(buttonSave);
    }

    }


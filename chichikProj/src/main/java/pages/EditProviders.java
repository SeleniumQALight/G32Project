package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class EditProviders extends parentPage{
    public EditProviders(WebDriver webDriver, String expectedUrl) {
        super(webDriver, expectedUrl);
    }

    public void checkCheckBox(){
        actionsWithOurElements.checkCheckBox();

    }
}

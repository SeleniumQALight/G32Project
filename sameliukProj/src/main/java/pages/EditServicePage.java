package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditServicePage extends ParentPage {
    @FindBy (xpath = ".//select[@id='service_apparat_apparat']" )
    private WebElement fieldApparat;


    public EditServicePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/service/edit");
    }
    public void clickOnFieldApparat () {
        actionsWithOurElements.clickOnElement(fieldApparat);
    }

    public void assertApparatPresent (String nameOfApparat){
        Assert.assertTrue(actionsWithOurElements.isElementPresent(".//*[text()='" + nameOfApparat + "']"));
    }

}

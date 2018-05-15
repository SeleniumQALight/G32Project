package pages;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ApparatPage extends ParentPage {
    @FindBy (xpath = ".//*[@class='fa fa-plus']")
    private WebElement buttonPlus;


    public ApparatPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/apparat");
    }
    public void clickOnButtonPlus (){
        actionsWithOurElements.clickOnElement(buttonPlus);
    }
    public boolean isNewApparatAdded (String nameOfApparat){
       return actionsWithOurElements.isElementPresent(".//*[text()='" + nameOfApparat + "']");
       // По моєму треба зробити по прикладу як тут, тому-що ґ
        // там ти передаєш просто строчку але локатор пишеться в певній формі
        // треба в формі як тут
    }
}

package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {
    @FindBy (xpath = ".//div[@class='pull-left image']//img[@class='img-circle']")
    private WebElement avatar;
    @FindBy (xpath = ".//*[@id='dictionary']/a")
    private WebElement menuDictionary;
    @FindBy (id = "apparat")
    private WebElement apparat;
    @FindBy (id = "spares")
    private WebElement spares;

    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }



    public boolean isElementPresent() {
        return actionWithOurElements.isElementPresent(avatar);

    }

    public void checkIsAvatarPresent() {
        Assert.assertTrue("Avatar is not Present",isElementPresent());

    }
    public void clickMenuDictionary() {
        actionWithOurElements.clickOnElement(menuDictionary);

    }
    public void clickOnSubMenuSpare(){
        actionWithOurElements.clickOnElement(spares);
    }

    public boolean isApparatPresent() {
        return actionWithOurElements.isElementPresent(spares);
    }
}

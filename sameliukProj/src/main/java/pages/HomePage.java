package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {
    @FindBy (xpath = ".//div[@class='pull-left image']//img[@class='img-circle']")
    private WebElement avatar;
    @FindBy (xpath = ".//*[@id='dictionary']/a")
    private  WebElement menueDictionary;
    @FindBy (id = "spares")
    private WebElement subMenueSpares;

    public HomePage(WebDriver webDriver) {
        super(webDriver,"/");
    }
    public boolean isAvatarPresent (){
        return actionsWithOurElements.isElementPresent(avatar);
    }

    public void checkAvatarIsPresent() {
        Assert.assertTrue("Avatar is not present", isAvatarPresent());
    }
    public void clickOnmenueDictionary (){
        actionsWithOurElements.clickOnElement(menueDictionary);
    }

    public void clickOnSubmenueSpares (){
        actionsWithOurElements.clickOnElement(subMenueSpares);
    }
}

package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends parentPage{
    @FindBy(xpath = ".//div[@class='pull-left image']//img[@class='img-circle']")
    private WebElement avatar;

    @FindBy(xpath = ".//*[@id='dictionary']/a")
    private WebElement menuDictionary;

    @FindBy(id = "spares")
    private WebElement subMenuSpare;


    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }

    public boolean isAvatarPresent(){
        return actionsWithOurElements.isElementPresent(avatar);
    }

    public void checkAvatarIsPresent() {
        Assert.assertTrue("Avatar is not present", isAvatarPresent());
    }

    public void clickOnMenuDictionary(){
        actionsWithOurElements.clickOnElement(menuDictionary);

    }

    public void clickOnSubMenuSpare(){
       actionsWithOurElements.clickOnElement(subMenuSpare);
    }
}

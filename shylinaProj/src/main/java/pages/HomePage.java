package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage{
   @FindBy(xpath = ".//div[@class='pull-left image']//img[@class='img-circle']")
   private WebElement avatar;

   @FindBy(xpath = ".//*[@d='dictionary']/a")
   private WebElement menuDictionary;

   @FindBy(id ="spares")
   private WebElement subMenuSpares;


    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }

    public boolean isAvatarPresent(){
        return actionsWithOurElements.isElementPresent(avatar);
    }

    public void checkAvatarIsPresent() {
        Assert.assertTrue("Avatar is not Present", isAvatarPresent());
    }

    public void clickOnMenuDictionary(){
        actionsWithOurElements.clickOnElement(menuDictionary);

    }
     public void clickOnSubMenuSpare(){
        actionsWithOurElements.clickOnElement(subMenuSpares);
     }

}

package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {
    @FindBy(xpath=".//div[@class='pull-left image']//img[@class='img-circle']")
    private WebElement avatar;
    @FindBy (xpath=".//*[@id='dictionary']/a")
    private WebElement menuDictionary;
    @FindBy (id = "spares")
    private WebElement subMenuSpares;
    public HomePage(WebDriver webDriver) {
        super(webDriver,"/");
    }
    @Step
    public void clickElementDictionary() {
        actionsWithOurElements.clickOnElement(menuDictionary);
    }
    @Step
    public void clickOnSubMenuSpares(){
        actionsWithOurElements.clickOnElement(subMenuSpares);
    }
    @Step
    public boolean isAvatarPresent(){
      return actionsWithOurElements.isElementPresent(avatar);

    }
    @Step
    public void checkAvatarIsPresent() {
        Assert.assertTrue("Avatar is not present", isAvatarPresent());
    }

    }

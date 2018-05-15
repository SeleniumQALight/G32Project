package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {
    @FindBy(xpath = ".//div[@class='pull-left image']//img[@class='img-circle']")
    private WebElement avatar;
    @FindBy(xpath = ".//*[@id='dictionary']/a")
    private WebElement menueDictionary;
    @FindBy(id = "spares")
    private WebElement subMenueSpares;
    @FindBy(xpath = ".//a[@href='/dictionary/apparat'] ")
    private WebElement subMenueApparat;
    @FindBy(xpath = ".//a[@href='/dictionary/workers'] ")
    private WebElement subMenueWorkers;
    @FindBy(xpath = ".//a[@href='/dictionary/spare_type'] ")
    private WebElement subMenueSpareType;
    @FindBy(xpath = ".//a[@href='/dictionary/providers'] ")
    private WebElement subMenueProviders;
    @FindBy(xpath = ".//a[@href='/dictionary/deal_type'] ")
    private WebElement subMenueDealType;
    @FindBy(xpath = ".//a[@href='/dictionary/service'] ")
    private WebElement menueService;
    @FindBy(xpath = ".//a[@href='/dictionary/installation'] ")
    private WebElement menueInstallation;
    @FindBy(xpath = ".//a[@href='/deal'] ")
    private WebElement menueDeal;
    @FindBy(xpath = ".//a[@href='/statistic'] ")
    private WebElement menueStatistic;
    @FindBy(xpath = ".//a[@href='/dashboard']")
    private WebElement menueMainPage;

    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }

    public boolean isAvatarPresent() {
        return actionsWithOurElements.isElementPresent(avatar);
    }

    public boolean isAparatPresent() {
        return actionsWithOurElements.isElementPresent(subMenueApparat);
    }

    public void assertSubmenueAparatPresent() {
        Assert.assertTrue(actionsWithOurElements.isElementPresent(subMenueApparat));
    }

    public void checkAvatarIsPresent() {
        Assert.assertTrue("Avatar is not present", isAvatarPresent());
    }

    public void clickOnmenueDictionary() {
        actionsWithOurElements.clickOnElement(menueDictionary);
    }

    public void clickOnSubmenueSpares() {
        actionsWithOurElements.clickOnElement(subMenueSpares);
    }

    public void clickOnSubmenueApparat() {
        actionsWithOurElements.clickOnElement(subMenueApparat);
    }

    public void clickOnSubmenueWorkers() {
        actionsWithOurElements.clickOnElement(subMenueWorkers);
    }

    public void clickOnSubmenueSpareType() {
        actionsWithOurElements.clickOnElement(subMenueSpareType);
    }

    public void clickOnSubmenueProviders() {
        actionsWithOurElements.clickOnElement(subMenueProviders);
    }
    public void clickOnSubmenueDealType() {
        actionsWithOurElements.clickOnElement(subMenueDealType);
    }
    public void clickOnMenueService() {
        actionsWithOurElements.clickOnElement(menueService);
    }
    public void clickOnMenueInstallation() {
        actionsWithOurElements.clickOnElement(menueInstallation);
    }
    public void clickOnMenueDeal() {
        actionsWithOurElements.clickOnElement(menueDeal);
    }
    public void clickOnMenueStatistic() {
        actionsWithOurElements.clickOnElement(menueStatistic);
    }
    public void clickOnMenueMainPage() {
        actionsWithOurElements.clickOnElement(menueMainPage);
    }
}

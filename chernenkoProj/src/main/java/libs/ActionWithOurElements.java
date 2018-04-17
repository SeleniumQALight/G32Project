package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionWithOurElements {
    WebDriver webDriver;
    Logger logger;

    public ActionWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }

    public void enterTextIntoElement(WebElement webElement, String text){
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted into text");

        }catch (Exception e){
            printErrorAndStopTest();
        }
    }

    public void click(WebElement webElement) {
        try {
            webElement.click();
            logger.info("Element was clicked");
        }catch (Exception e){
            printErrorAndStopTest();
        }
    }

    public void clickOnElement(WebElement webElement) {
        try{
            webElement.click();
            logger.info("Element was clicked");
        }catch (Exception e){
            printErrorAndStopTest();
        }
    }

    private void printErrorAndStopTest() {
        logger.error("can not with Element");
        Assert.fail("can not with Element");
    }

    public boolean isElementPresent(WebElement webElement) {
        try{
            return webElement.isDisplayed() && webElement.isEnabled();
        }catch (Exception e){
            return false;
        }
    }
}

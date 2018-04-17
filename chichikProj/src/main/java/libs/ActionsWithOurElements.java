package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }

    /**
     * Method enter text to any Element
     * @param webElement
     * @param text
     */
    public void enterTextIntoElement(WebElement webElement, String text){
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted into elements");

        }catch (Exception e){
            printErrorAndStopTest();
        }
    }


    /**
     * Method click by any Element
     * @param webElement
     */
    public void clickOnElement(WebElement webElement){
        try {
            webElement.click();
            logger.info("element was clicked");
        }catch (Exception e){
            printErrorAndStopTest();

        }
    }

    /**
     * Method for error exceptions
     */
    private void printErrorAndStopTest() {
        logger.error("Cannot work with element");
        Assert.fail("Cannot work with element");
    }

    public boolean isElementPresent(WebElement webElement) {
        try {
            return webElement.isDisplayed() && webElement.isEnabled();

        }catch (Exception e){
            return false;
        }
    }
}

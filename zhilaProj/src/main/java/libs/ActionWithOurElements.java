package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ActionWithOurElements {
    public static final String STATE_CHECKED = "check";
    public static final String STATE_UNCHECKED = "uncheck";
    WebDriver webDriver;
    Logger logger;

    public ActionWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }

    public void enterTextInToElement(WebElement webElement, String text) {
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " Was inputted into Element");
        } catch (Exception e) {
            printErrorAndStopTest();
        }
    }

    public void clickOnElement(WebElement webElement) {
        try {
            webElement.click();
            logger.info( "Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest();
        }
    }

    private void printErrorAndStopTest() {
        logger.error("Can not find button ");
        Assert.fail("Can not find button ");
    }

    public boolean isElementPresent(WebElement webElement) {
        try {
            return webElement.isDisplayed() && webElement.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

/**
 *Method selects value in DD
 * @param webElement
 * @param value (Value !not Text DD )
 */

    public void selectValueInDD(WebElement webElement,String value){
        try{
            Select select = new Select(webElement);
            select.selectByValue(value);
            logger.info(value + " was swlected in DD");
        }catch(Exception e){
            printErrorAndStopTest();
        }
    }

    /**
     *Method set checkbox to needed state
     * @param webElement
     * @param neededState (only "check" or "uncheck")
     */
   public void setCheckBoxToNeededState(WebElement webElement, String neededState){
       boolean newState = parseState(neededState);
       if (webElement.isSelected() && !newState) {
           webElement.click();
         logger.info("Checkbox is unchecked");
       } else if (!webElement.isSelected() && newState) {
           webElement.click();
           logger.info("Checkbox is checked");
       } else {
           logger.info("Checkbox is " + neededState);
       }
   }

    private boolean parseState(String neededState) {
        if (STATE_CHECKED.equalsIgnoreCase(neededState)) {
            return true;
        } else if (STATE_UNCHECKED.equalsIgnoreCase(neededState)) {
            return false;
        } else {
            throw new IllegalArgumentException("Wrong state " + neededState);
        }
    }

}

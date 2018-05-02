package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ActionWithOurElements {
    public static final String STATE_CHECKED = "check";
    public static final String STATE_UNCHECKED = "uncheck";
    WebDriver webDriver;
    Logger logger;
    WebDriverWait webDriverWait15;

    public ActionWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        webDriverWait15 = new WebDriverWait(webDriver,15);
    }

    public void enterTextInToElement(WebElement webElement, String text) {
        try {
            webDriverWait15.until(ExpectedConditions.visibilityOf(webElement));
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " Was inputted into Element");
        } catch (Exception e) {
            printErrorAndStopTest();
        }
    }

    public void clickOnElement(WebElement webElement) {
        try {
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.sendKeys(Keys.ENTER);
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
           logger.info("Checkbox was " + neededState);
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

    public void setCheckBoxToNeedState(WebElement webElement, String neededState){
       boolean isCheckState = "check".equals(neededState);
       boolean isUncheckState = "uncheck".equals(neededState);
       try {
          if (isCheckState || isUncheckState) {
              if (webElement.isSelected() && isCheckState){
                  logger.info("Checkbox is checked already");
              } else if (webElement.isSelected() && isUncheckState){
                  clickOnElement(webElement);
              }else if (!webElement.isSelected() && isCheckState){
                  clickOnElement(webElement);
              }else if (!webElement.isSelected() && isUncheckState){
                  logger.info("Checkbox is unchecked already");
              }
          } else{
                  logger.error( neededState + " should be 'check' or 'uncheck' ");
                  Assert.fail( neededState + " should be 'check' or 'uncheck' ");
              }
       }catch (Exception e) {
           printErrorAndStopTest();
       }
    }

    public boolean isElementPresent(String locator) {
       try {
           WebElement webElement = webDriver.findElement(By.xpath(locator));
           return isElementPresent(webElement);
       }catch (Exception e){
          return false;
       }
    }


    public boolean isElementInList(String locator) {
       try{
           List<WebElement> listOfElements  = webDriver.findElements(By.xpath(locator));
           if (listOfElements.size()> 0 ){
               return true;
           }else {
               return false;
           }
       }catch (Exception e){
           return false;
       }
    }

    public void clickOnElement(String locator) {
        try {
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(By.xpath(locator))).click();
            logger.info( "Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest();
        }

    }
}

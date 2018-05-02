package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger;
    WebDriverWait webDriverWait15;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        webDriverWait15 = new WebDriverWait(webDriver,15);
    }

    public void enterTextIntoElement (WebElement webElement, String text){
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted into element");
        }catch (Exception e){
            printErrorAndStopTest();
        }
    }

    public void clickOnElement (WebElement webElement) {
        try {
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info("The element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest();
        }
    }

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
    /**
     * Method selects value in DD
     * @param webElement
     * @param value (Value ! not Text in DD)
     */

    public void selectValueInDD(WebElement webElement, String value) {
        try{
            Select select = new Select(webElement);
            select.selectByValue(value);
            logger.info(value + "was select in DD");
        }catch (Exception e){
            printErrorAndStopTest();
        }
    }

    public void setCheckBoxToNeededState(WebElement webElement, String neededState) {
        try {
            boolean ischeckState = "check".equals(neededState);
            boolean isUnCheckState = "uncheck".equals(neededState);
            if (ischeckState | isUnCheckState) {
                if (webElement.isSelected() && ischeckState) {
                    logger.info(webElement + "is already checked");
                } else if (webElement.isSelected() && isUnCheckState) {
                    clickOnElement(webElement);
                } else if (!webElement.isSelected() && ischeckState) {
                    clickOnElement(webElement);
                } else if (!webElement.isSelected() && isUnCheckState) {
                    logger.info(webElement + "is already unchecked");
                }
            } else {
                logger.error(neededState + " should be 'check' or 'check'");
                Assert.fail(neededState + " should be 'check' or 'check'");
            }
            }catch(Exception e){
                printErrorAndStopTest();
            }
        }
// Rozshyrennja metoda (prujmae krim webelement i string)
    public boolean isElementPresent(String locator) {
        try {
            WebElement webElement = webDriver.findElement(By.xpath(locator));
            return isElementPresent(webElement);
        }catch (Exception e){
            return false;
        }
    }

    public boolean isElementInList(String locator) {
        try {
            List<WebElement> listOfElements = webDriver.findElements(By.xpath(locator));
            if (listOfElements.size() > 0) {
                return true;
            }else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnElement(String locator) {
        try {
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
            WebElement locatorOfElement = webDriver.findElement(By.xpath(locator));
            locatorOfElement.click();
            logger.info("The element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest();
        }
    }
}
package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }

    public void enterTextIntoElement(WebElement webElement, String text) {
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputed into element");
        } catch (Exception e) {
            printErrorAndStopTest();
        }
    }

    public void clickOnElement(WebElement webElement) {
        try {
            webElement.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest();
        }
    }

    private void printErrorAndStopTest() {
        logger.error("Can't work with element");
        Assert.fail("Can't work with element");
    }

    public boolean isElementPresent(WebElement webElement) {
        try {
            return webElement.isDisplayed() && webElement.isEnabled();
        }catch (Exception e) {
            return false;
        }
    }

    /**
     * Method select value in drop down
     * @param webElement
     * @param value (VALUE ! NOT text in DD)
     */
    public void selectValueInDD(WebElement webElement, String value) {
        try {
            Select select = new Select(webElement);
            select.selectByValue(value);
            logger.info(value + " was select in DD");
        }catch (Exception e) {
            printErrorAndStopTest();
        }
    }

    public void setCheckBoxToNeededState(WebElement webElement, String neededState) {
        final String CHECK_STATUS = "Checked";
        final String UNCHECK_STATUS = "Unchecked";
        if (!neededState.equals(CHECK_STATUS) && !neededState.equals(UNCHECK_STATUS)){
            logger.error(neededState + " - Value of neededState is not expected ");
            Assert.fail(neededState + " - Value of neededState is not expected ");
        }else {
            try {
                if (neededState.equals(CHECK_STATUS) && !webElement.isSelected() ||
                        neededState.equals(UNCHECK_STATUS) && webElement.isSelected()){
                    clickOnElement(webElement);
                } else {
                    logger.info("CheckBox has " + neededState + " state already ");
                }
            }catch (Exception e){
                printErrorAndStopTest();
            }
        }
    }

    public boolean isElementPresent(String locator) {
        try{
            WebElement webElement = webDriver.findElement(By.xpath(locator));
            return isElementPresent(webElement);
        }catch (Exception e){
            return false;
        }
    }


    public boolean isElementInList(String locator) {
        try{
            List<WebElement> listOfElements = webDriver.findElements(By.xpath(locator));
            if (listOfElements.size() > 0){
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
            clickOnElement(webDriver.findElement(By.xpath(locator)));
        }catch (Exception e){
            printErrorAndStopTest();
        }
    }
}


package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
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
        webDriverWait15 = new WebDriverWait(webDriver, 15);
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
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(webElement));
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

    public void setCheckBoxToNeededState1(WebElement webElement, String neededState){
        try{
            boolean isCheckState = "check".equals(neededState);
            boolean isUnCheckState = "uncheck".equals(neededState);
            if (isCheckState || isUnCheckState){
                if (webElement.isSelected() && isCheckState){
                    logger.info("Check box is checked already");
                } else if (webElement.isSelected() && isUnCheckState){
                    clickOnElement(webElement);
                } else if (!webElement.isSelected() && isCheckState){
                    clickOnElement(webElement);
                } else if (!webElement.isSelected() && isUnCheckState){
                    logger.info("Check box is unchecked already");
                }

            } else {
                logger.error(neededState + " should be 'check' or 'uncheck'");
                Assert.fail(neededState + " should be 'check' or 'uncheck'");
            }

        }catch (Exception e){
            printErrorAndStopTest();
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


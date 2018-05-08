package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    public void enterTextInToElement(WebElement webElement, String text) {
        try {
            webDriverWait15.until(ExpectedConditions.visibilityOf(webElement));
            webElement.clear();
            webElement.sendKeys(text);
            logger.info("\"" + text + "\"" + " was inputted into element SUCCESSFULLY.");
        } catch (Exception e) {
            printErrorAndStopTest();
        }
    }

    public void clickOnElement(WebElement webElement) {
        try {
            webDriverWait15.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info("The element was clicked SUCCESSFULLY.");
        } catch (Exception e) {
            printErrorAndStopTest();
        }
    }

    private void printErrorAndStopTest() {
        logger.error("Can't work with element.");
        Assert.fail("Can't work with element.");
    }

    public boolean isElementPresent(WebElement webElement) {
        try {
            return webElement.isDisplayed() && webElement.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method selects value in DD
     *
     * @param webElement
     * @param value      (VALUE! not text in DD)
     */
    public void selectValueInDD(WebElement webElement, String value) {
        try {
            Select select = new Select(webElement);
            select.selectByValue(value);
            logger.info(value + " was select in DD");
        } catch (Exception e) {
            printErrorAndStopTest();
        }
    }

    private boolean isCheckedCheckbox(WebElement webElement) {
        try {
            return webElement.isSelected();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * NeededState can be only "check" or "uncheck"
     */
    public void setCheckBoxToNeededState(WebElement webElement, String neededState) {
        try {
            if (!isCheckedCheckbox(webElement) & new String(neededState).equals("check")) {
                webElement.click();
            } else if (isCheckedCheckbox(webElement) & new String(neededState).equals("uncheck")) {
                webElement.click();
            }
        } catch (Exception e) {
            printErrorAndStopTest();
        }
    }


    /**
     * NeededState can be only "check" or "uncheck"
     * Version from Taras.
     */
    public void setCheckBoxToNeededStateV2(WebElement webElement, String neededState) {
        try {
            boolean isCheckState = "check".equals(neededState);
            boolean isUncheckState = "uncheck".equals(neededState);
            if (isCheckState || isUncheckState) {
                if (webElement.isSelected() && isCheckState) {
                    logger.info("Check Box is checked already.");
                } else if (webElement.isSelected() && isUncheckState) {
                    clickOnElement(webElement);
                } else if (!webElement.isSelected() && isCheckState) {
                    clickOnElement(webElement);
                } else if (!webElement.isSelected() && isUncheckState) {
                    logger.info("Check Box is unchecked already.");
                }


            } else {
                logger.error(neededState + " should be 'check' or 'uncheck'.");
                Assert.fail(neededState + " should be 'check' or 'uncheck'.");                                          //exit from test
            }
        } catch (Exception e) {
            printErrorAndStopTest();
        }
    }

    public boolean isElementPresent(String locator) {

        try {
            WebElement webElement = webDriver.findElement(By.xpath(locator));
            return isElementPresent(webElement);
        } catch (Exception e) {
            return false;
        }
    }


    public boolean isElementInLast(String locator) {
        try {
            List<WebElement> listOfElements = webDriver.findElements(By.xpath(locator));
            if (listOfElements.size() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnElement(String locator) {
        try {
            clickOnElement(webDriver.findElement(By.xpath(locator)));
        } catch (Exception e) {
            printErrorAndStopTest();
        }
    }
}

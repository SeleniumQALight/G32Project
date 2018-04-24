package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ActionWithOurElements {
    WebDriver webDriver;
    Logger logger;

    public ActionWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }

    public void enterTextIntoElement(WebElement webElement, String text) {
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted into text");

        } catch (Exception e) {
            printErrorAndStopTest();
        }
    }

    public void click(WebElement webElement) {
        try {
            webElement.click();
            logger.info("Element was clicked");
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
        logger.error("can not with Element");
        Assert.fail("can not with Element");
    }

    public boolean isElementPresent(WebElement webElement) {
        try {
            return webElement.isDisplayed() && webElement.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method select value in DD
     *
     * @param webElement
     * @param value      (VALUE!! not Text in DD)
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

//    public void checkBox(WebElement webElement) {
//        try {
//            if (webElement.isSelected()) {
//                logger.info("Checkbox: Element is already selected");
//            } else {
//                webElement.click();
//                logger.info("Checkbox: Element was selected");
//            }
//            if (webElement.isSelected()){
//                webElement.click();
//                logger.info("Checkbox: Element was selected");
//            } else {
//                logger.info("Checkbox: Element is already selected");
//            }
//        } catch (Exception e) {
//            printErrorAndStopTest();
//        }
//    }
//
//    public void uncheckBox(WebElement webElement) {
//        try {
//            if (webElement.isSelected()) {
//                webElement.click();
//                logger.info("Checkbox: Element was selected");
//            } else {
//                logger.info("Checkbox: Element is already selected");
//            }
//        } catch (Exception e) {
//            printErrorAndStopTest();
//        }
    }




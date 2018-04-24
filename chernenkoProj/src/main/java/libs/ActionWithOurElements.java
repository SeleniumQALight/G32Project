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

//    public void setCheckBoxToNeededState(WebElement webElement, String neededState) {
//        try {
//            if (webElement.isSelected()) {
//                webElement.getAttribute(neededState);
//                logger.info(neededState + " Element is already selected");
//            } else {
//                webElement.click();
//                logger.info(neededState + " Element was selected");
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


    public void setCheckBoxToNeededState(WebElement webElement, String neededState) {
        try {
            boolean isCheckState = "check".equals(neededState);
            boolean isUnCheckState = "uncheck".equals(neededState);
            if (isCheckState || isUnCheckState) {
                if(webElement.isSelected() && isCheckState ){
                    logger.info("Checkbox is already checked");
                }else if (webElement.isSelected() && isUnCheckState){
                    clickOnElement(webElement);
                }else  if (!webElement.isSelected() && isCheckState){
                    clickOnElement(webElement);
                }else  if(!webElement.isSelected() && isUnCheckState){
                    logger.info("Checkbox is already unchecked");
                }
            } else {
                logger.error(neededState + " Should be 'check' or 'uncheck' ");
                Assert.fail(neededState + " Should be 'check' or 'uncheck' ");
            }
        } catch (Exception e) {
            printErrorAndStopTest();
        }
    }
}




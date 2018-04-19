package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
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

    public void enterTextInToElement(WebElement webElement, String text) {
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted into element");
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
        logger.error("Can not element");
        Assert.fail("Can not element");
    }

    public boolean isElementPresent(WebElement webElement) {
        try {
            return  webElement.isDisplayed() && webElement.isEnabled();
        }catch (Exception e){
            return false;
        }
    }

    /**
     * Method select value in DD
     * @param webElement
     * @param value (VALUE ! not Text in DD)
     */
    public void selectValueInDD(WebElement webElement, String value) {
        try {
            Select select = new Select(webElement);
            select.selectByValue(value);
            logger.info(value + " was select in DD");
        }catch (Exception e){
            printErrorAndStopTest();
        }
    }
}

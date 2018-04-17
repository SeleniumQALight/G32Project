package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
            logger.info("Button was clicked");
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
}

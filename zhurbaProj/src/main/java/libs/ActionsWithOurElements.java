package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }

    public void enterTextInToElement(WebElement webElement, String text) {
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info("\"" + text + "\"" + " was inputted into element SUCCESSFULLY.");
        } catch (Exception e) {
            printErrorAndStopTest();
        }
    }

    public void clickOnElement(WebElement webElement) {
        try {
            webElement.click();
            logger.info("The button was clicked SUCCESSFULLY.");
        } catch (Exception e) {
            printErrorAndStopTest();
        }


    }

    private void printErrorAndStopTest() {
        logger.error("Can't work with element.");
        Assert.fail("Can't work with element.");
    }
}

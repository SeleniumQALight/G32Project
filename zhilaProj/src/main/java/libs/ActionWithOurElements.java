package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
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
            logger.info(text + " Was inputted into Element");
        } catch (Exception e) {
            logger.error(webElement + " Can not find element");
            Assert.fail(webElement + " Can not find element");
        }
    }

    public void clickToButton(WebElement button) {
        try {
            button.click();
            logger.info(button + " was clicked");
        } catch (Exception e) {
            logger.error("Can not find button " + button);
            Assert.fail("Can not find button " + button);
        }
    }
}

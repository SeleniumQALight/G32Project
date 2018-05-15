package pages;

import newLibs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {

    Logger logger = Logger.getLogger(getClass());
    ActionsWithOurElements actionsWithOurElements;
    WebDriver webDriver;
    String expectedURL;
    final String baseURL = "http://v3.test.itpmgroup.com";

    public ParentPage(WebDriver webDriver, String expectedURL) {
        this.webDriver = webDriver;
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        PageFactory.initElements(webDriver, this); //Нужно для элементов описанных @FindBy
        this.expectedURL = baseURL + expectedURL; // "http://v3.test.itpmgroup.com" + "/"
    }

    private String getCurrentURL() {
        return webDriver.getCurrentUrl();
    }

    public void checkCurrentURL() {
        try {
            Assert.assertEquals("Url is not expected", expectedURL, getCurrentURL());
            logger.info("URL was checked: " + expectedURL);
        } catch (Exception e) {
            logger.error("Cannot get URL");
            Assert.fail("Cannot get URL");

        }
    }
}

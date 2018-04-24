package pages;


import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {
    Logger logger = Logger.getLogger(getClass());
    ActionsWithOurElements actionsWithOurElements;
    WebDriver webDriver;
    String expectedUrl;
    final String baseUrl = "http://v3.test.itpmgroup.com";                                                             // 'final' it's as 'const'

    public ParentPage(WebDriver webDriver, String expectedUrl) {
        this.webDriver = webDriver;
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
        PageFactory.initElements(webDriver, this);                                                               // 'this' points that initialisation will be done in the Class where the current method is called
        this.expectedUrl = baseUrl + expectedUrl;
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public void checkCurrentUrl() {
        try {
            Assert.assertEquals("URL is not expected.", expectedUrl, getCurrentUrl());
        } catch (Exception e) {
            logger.error("Can not get URL");
            Assert.fail("Can not get URL");
        }    }
}

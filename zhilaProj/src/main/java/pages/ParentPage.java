package pages;

import libs.ActionWithOurElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {

    Logger logger = Logger.getLogger(getClass());
    ActionWithOurElements actionWithOurElements;
    WebDriver webDriver;
    String expectedUrl;
    final String baseUrl = "http://v3.test.itpmgroup.com";



    public ParentPage(WebDriver webDriver, String expectedUrl) {
        this.webDriver = webDriver;
        actionWithOurElements = new ActionWithOurElements(webDriver);
        PageFactory.initElements(webDriver,this);
        this.expectedUrl = baseUrl + expectedUrl;
    }

    public String getCurrenUrl() {
        return webDriver.getCurrentUrl();
    }

    public void checkCurrentUrl(){
        try{
            Assert.assertEquals("Url is not exprcted",expectedUrl,getCurrenUrl());
        }catch (Exception e){
            logger.error("Can't get Url");
            Assert.fail("Can't get Url");
        }
    }
}

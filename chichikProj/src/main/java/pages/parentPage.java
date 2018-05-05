package pages;


import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class parentPage {
   Logger logger = Logger.getLogger(getClass());
   ActionsWithOurElements actionsWithOurElements;
   WebDriver webDriver;
   String expectedUrl;
   final String baseUrl = "http://v3.test.itpmgroup.com";

   public parentPage(WebDriver webDriver, String expectedUrl) {
      this.webDriver = webDriver;
      actionsWithOurElements = new ActionsWithOurElements(webDriver);
      PageFactory.initElements(webDriver, this);  // this line starts init elements
      this.expectedUrl = baseUrl + expectedUrl;
   }


    public String getCurrentUrl(){
      return webDriver.getCurrentUrl();
   }

   /**
    * Compare URLs for check current page
    */
   public void checkCurrentUrl(){
      try {
         Assert.assertEquals("URL is not expected", expectedUrl, getCurrentUrl());
      }catch (Exception e){
         logger.error("Cannot get URL");
         Assert.fail("Cannot get URL");
      }
   }

}

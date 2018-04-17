package pages;


import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class parentPage {
   Logger logger = Logger.getLogger(getClass());
   ActionsWithOurElements actionsWithOurElements;
   WebDriver webDriver;

   public parentPage(WebDriver webDriver) {
      this.webDriver = webDriver;
      actionsWithOurElements = new ActionsWithOurElements(webDriver);
      PageFactory.initElements(webDriver, this);  // this line is starts init elements

   }
}

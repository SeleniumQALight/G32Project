package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {
     Logger logger = Logger.getLogger(getClass());
     ActionsWithOurElements actionsWithOurElements;
     WebDriver webDriver;

     public ParentPage(WebDriver webDriver) {
          this.webDriver = webDriver;
          actionsWithOurElements = new ActionsWithOurElements(webDriver);
          PageFactory.initElements(webDriver, this);
     }



}

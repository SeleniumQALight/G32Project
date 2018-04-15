package pages;

import newLibs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class ParentPage {

Logger logger = Logger.getLogger(getClass());
ActionsWithOurElements actionsWithOurElements;
WebDriver webDriver;

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        actionsWithOurElements = new ActionsWithOurElements(webDriver);

    }
}

package pages;

import libs.ActionWithOurElements;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class ParentPage  {
    Logger logger = Logger.getLogger(getClass());
    ActionWithOurElements actionWithOurElements;
    WebDriver webDriver;

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        actionWithOurElements = new ActionWithOurElements(webDriver);
    }
}

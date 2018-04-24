package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.EditSparesPage;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }

    /**
     * Method enter text to any Element
     * @param webElement
     * @param text
     */
    public void enterTextIntoElement(WebElement webElement, String text){
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted into elements");

        }catch (Exception e){
            printErrorAndStopTest();
        }
    }


    /**
     * Method click by any Element
     * @param webElement
     */
    public void clickOnElement(WebElement webElement){
        try {
            webElement.click();
            logger.info("element was clicked");
        }catch (Exception e){
            printErrorAndStopTest();

        }
    }

    /**
     * Method for error exceptions
     */
    private void printErrorAndStopTest() {
        logger.error("Cannot work with element");
        Assert.fail("Cannot work with element");
    }

    public boolean isElementPresent(WebElement webElement) {
        try {
            return webElement.isDisplayed() && webElement.isEnabled();

        }catch (Exception e){
            return false;
        }
    }

    /**
     * Method for selection value from drop down
     * @param webElement
     * @param value (VALUE ! NOT TEXT in DD)
     */
    public void selectValueInDD(WebElement webElement, String value) {
        try {
            Select select = new Select(webElement);
            select.selectByValue(value);
            logger.info(value + "was selected in DD");

        }catch (Exception e){
            printErrorAndStopTest();

        }
    }

    public void checkCheckBox() {
        WebElement checkedCheckBox = webDriver.findElement(By.xpath(""));
        WebElement uncheckedCheckBox = webDriver.findElement(By.xpath(""));

      if (uncheckedCheckBox.isSelected()){
          clickOnElement(uncheckedCheckBox);
      }
      if (checkedCheckBox.isSelected()){
          webDriver.quit();
      }
    }



}

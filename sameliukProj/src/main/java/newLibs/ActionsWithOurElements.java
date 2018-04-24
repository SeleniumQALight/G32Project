package newLibs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger;


    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
        WebElement checkbox;
    }

    public void enterTextIntoElement(WebElement webElement, String text) {
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted into element");

        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void clickOnElement(WebElement webElement) {
        try {
            webElement.click();
            logger.info("element was clicked");
        }catch (Exception e){
            printErrorAndStopTest(e);
        }
    }

    private void printErrorAndStopTest(Exception e) {
        e.printStackTrace();
        logger.error("Can not work with element");
        Assert.fail("Can not work with element");
    }

    public boolean isElementPresent(WebElement webElement) {
        try{
            return webElement.isDisplayed() && webElement.isEnabled();
        }catch (Exception e){
            return false;
        }

    }

    /**
     *  Method select value in DD
     * @param webElement
     * @param value
     */

    public void selectValueInDD(WebElement webElement, String value) {
        try {
            Select select = new Select(webElement);
            select.selectByValue(value);              // or select by visible text if needed
            logger.info(value + "was select in DD");
        }catch (Exception e){
            printErrorAndStopTest(e);
        }

            }


    /** NeededSatete can be only "check" or "uncheck"
     */
    public void setCheckBoxToNeededState(WebElement webElement, String neededState){
        Checkbox checkbox = new Checkbox(webElement);
        try{
            webDriver.get("http://v3.test.itpmgroup.com/dictionary/providers/edit/1");
           ( webDriver.findElement(By.xpath(".//input[@id='prov_cus_proCustIsFl']")).click());

          Assert.assertTrue("checkbox is check", checkbox.isEnabled();

        }catch (Exception e){
            printErrorAndStopTest(e);

        }
    }
}

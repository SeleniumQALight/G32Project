package checkboxTest;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.Augmenter;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class checkboxTest {


    public static final String STATE_CHECKED = "check";
    public static final String STATE_UNCHECKED = "uncheck";

    WebDriver webDriver;

    @Before
    public void setWebDriver(){
        File chrome = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chrome.getAbsolutePath());
        webDriver = new ChromeDriver();
    }

    @After
    public void afterClass(){
        webDriver.quit();
    }

    @Test
    public void testM(){
        String checkbox1;
        checkbox1 = ("//*[@id=\"taplc_trip_search_home_flights_0\"]/div[2]/div/div[2]/div/div[1]/div[2]/div/label");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        webDriver.get("https://www.tripadvisor.ru/CheapFlightsHome");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement checkbox = webDriver.findElement(By.xpath(checkbox1));
        setCheckBoxToNeededState(checkbox,"check");
        captureScreen();


    }

    @Test
    public void testB(){
        String checkbox1;
        checkbox1 = ("//*[@id=\"taplc_trip_search_home_flights_0\"]/div[2]/div/div[2]/div/div[1]/div[2]/div/label");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        webDriver.get("https://www.tripadvisor.ru/CheapFlightsHome");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement checkbox = webDriver.findElement(By.xpath(checkbox1));
        setCheckBoxToNeededState(checkbox,"uncheck");
        captureScreen();
    }


    public void setCheckBoxToNeededState(WebElement webElement, String neededState){
        boolean newState = parseState(neededState);
        if (webElement.isSelected() && !newState) {
            webElement.click();
            System.out.println("Checkbox is unchecked");
        } else if (!webElement.isSelected() && newState) {
            webElement.click();
            System.out.println("Checkbox is checked");
        } else {
            System.out.println("Checkbox is " + neededState);
        }
    }

    private boolean parseState(String neededState) {
        if (STATE_CHECKED.equalsIgnoreCase(neededState)) {
            return true;
        } else if (STATE_UNCHECKED.equalsIgnoreCase(neededState)) {
            return false;
        } else {
            throw new IllegalArgumentException("Wrong state " + neededState);
        }
    }

    public String captureScreen() {
        String path;
        try {
            WebDriver augmentedDriver = new Augmenter().augment(webDriver);
            File source = ((TakesScreenshot)augmentedDriver).getScreenshotAs(OutputType.FILE);
            path = "./target/screenshots/" + source.getName();
            FileUtils.copyFile(source, new File(path));
        }
        catch(IOException e) {
            path = "Failed to capture screenshot: " + e.getMessage();
        }
        return path;
    }

}

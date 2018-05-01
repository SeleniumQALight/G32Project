package pages;

import org.openqa.selenium.WebDriver;

public class ProvidersPage extends parentPage {


    public ProvidersPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers");
        ProvidersPage = new parentPage(webDriver);

    }


}

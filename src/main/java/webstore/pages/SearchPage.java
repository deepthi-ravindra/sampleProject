package webstore.pages;

import log.Log;
import net.serenitybdd.core.exceptions.SerenityManagedException;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.FindBy;
import webstore.components.CustomClass;

/**
 * Created by deepthi-ravindra on 01/07/2021
 **/
public class SearchPage extends CustomClass {

    @FindBy(className = "gLFyf")
    WebElementFacade searchField;
    public String openPage(String baseURL) {
        String currentURL = "";
        try {
            openAt(baseURL);
            waitABit(2000);
            currentURL = getDriver().getCurrentUrl();
        } catch (SerenityManagedException sme) {
            Log.error(sme.getMessage());
        } catch (WebDriverException wde) {
            Log.error(wde.getMessage());
        }
        return currentURL;
    }

    public void type(String searchTerm) {
        searchField.waitUntilVisible();
        typeInto(searchField, searchTerm);
    }
}

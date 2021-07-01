package webstore.components;

import net.serenitybdd.core.exceptions.SerenityManagedException;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

/**
 * Created by deepthi-ravindra on 01/07/2021
 **/
public class CustomClass extends PageObject {
    public CustomClass() {
        setDriver(getDriver());
    }

    @Override
    public void typeInto(WebElement field, String value) {
        try {
            super.typeInto(field, value);
            evaluateJavascript("$(arguments[0]).change();", field);
        } catch (WebDriverException wde) {
            if (wde.getMessage().contains("Session not started")) {
                wde.printStackTrace();
            }
        } catch (SerenityManagedException sme) {
            if (sme.getMessage().contains("Session not started")) {
                //retry
                super.typeInto(field, value);
                evaluateJavascript("$(arguments[0]).change();", field);
            }
        }
    }
}

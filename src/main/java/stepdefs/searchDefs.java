package stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import net.thucydides.core.annotations.Steps;
import stepdefs.steps.SearchSteps;

/**
 * Created by deepthi-ravindra on 01/07/2021
 **/
public class searchDefs {

    @Steps
    SearchSteps searchSteps;
    @Given("I visit the url {string}")
    public void iVisitTheUrl(String url) {
        searchSteps.openPage(url);
    }

    @And("I type {string}")
    public void iType(String searchTerm) {
        searchSteps.searchFor(searchTerm);
    }
}

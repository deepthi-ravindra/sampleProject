package stepdefs.steps;

import log.Log;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import webstore.pages.SearchPage;


/**
 * Created by deepthi-ravindra on 01/07/2021
 **/
public class SearchSteps {
    SearchPage searchPage;

    @Step
    public void openPage(String url) {
        String currentURL = searchPage.openPage(url);

        Assert.assertTrue("Current Url: " + currentURL, currentURL.contains(url));
        Log.info("Search page loaded");
    }

    public void searchFor(String searchTerm) {
        searchPage.type(searchTerm);
    }
}

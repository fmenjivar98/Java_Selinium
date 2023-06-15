package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.GooglePage;

public class GoogleSteps {

    GooglePage google = new GooglePage();

    @Given("^I am on the Google Search page$")
    public void navigateToGoogle(){
        google.navigateToGoogle();
    }

    @When("^I enter a search criteria$")
    public void searchGoogle(){
        google.writeGoogleSearch("Argentina");
    }

    @And("^click on the search button$")
    public void clickGoogle(){
        google.clickGoogleSearch();
    }

   @Then("^the results match the criteria$")
    public void matchGoogle(){
        System.out.println("Entro");
        Assert.assertEquals("Texto que experamos",google.firstResult());
    }



}

package steps;

import io.cucumber.java.en.*;
import pages.GridPage;
import pages.basepage.ListPage;

import java.util.List;

public class GridSteps {

    ListPage grid = new ListPage();

    @Given("^I navigate to the static table$")
    public void navigateToGridPage(){
        grid.navigateToListPage();
    }

   /* @Then("can return the value I wanted")
    public void returnValue(){
        String value = grid.getValueFromGrid(3,2);
        System.out.println(value);

    }*/

    @Then("can return the value I wanted")
    public void returnValue(){
        List<String> lista = grid.getAllSearchResults();
        boolean textIsThere = lista.contains("La Mantaza, Washington");

        if (textIsThere){
            System.out.println("The text is on the list: PASSED");
        }else{
            System.out.println("The text is on the list: FAILED");

        }

    }

}

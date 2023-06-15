package pages.basepage;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ListPage extends BasePage{

    public ListPage(){
        super(driver);
    }

    public void navigateToListPage(){
        navigateTo("htpps//andreidbr.github.io/JS30/06AjaxTypeAhead/index.html");
    }

    public void enterSearchCriteria()throws InterruptedException{
        Thread.sleep(600);
        write("","");
    }

   public List <String> getAllSearchResults(){
        List<WebElement> list = bringMeAllElements("");
        List <String> stringsFromList = new ArrayList<String>();
        for(WebElement e : list){
            stringsFromList.add(e.getText());
        }

        return  stringsFromList;
   }
}

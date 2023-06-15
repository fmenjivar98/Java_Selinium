package pages;

import pages.basepage.BasePage;

public class GooglePage extends BasePage {

    private String searchButton = "//input[@name='btnK']";
    private String searchTextField = "//textarea[@id='APjFqb']";
    private String firstResult = "";


    public GooglePage() {
        super(driver);
    }

    public void navigateToGoogle(){
        navigateTo("https://www.google.com");
    }

    public void clickGoogleSearch(){
        clickElement(searchButton);
    }

    public void writeGoogleSearch(String criteria){
        write(searchTextField,criteria);
    }

    public String firstResult(){
        return textFromElement(firstResult);
    }
}

package pages.basepage;

import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {

    protected static WebDriver driver;
    private static WebDriverWait wait;
    private static Actions action;

    static {
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public BasePage (WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public  static void navigateTo(String url){
        driver.get(url);
    }

    public static void closeBrowser(){
        driver.quit();
    }

    private WebElement findXpath(String locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
    }

    public  void write (String locator, String textToWrite){
        findXpath(locator).clear();
        findXpath(locator).sendKeys(textToWrite);
    }


    public void clickElement(String locator){
        findXpath(locator).click();
    }

    public void selectFromDropdownByValue(String locator, String valueToSelect){
        Select dropdown = new Select(findXpath(locator));
        dropdown.selectByValue(valueToSelect);
    }

    public void selectFromDropdownByIndex(String locator, int valueToSelect){
        Select dropdown = new Select(findXpath(locator));
        dropdown.selectByIndex(valueToSelect);
    }

    public void selectFromDropdownByText(String locator, String valueToSelect){
        Select dropdown = new Select(findXpath(locator));
        dropdown.selectByVisibleText(valueToSelect);
    }

    public void hoverOverElement(String locator){
        action.moveToElement(findXpath(locator));
    }

    public void doubleClick (String locator){
        action.doubleClick(findXpath(locator));
    }

    public void rightClick (String locator){
        action.contextClick(findXpath(locator));
    }

    public String getValueFromTable (String locator, int row, int column){
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String cellIneed = locator + "/table/tbody/tr["+row+"]/td["+column+"]";

        return findXpath(cellIneed).getText();

    }

    public void getValueOnTable (String locator, int row, int column, String stringToSend){
        String cellIneed = locator + "/table/tbody/tr["+row+"]/td["+column+"]";

        findXpath(cellIneed).sendKeys(stringToSend);

    }

    public void switchToiFrame (int iFrameID){
        driver.switchTo().frame(iFrameID);

    }

    public void switchToParentFrame(){
        driver.switchTo().parentFrame();
    }

    public void dismissAlert(){
        driver.switchTo().alert().dismiss();
    }

   public String textFromElement(String locator){
        return findXpath(locator).getText();
   }

   public boolean elementIsDisplayed(String locator){
        return findXpath(locator).isDisplayed();
   }

   public List<WebElement> bringMeAllElements (String locator){
        return driver.findElements(By.className(locator));
   }
}

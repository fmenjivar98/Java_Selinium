package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import pages.basepage.BasePage;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "steps",tags = "@Test")

public class runner{
   /* @AfterClass
    public static void clenDriver(){
        BasePage.closeBrowser();
    }
    */
}


package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.After;
import org.junit.runner.RunWith;
import pages.Base;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\anicolle\\eclipse-workspace\\store\\src\\test\\resources\\features\\login.feature",
        glue="stepDefinitions")
public class AccountRunner {

//    @After
//    public void tearDown() {
//        System.out.println("Close browser");
//        Base.quit();
//    }
}

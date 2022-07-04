package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\anicolle\\eclipse-workspace\\store\\src\\test\\resources\\features\\account.feature",
        glue="stepDefinitions")
public class AccountRunner {
}

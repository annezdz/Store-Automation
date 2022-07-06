package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.runner.RunWith;
import pages.Base;

import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\anicolle\\eclipse-workspace\\store\\src\\test\\resources\\features\\account.feature",
        glue="stepDefinitions")
public class HomeRunner extends BaseRunner{

}

package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features"
        , glue = {"classpath:com.kar.steps"}
        , tags = "@apiTest"
)

public class TestRunner {

}


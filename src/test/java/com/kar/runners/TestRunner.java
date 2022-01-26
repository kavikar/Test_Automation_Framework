package com.kar.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features"
        , glue = {"classpath:com.kar.steps"}
        , tags = "@apiTest"
        , plugin = {"pretty", "html:./reports/cucumber/cucumber-report.html",
                    "json:./reports/cucumber/cucumber.json",
                    "rerun:./reports/cucumber/rerun.txt",
                    }
        , monochrome = true
//        , publish = true
)

public class TestRunner {

}


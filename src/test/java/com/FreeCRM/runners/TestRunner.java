package com.FreeCRM.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumber-report.html",
                "json:target/cucumber.json",
                "rerun:target1/rerun.txt",
                "pretty"
        },

        features = "src/test/resources/features",
        glue = "com/FreeCRM/step_definitions",
        dryRun = false,
        monochrome = true,
        tags = ""
)


public class TestRunner {
}

// OR  : tags = {"@smoke  ,  @regression"}  -- executes all tests tagged as @smoke OR @regression
// AND : tags = {"@smoke" , "@regression"}  -- executes all tests tagged as @smoke AND @regression
// NOT : tags = {"~@smoke" , "~@regression"} -- will NOT execute any tests tagged this way

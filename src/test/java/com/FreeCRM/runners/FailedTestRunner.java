package com.FreeCRM.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target1/cucumber-report.html",
                "json:target1/cucumber.json",
                "rerun:target1/rerun.txt",
                "pretty"
        },

        features = "@target/rerun.txt",
        glue = "com/FreeCRM/step_definitions"
)
public class FailedTestRunner {
}

package com.oddo.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports",
                "rerun:target/rerun.txt"},

        strict = true,

        features = "src/test/resources/features",
        //this is the feature file path

        glue = "com.oddo.stepdefinitions",
        //this is the path of step definitions

        dryRun = false,
        //this is the create the methods of missing stories
        //in normal test run, switch it to false

        tags = "@hb"
        //this is to run certain scenarios tagged by the given tag.
        // and and or operator can be used to give multiple.
)
public class CukesRunner {

}

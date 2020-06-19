package com.oddo.stepdefinitions;

import com.oddo.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {


    @Before //these should be from cucumber, not from junit
    public void setup() {
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @After
    public void tearDown(Scenario scenario) {
        if(scenario.isFailed()){

            final byte[] screenshot  = ((TakesScreenshot)Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");


        }


        Driver.closeDriver();
    }

    @Before("@db")
    public void setupDb() {}

    @After("@db")
    public void closeDb() {}

    // we can supply special tags for before and after methods for certain cases
    // then when a scenario have that tag, both before and after methods are running.


}

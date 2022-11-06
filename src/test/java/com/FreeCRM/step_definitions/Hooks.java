package com.FreeCRM.step_definitions;

import com.FreeCRM.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void setUpScenario(){
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDownScenario(Scenario scenario) throws  Exception{
        //System.out.println("-----> After annotation: Closing browser");
        //System.out.println("scenario.getName() = " + scenario.getName());
        //System.out.println("scenario.getSourceTagNames() = " + scenario.getSourceTagNames());
        //System.out.println("scenario.isFailed() = " + scenario.isFailed());


        //#1 we need to take a screen shot using SELENIUM -->
        // getScreenshotAs: to be able to use this method we have to cast our driver type to TakesScreenshot

        //#2 we are going to attach it into our report: using attach method
        //attach method accepts 3 arguments. #1: Screenshot itself #2: image type #3 current scenario's name

        if (scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());

        }

        Driver.closeDriver();

    }
//
//    @After(value = "@db", order = 2 )
//    public void tearDownDatabaseConnection(){
//        System.out.println("--------> AFTER ANNOTATION: DB CONNECTION CLOSED <------");
//    }
//
//
//
//
//
//
//
//
//
//    @BeforeStep
//    public void setUpStep(){
//        System.out.println("===========> BEFORESTEP: TAKING SCREENSHOT <===========");
//    }
//
//    @AfterStep
//    public void tearDownStep(){
//        System.out.println("===========> AFTERSTEP: TAKING SCREENSHOT <===========");
//    }



}



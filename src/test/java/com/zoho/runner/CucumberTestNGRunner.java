package com.zoho.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.zoho.stepdefinations",
        plugin = {
                "pretty",
                "html:src/test/resources/reports/cucumber-report.html",
                "json:src/test/resources/reports/cucumber-report.json"

        },
        monochrome = true)

)
public class CucumberTestNGRunner extends AbstractTestNGCucumberTests {
    @Override @DataProvider(parallel = false)
    public Object[][] scenarios(){
        return super.scenarios();
    }

}

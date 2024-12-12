 package BDDBackTestNg.BDDBackTestNg;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(features="src/test/resources/feature/", glue= {"step"},tags="@tag2",dryRun=true,
monochrome=true,
plugin= {"pretty","html:target/cucumber-report1.html"})//plugin is to generated BDD report.
public class AppTest extends AbstractTestNGCucumberTests
{
 
}

package fr.canalplus.front.bdd.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/fr/canalplus/front/bdd/cucumber/features", glue = "fr.canalplus.front.bdd.steps")
public class ParallelIETest{

}

package org.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(tags = "@Address", dryRun = false, snippets = SnippetType.CAMELCASE, features = "src\\test\\resources\\Features", glue = "org.stepdefination")
public class TestRunnerClass {
	

}
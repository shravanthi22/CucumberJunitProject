package com.vcentry.lab.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
features="src/test/java/com/vcentry/lab/features",
glue= "com.vcentry.lab.stepDefinition",
plugin = {""
monochrome = true  //in console it will be clumpsy thats y we are using this



public class TestRunner {

}

package com.stepdefinition;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "D:\\Java\\Window7\\First\\ExcelSample\\src\\test\\resources\\FeatureFile", 
				glue = "com.stepdefinition", plugin = {"html:target"})
public class TestRunner 
{

}

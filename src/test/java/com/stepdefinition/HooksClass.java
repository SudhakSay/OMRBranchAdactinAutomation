package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.baseclass.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksClass extends BaseClass{
	
	@Before
	public void beforeScenario() throws FileNotFoundException, IOException {
		browserLaunch(getValueFromPropertyFile("browserType"));
		enterUrl(getValueFromPropertyFile("url"));
		
	}
	@After
	public void afterScenario() {
		closeAllWindow();
		
	}
}

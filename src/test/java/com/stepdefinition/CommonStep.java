package com.stepdefinition;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.pageobjectmanager.PageObjectManager;

import io.cucumber.java.en.Then;

public class CommonStep extends BaseClass{
	
	PageObjectManager pom = new PageObjectManager();
	
	@Then("User should verify Welcome Page after login {string}")
	public void userShouldVerifyWelcomePageAfterLogin(String expWelcomeMsg) {
		Assert.assertEquals("Verify Welcome Message after Login", expWelcomeMsg, getAttributeValue(pom.getLoginPage().getLoginVerifyMessage()));

	}
}

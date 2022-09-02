package com.stepdefinition;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.pageobjectmanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC1_LoginStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Given("User is on the adactin hotel login page")
	public void userIsOnTheAdactinHotelLoginPage() throws FileNotFoundException, IOException {

	}

	@When("User should perform login {string},{string}")
	public void userShouldPerformLogin(String UserName, String password) {
		pom.getLoginPage().login(UserName, password);

	}

	@When("User should perform login {string},{string} with enter key")
	public void userShouldPerformLoginWithEnterKey(String userName, String password) throws AWTException {
		pom.getLoginPage().loginByEnter(userName, password);
	}

	@Then("User should verify login error contains {string} after perform login with Invalid Credentials")
	public void userShouldVerifyLoginErrorContainsAfterPerformLoginWithInvalidCredentials(String expErrorMsg) {
		Assert.assertEquals("Verify Error After with Invalid Data", expErrorMsg,
				getElementText(pom.getLoginPage().getLoginErrorMsg()));
	}

}

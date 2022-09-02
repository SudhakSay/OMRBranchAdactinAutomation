package com.stepdefinition;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.pageobjectmanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC3_SelectHotelStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Then("User should perform Select Hotel Page by Select Hotel from Available options")
	public void userShouldPerformSelectHotelPageBySelectHotelFromAvailableOptions() {
		pom.getSelectHotelPage().selectAnyHotel();

	}

	@Then("User should Verify Booking Hotel Page Title {string} after Perform Select Hotel Page")
	public void userShouldVerifyBookingHotelPageTitleAfterPerformSelectHotelPage(String expTitleVerifyMsg) {
		Assert.assertEquals(getElementText(pom.getSelectHotelPage().getVerifyMsg()), expTitleVerifyMsg);
	}

	@Then("User should perform Select Hotel Page without Select Any Hotel")
	public void userShouldPerformSelectHotelPageWithoutSelectAnyHotel() {
		pom.getSelectHotelPage().withoutSelectAnyHotel();
	}

	@Then("User should Verify the error message {string} in Select Hotel page after perform Select Hotel without Select any Hotels")
	public void userShouldVerifyTheErrorMessageInSelectHotelPageAfterPerformSelectHotelWithoutSelectAnyHotels(
			String expErrorMsg) {
		Assert.assertEquals(getTextFromElement(pom.getSelectHotelPage().getSelectHotelErrorMsg()), expErrorMsg);
	}

}

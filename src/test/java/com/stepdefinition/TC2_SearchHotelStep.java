package com.stepdefinition;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.pageobjectmanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC2_SearchHotelStep extends BaseClass {

	PageObjectManager pom = new PageObjectManager();

	@Then("User Should Perform The Search Hotel  {string},{string},{string},{string},{string},{string},{string} and {string}")
	public void userShouldPerformTheSearchHotelAnd(String location, String hotels, String roomType, String noOfRooms,
			String checkInDate, String checkOutDate, String adultsPerRoom, String childPerRoom) {
		pom.getSearchHotelPage().searchAllFields(location, hotels, roomType, noOfRooms, checkInDate, checkOutDate,
				adultsPerRoom, childPerRoom);
	}

	@Then("User Should Verify the select hotel title {string} in select hotel page after perform Search Hotel")
	public void userShouldVerifyTheSelectHotelTitleInSelectHotelPageAfterPerformSearchHotel(
			String expSearchHotelSuccessMsg) {
		implicitWait(50);
		Assert.assertEquals("Verify Select Hotel Title Message after Search Hotel",
				expSearchHotelSuccessMsg,getTextFromElement(pom.getSearchHotelPage().getVerifyMsg()));

	}

	@Then("User Should Perform The Search Hotel with Mandatory Fields {string},{string},{string},{string} and {string}")
	public void userShouldPerformTheSearchHotelWithMandatoryFieldsAnd(String location, String noOfRooms,
			String checkInDate, String checkOutDate, String adultsPerRoom) {
		pom.getSearchHotelPage().searchMandatoryFields(location, noOfRooms, checkInDate, checkOutDate, adultsPerRoom);
	}

	@Then("User Should verify the date error message {string} and {string} in search hotel page after perform Search Hotel With Invalid Date")
	public void userShouldVerifyTheDateErrorMessageAndInSearchHotelPageAfterPerformSearchHotelWithInvalidDate(
			String expCheckInDateErrorMsg, String expCheckOutDateErrorMsg) {
		implicitWait(50);
		Assert.assertEquals("Verify CheckInDate Error Message after Search hotel", expCheckInDateErrorMsg,
				getTextFromElement(pom.getSearchHotelPage().getCheckInDateErrorMsg()));
		Assert.assertEquals("Verify CheckOutDate Error Message after Search hotel", expCheckOutDateErrorMsg,
				getTextFromElement(pom.getSearchHotelPage().getCheckOutDateErrorMsg()));
	}

	@Then("User Should search the hotel without enter values at any fields")
	public void userShouldSearchTheHotelWithoutEnterValuesAtAnyFields() {
		pom.getSearchHotelPage().searchWithoutAnyFelds();
	}

	@Then("User should verify location error message {string} in search hotel page after perform Search Hotel without Enter any Fields")
	public void userShouldVerifyLocationErrorMessageInSearchHotelPageAfterPerformSearchHotelWithoutEnterAnyFields(
			String expLocationErrorMsg) {
		Assert.assertEquals("Verify Location Error Message After Enter Without Any Fields", expLocationErrorMsg,
				getElementText(pom.getSearchHotelPage().getLocationErrorMsg()));
	}

}

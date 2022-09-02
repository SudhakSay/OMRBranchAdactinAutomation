package com.stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.pageobjectmanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC4_BookHotelStep extends BaseClass {
	PageObjectManager pom = new PageObjectManager();

	@Then("User should Enter All Fields {string},{string},{string}")
	public void userShouldEnterAllFields(String firstName, String lastName, String address,
			io.cucumber.datatable.DataTable dataTable) {
		List<Map<String, String>> maps = dataTable.asMaps();
		Map<String, String> cardDetails = maps.get(2);
		String cardNo = cardDetails.get("cardNo");
		String cardType = cardDetails.get("cardType");
		String expiryMonth = cardDetails.get("expiryMonth");
		String expiryYear = cardDetails.get("expiryYear");
		String ccvNo = cardDetails.get("ccvNo");
		pom.getBookHotelPage().bookWithAllFields(firstName, lastName, address, cardNo, cardType, expiryMonth,
				expiryYear, ccvNo);

	}

	@Then("User Verify Booking Conformation Title {string} in Booking Conformation Page after perform Book Hotel")
	public void userVerifyBookingConformationTitleInBookingConformationPageAfterPerformBookHotel(
			String expConformationMsg) {
		Assert.assertEquals("Verify Booking Conformation Message after Book Hotel", expConformationMsg,
				getTextFromElement(pom.getBookHotelPage().getVerifyConformationPageTitle()));
	}

	@Then("User should perform Book A Hotel page Without Enter Any Fields")
	public void userShouldPerformBookAHotelPageWithoutEnterAnyFields() {
		pom.getBookHotelPage().bookWithouFields();
	}

	@Then("User should Verify Error Message on Book A Hotel Page After perform Without Enter Any Fields {string}, {string}, {string}, {string}, {string}, {string} and {string}")
	public void userShouldVerifyErrorMessageOnBookAHotelPageAfterPerformWithoutEnterAnyFieldsAnd(
			String expFirstNameErrorMsg, String expLastNameErrorMsg, String expAddressErrorMsg, String expCardNumError,
			String expCardTypeErrorMsg, String expExpiryMonthErrorMsg, String expccvNumErrorMsg) {
		Assert.assertEquals(expFirstNameErrorMsg, getTextFromElement(pom.getBookHotelPage().getFirstnameError()));
		Assert.assertEquals(expLastNameErrorMsg, getTextFromElement(pom.getBookHotelPage().getLastnameError()));
		Assert.assertEquals(expAddressErrorMsg, getTextFromElement(pom.getBookHotelPage().getAddressError()));
		Assert.assertEquals(expCardNumError, getTextFromElement(pom.getBookHotelPage().getCcNumError()));
		Assert.assertEquals(expCardTypeErrorMsg, getTextFromElement(pom.getBookHotelPage().getCcTypeError()));
		Assert.assertEquals(expExpiryMonthErrorMsg, getTextFromElement(pom.getBookHotelPage().getCcExpiryError()));
		Assert.assertEquals(expccvNumErrorMsg, getTextFromElement(pom.getBookHotelPage().getCvvError()));
	}

}

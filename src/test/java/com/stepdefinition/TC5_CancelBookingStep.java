package com.stepdefinition;

import java.awt.AWTException;

import org.junit.Assert;

import com.baseclass.BaseClass;
import com.pageobjectmanager.PageObjectManager;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC5_CancelBookingStep extends BaseClass{
	PageObjectManager pom = new PageObjectManager();

	@Then("User should navigates to Booked Itinerary Page and perform Cancel Booking OrderId")
	public void userShouldNavigatesToBookedItineraryPageAndPerformCancelBookingOrderId() throws AWTException {
		pom.getBookingConformationPage().getOrderId();
		pom.getCancelBookingPage().cancelBookingId();
	}

	@Then("User should Verify Cancel Message after Cancel {string}")
	public void userShouldVerifyCancelMessageAfterCancel(String expCancelSuccessMsg) {
		Assert.assertEquals("Verify Cancel Success Message After Cancel Id",expCancelSuccessMsg, getTextFromElement(pom.getCancelBookingPage().getCaneclSuccessMsg()));
	}

	@Then("User should navigates to Booked Itinerary Page and Cancel Existing OrderId {string}")
	public void userShouldNavigatesToBookedItineraryPageAndCancelExistingOrderId(String orderId) throws AWTException {
		pom.getCancelBookingPage().cancelExistId(orderId);
	}

	@Then("User should Verify Booking Cancel Message {string}")
	public void userShouldVerifyBookingCancelMessage(String expCancelSuccessMsg) {
		Assert.assertEquals("Verify Cancel Success Message After Cancel Id",expCancelSuccessMsg, getTextFromElement(pom.getCancelBookingPage().getCaneclSuccessMsg()));
	}

}

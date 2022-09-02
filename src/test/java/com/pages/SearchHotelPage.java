package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class SearchHotelPage extends BaseClass {

	public SearchHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "location")
	private WebElement dnLocation;
	@FindBy(id = "hotels")
	private WebElement dDnHotels;
	@FindBy(id = "room_type")
	private WebElement dDnRoomType;
	@FindBy(id = "room_nos")
	private WebElement dDnNoOfRooms;
	@FindBy(id = "datepick_in")
	private WebElement txtCheckInDate;
	@FindBy(id = "datepick_out")
	private WebElement txtCheckOutDate;
	@FindBy(id = "adult_room")
	private WebElement dDnAdultPerRoom;
	@FindBy(id = "child_room")
	private WebElement dDnChildPerRoom;
	@FindBy(id = "Submit")
	private WebElement btnSubmit;
	@FindBy(id = "location_span")
	private WebElement locationErrorMsg;
	@FindBy(id = "checkin_span")
	private WebElement checkInDateErrorMsg;
	@FindBy(id = "checkout_span")
	private WebElement checkOutDateErrorMsg;
	@FindBy(xpath = "//td[text()='Select Hotel ']")
	private WebElement verifySelectPageTitle;

	public WebElement getdDnhotels() {
		return dDnHotels;
	}

	public WebElement getdDnroomType() {
		return dDnRoomType;
	}

	public WebElement getLocationErrorMsg() {
		return locationErrorMsg;
	}

	public WebElement getCheckInDateErrorMsg() {
		return checkInDateErrorMsg;
	}

	public WebElement getCheckOutDateErrorMsg() {
		return checkOutDateErrorMsg;
	}

	public WebElement getVerifyMsg() {
		return verifySelectPageTitle;
	}

	public WebElement getDnLocation() {
		return dnLocation;
	}

	public WebElement getdDnNoOfRooms() {
		return dDnNoOfRooms;
	}

	public WebElement getTxtCheckInDate() {
		return txtCheckInDate;
	}

	public WebElement getTxtCheckOutDate() {
		return txtCheckOutDate;
	}

	public WebElement getdDnAdultPerRoom() {
		return dDnAdultPerRoom;
	}

	public WebElement getdDnChildPerRoom() {
		return dDnChildPerRoom;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

	public void searchAllFields(String location, String hotels, String roomType, String noOfRooms, String checkInDate,
			String checkOutDate, String adultsPerRoom, String childPerRoom) {

		selectOptbyValue(getDnLocation(), location);
		selectOptbyValue(getdDnhotels(), hotels);
		selectOptbyValue(getdDnroomType(), roomType);
		selectOptbyValue(getdDnNoOfRooms(), noOfRooms);
		clearValue(getTxtCheckInDate());
		sendKeys(getTxtCheckInDate(), checkInDate);
		clearValue(getTxtCheckOutDate());
		sendKeys(getTxtCheckOutDate(), checkOutDate);
		selectOptbyValue(getdDnAdultPerRoom(), adultsPerRoom);
		selectOptbyValue(getdDnChildPerRoom(), childPerRoom);
		elementClick(getBtnSubmit());

	}

	public void searchMandatoryFields(String location, String noOfRooms, String CheckInDate, String checkOutDate,
			String adultsPerRoom) {
		selectOptbyValue(getDnLocation(), location);
		selectOptbyValue(getdDnNoOfRooms(), noOfRooms);
		clearValue(getTxtCheckInDate());
		sendKeys(getTxtCheckInDate(), CheckInDate);
		clearValue(getTxtCheckOutDate());
		sendKeys(getTxtCheckOutDate(), checkOutDate);
		selectOptbyValue(getdDnAdultPerRoom(), adultsPerRoom);
		elementClick(getBtnSubmit());

	}

	public void searchWithoutAnyFelds() {
		elementClick(getBtnSubmit());

	}

}

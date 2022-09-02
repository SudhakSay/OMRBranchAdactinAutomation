package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class BookingConformationPage extends BaseClass {

	public BookingConformationPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "order_no")
	private WebElement orderNo;
	@FindBy(xpath = "//a[text()='Booked Itinerary']")
	private WebElement bookedItinerary;
	@FindBy(id = "order_id_text")
	private WebElement searchOrderId;
	@FindBy(id = "search_hotel_id")
	private WebElement btnGo;
	@FindBy(id = "search_result_error")
	private WebElement caneclSuccessMsg;

	public WebElement getOrderNo() {
		return orderNo;
	}

	public WebElement getBookedItinerary() {
		return bookedItinerary;
	}

	public WebElement getSearchOrderId() {
		return searchOrderId;
	}

	public WebElement getBtnGo() {
		return btnGo;
	}

	public WebElement getCaneclSuccessMsg() {
		return caneclSuccessMsg;
	}

	public void getOrderId() {
		implicitWait(50);
		String orderId = getAttributeValue(getOrderNo());
		elementClick(getBookedItinerary());
		sendKeys(getSearchOrderId(), orderId);
		elementClick(getBtnGo());
		
	}
	
	

}

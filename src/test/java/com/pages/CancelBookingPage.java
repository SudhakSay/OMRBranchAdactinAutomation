package com.pages;

import java.awt.AWTException;
import java.awt.event.KeyEvent;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class CancelBookingPage extends BaseClass {

	public CancelBookingPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Booked Itinerary']")
	private WebElement bookedItinerary;
	@FindBy(id = "order_id_text")
	private WebElement searchOrderId;
	@FindBy(id = "search_hotel_id")
	private WebElement btnGo;
	@FindBy(id = "search_result_error")
	private WebElement caneclSuccessMsg;
	@FindBy(id = "check_all")
	private WebElement btnCheckAll;
	@FindBy(xpath = "(//input[@type='button'])[1]")
	private WebElement btnCancel;

	public WebElement getBtnCancel() {
		return btnCancel;
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

	public WebElement getBtnCheckAll() {
		return btnCheckAll;
	}

	public void cancelBookingId() throws AWTException {
		elementClick(getBtnCancel());
		handleAlertByAccept();
//		keypressaction(KeyEvent.VK_ENTER);
	}
	public void cancelExistId(String orderId) throws AWTException {
		elementClick(getBookedItinerary());
		sendKeys(getSearchOrderId(), orderId);
		elementClick(getBtnGo());
		elementClick(getBtnCancel());
		handleAlertByAccept();
//		keypressaction(KeyEvent.VK_ENTER);
	}
	
}

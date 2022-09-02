package com.pages;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

import io.cucumber.datatable.DataTable;

public class BookHotelPage extends BaseClass {

	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "first_name")
	private WebElement txtFirstName;
	@FindBy(id = "last_name")
	private WebElement txtLastName;
	@FindBy(id = "address")
	private WebElement txtaddress;
	@FindBy(id = "cc_num")
	private WebElement txtccNum;
	@FindBy(id = "cc_type")
	private WebElement txtccType;
	@FindBy(id = "cc_exp_month")
	private WebElement dDnExpMonth;
	@FindBy(id = "cc_exp_year")
	private WebElement dDnExpYear;
	@FindBy(id = "cc_cvv")
	private WebElement txtccvNum;
	@FindBy(id = "book_now")
	private WebElement btnBookNow;
	@FindBy(id = "first_name_span")
	private WebElement firstnameError;
	@FindBy(id = "last_name_span")
	private WebElement lastnameError;
	@FindBy(id = "address_span")
	private WebElement addressError;
	@FindBy(id = "cc_num_span")
	private WebElement ccNumError;
	@FindBy(id = "cc_type_span")
	private WebElement ccTypeError;
	@FindBy(id = "cc_expiry_span")
	private WebElement ccExpiryError;
	@FindBy(id = "cc_cvv_span")
	private WebElement cvvError;
	@FindBy(xpath = "//td[text()='Booking Confirmation ']")
	private WebElement verifyConformationPageTitle;

	public WebElement getFirstnameError() {
		return firstnameError;
	}

	public WebElement getLastnameError() {
		return lastnameError;
	}

	public WebElement getAddressError() {
		return addressError;
	}

	public WebElement getCcNumError() {
		return ccNumError;
	}

	public WebElement getCcTypeError() {
		return ccTypeError;
	}

	public WebElement getCcExpiryError() {
		return ccExpiryError;
	}

	public WebElement getCvvError() {
		return cvvError;
	}

	public WebElement getVerifyConformationPageTitle() {
		return verifyConformationPageTitle;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtaddress() {
		return txtaddress;
	}

	public WebElement getTxtccNum() {
		return txtccNum;
	}

	public WebElement getTxtccType() {
		return txtccType;
	}

	public WebElement getdDnExpMonth() {
		return dDnExpMonth;
	}

	public WebElement getdDnExpYear() {
		return dDnExpYear;
	}
	
	public WebElement getTxtccvNum() {
		return txtccvNum;
	}

	public WebElement getBtnBookNow() {
		return btnBookNow;
	}

	public void bookWithAllFields(String firstName, String lastName, String address, String cardNo, String cardType, String expiryMonth, String expiryYear, String ccvNo) {
		sendKeys(getTxtFirstName(), firstName);
		sendKeys(getTxtLastName(), lastName);
		sendKeys(getTxtaddress(), address);
		sendKeys(getTxtccNum(), cardNo);
		sendKeys(getTxtccType(), cardType);
		selectOptbyText(getdDnExpMonth(), expiryMonth);
		selectOptbyValue(getdDnExpYear(), expiryYear);
		sendKeys(getTxtccvNum(), ccvNo);
		elementClick(getBtnBookNow());
	}

	public void bookWithouFields() {
		elementClick(getBtnBookNow());

	}

}

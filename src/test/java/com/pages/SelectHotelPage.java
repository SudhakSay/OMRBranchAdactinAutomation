package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class SelectHotelPage extends BaseClass {
	public SelectHotelPage() {
PageFactory.initElements(driver, this);
	}
	@FindBy(id="radiobutton_0")
	private WebElement btnRadio;
	@FindBy(id="continue")
	private WebElement btnContinue;
	@FindBy(id="radiobutton_span")
	private WebElement selectHotelErrorMsg;
	@FindBy(xpath="//td[text()='Book A Hotel ']")
	private WebElement verifyBookPageTitle;
	
	
	public WebElement getSelectHotelErrorMsg() {
		return selectHotelErrorMsg;
	}
	public WebElement getVerifyMsg() {
		return verifyBookPageTitle;
	}
	public WebElement getBtnRadio() {
		return btnRadio;
	}
	public WebElement getBtnContinue() {
		return btnContinue;
	}
	
	
	
	public void selectAnyHotel() {
		elementClick(getBtnRadio());
		elementClick(getBtnContinue());
	}
	
	public void withoutSelectAnyHotel() {
		elementClick(getBtnContinue());
	}
	
}

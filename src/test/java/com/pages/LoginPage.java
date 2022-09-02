package com.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;
import com.github.dockerjava.api.model.Driver;

public class LoginPage extends BaseClass {

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	private WebElement txtUserName;
	@FindBy(id = "password")
	private WebElement txtPassword;
	@FindBy(id = "login")
	private WebElement btnLogin;
	@FindBy(id = "username_show")
	private WebElement loginVerifyMessage;
	@FindBy(xpath = "//div[@class='auth_error']")
	private WebElement loginErrorMsg;

	public WebElement getLoginErrorMsg() {
		return loginErrorMsg;
	}

	public WebElement getTxtUserName() {
		return txtUserName;
	}

	public WebElement getTxtPassword() {
		return txtPassword;
	}

	public WebElement getBtnLogin() {
		return btnLogin;
	}

	public WebElement getLoginVerifyMessage() {
		return loginVerifyMessage;
	}

	public void login(String UserName, String password) {
		sendKeys(txtUserName, UserName);
		sendKeys(txtPassword, password);
		elementClick(btnLogin);

	}

	public void loginByEnter(String userName, String password) throws AWTException {
		sendKeys(getTxtUserName(), userName);
		sendKeys(getTxtPassword(), password);
		implicitWait(30);
//		keypressaction(KeyEvent.VK_TAB);
//		keyreleaction(KeyEvent.VK_TAB);
//		keypressaction(KeyEvent.VK_TAB);
//		keyreleaction(KeyEvent.VK_TAB);
		keypressaction(KeyEvent.VK_ENTER);
		keyreleaction(KeyEvent.VK_ENTER);
	}


}

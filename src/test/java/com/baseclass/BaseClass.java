package com.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
//	WebDriver Launch
	public static void browserLaunch(String browserType) {
		switch (browserType) {
		case "Chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "Edge":
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		default:
			break;
		}
	}
//		Get Value from Propeties file
	public String getValueFromPropertyFile(String key) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(System.getProperty("user.dir") + "\\Config\\Config.properties"));
		String value = (String) properties.get(key);
		return value;
	}

	// 1,get the current URL
	public static void enterUrl(String url) {
		driver.get(url);
	}

	// 2,To maximize the window
	public static void maxmizeWindow() {
		driver.manage().window().maximize();
	}

	// 3,Send the values
	public static void sendKeys(WebElement element, String value) {
		element.sendKeys(value);
	}

	// 4,to click the particular element
	public static void elementClick(WebElement element) {
		element.click();
	}

	// 5,get get current page title
	public String getCurrentTitle() {
		String title = driver.getTitle();
		return title;
	}

	// 6,find a WebElement from webpage by id
	public static  WebElement findElementbyId(String value) {
		WebElement element = driver.findElement(By.id(value));
		return element;
	}

	// 7,find a WebElement from webpage by name
	public WebElement findElementbyName(String value) {

		WebElement element = driver.findElement(By.name(value));
		return element;
	}

	// 8,find a WebElement from webpage by classname
	public WebElement findElementbyClassname(String value) {

		WebElement element = driver.findElement(By.className(value));
		return element;
	}

	// 9,find a WebElement from webpage by Xpath
	public WebElement findElementbyXpath(String value) {

		WebElement element = driver.findElement(By.xpath(value));
		return element;
	}

	// 10,find a WebElement from webpage by CssSelector
	public WebElement findElementbyCssSelector(String value) {

		WebElement element = driver.findElement(By.cssSelector(value));
		return element;
	}

	// 11,find a WebElement from webpage by linktext
	public WebElement findElementbyLinktext(String value) {

		WebElement element = driver.findElement(By.linkText(value));
		return element;
	}

	// 12,find a WebElement from WebPage by PartialLinktext
	public WebElement findElementbyPartialLinktext(String value) {

		WebElement element = driver.findElement(By.partialLinkText(value));
		return element;
	}

	// 13, to close the current window
	public void closeCurrentWinow() {
		driver.close();
	}

	// 14, to close the all window
	public static void closeAllWindow() {
		driver.quit();
	}

	// 15,get the text from the webElement
	public String getTextFromElement(WebElement element) {
		String text = element.getText();
		return text;
	}

	// 99% all values stored in value tag only
	// 16.get the text from the webElement by Attribute
	public  String getAttributeValue(WebElement element) {
		String text = element.getAttribute("value");
		return text;
	}

	// it is a real time example for method overloading
	// 1% the entered values stored in other tags
	// 17.get the text from the webElement by Attribute
	public String getElementText(WebElement element) {
		String text = element.getText();
		return text;
	}

	// 18, get the Current URL
	public String gteCurrentUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	// 19, SelectBy Index
	public void selectOptbyIndex(WebElement element, int index) {

		Select select = new Select(element);
		select.selectByIndex(index);
	}

	// 20, Select by visible text
	public void selectOptbyText(WebElement element, String value) {

		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	// 21,Select by Attribute value
	public void selectOptbyValue(WebElement element, String value) {

		Select select = new Select(element);
		select.selectByValue(value);
	}

	// 22,deselect by index
	public void deselectByIndex(WebElement element, int value) {

		Select select = new Select(element);
		select.deselectByIndex(value);
	}

	// 23,de select by value
	public void deselectOptbyValue(WebElement element, String value) {

		Select select = new Select(element);
		select.deselectByValue(value);
	}

	// 24,Deselect by text
	public void deselectOptbyText(WebElement element, String text) {

		Select select = new Select(element);
		select.deselectByVisibleText(text);
	}

	// 25,DeselectAll
	public void deselectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
	}

	// 26,DeselectAll
	public List getAlltheOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		return options;
	}

	// 27, get All Selected OPtions
	public List getallSelectedOPtions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		return allSelectedOptions;
	}

	// 28, check the whether the option is selected or not
	public boolean isSelected(WebElement element) {

		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
	}

	// 29, Send the values by js
	public void elementSendKeysByJs(WebElement element, String value) {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" + value + "')", element);
	}

	// 30, Send the values by js
	public void elementgetvaleByJs(WebElement element) {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].getAttribute('value')", element);
	}

	// 31, Send the values by js
	public Object elementgetvaleByJs(WebElement element, String value) {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Object executeScript = executor.executeScript("arguments[0].getAttribute('" + value + "')", element);
		return executeScript;
	}

	// 32, Lanuch Browser by Navigation to method
	public void browserLaunchBynavigation(String url) {
		driver.navigate().to(url);
	}

	// 33, Do forward options by Navigation command
	public void ForwardOptionBynavigation() {
		driver.navigate().forward();
	}

	// 34, Do back options by Navigation command
	public void backOptionByBynavigation() {
		driver.navigate().back();
	}

	// 35, Do refresh options by Navigation command
	public void refresOptionByBynavigation() {
		driver.navigate().refresh();
	}

	// 36, Handling the alert by accept()
	public void handleAlertByAccept() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	// 37, Handling alert by dismiss()
	public void handleAlertByDismiss() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	// 38, Handling Alert by SendKeys and accept()
	public void handleAlertBySendKeys(String keysToSend) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(keysToSend);
		alert.accept();
	}

	// 39,Take ScreenShot From Current Page
	public void takeaScreenShot(String pathname) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenOut = screenshot.getScreenshotAs(OutputType.FILE);
		File file = new File(pathname);
		FileUtils.copyFile(screenOut, file);
	}

	// 40, get the excel sheet cell value
	public String getCellValue(String sheetName, int rowNumber, int cellnum) throws IOException {

		String res = null;

		File file = new File("C:\\Users\\hp\\eclipse-workspace\\MavenPractice\\Excel\\AdactinExcel.xlsx");
		FileInputStream inputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNumber);
		Cell cell = row.getCell(cellnum);
		CellType cellType = cell.getCellType();

		switch (cellType) {
		case STRING:

			res = cell.getStringCellValue();
			break;

		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date value = cell.getDateCellValue();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				res = dateFormat.format(value);
			} else {

				double cellValue = cell.getNumericCellValue();
				BigDecimal bigDecimal = BigDecimal.valueOf(cellValue);
				res = bigDecimal.toString();
				long round = Math.round(cellValue);
				if (round == cellValue) {
					res = String.valueOf(round);
				} else {
					res = String.valueOf(cellValue);
				}

			}

		default:
			break;
		}
		return res;
	}

	// 41, Update the excel sheet cell value
	public void updateCellValue(String sheetName, int rownum, int cellnum, String oldValue, String newvalue)
			throws IOException {

		File file = new File("C:\\Users\\hp\\eclipse-workspace\\MavenPractice\\Excel\\Employee.xlsx");
		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		String value = cell.getStringCellValue();
		if (value.equals(oldValue)) {
			cell.setCellValue(newvalue);
			FileOutputStream outputStream = new FileOutputStream(file);
			workbook.write(outputStream);
		}
	}

	// 42, Create new Cell And update the Values
	public void newCellValue(String sheetName, int rownum, int cellnum, String newvalue) throws IOException {
		File file = new File("C:\\Users\\hp\\eclipse-workspace\\MavenPractice\\Excel\\AdactinExcel.xlsx");

		FileInputStream fileInputStream = new FileInputStream(file);
		Workbook workBook = new XSSFWorkbook(fileInputStream);
		Sheet sheet = workBook.getSheet(sheetName);
		Row row = sheet.getRow(rownum);
		Cell cell = row.createCell(cellnum);
		cell.setCellValue(newvalue);
		FileOutputStream stream = new FileOutputStream(file);
		workBook.write(stream);

	}

	// 43, Clear the all values from text box
	public void clearValue(WebElement element) {
		element.clear();
	}

	// 44, Applying Implicit waits
	public void implicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}

	// 45, Reverse the String Values
	public String revStr(String stringvalue) {
		String rev = "";
		for (int i = 0; i < stringvalue.length(); i++) {
			char cha = stringvalue.charAt(i);
			rev = cha + rev;
		}
		return rev;

	}

	// 46, To Perform mouseOver Action by action class
	public void mouseOvertoElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}

	// 47, To Perform DragAndDrop by action class
	public void dragandaDropElement(WebElement source, WebElement target) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(source, target).perform();
	}

	// 48, Right click By Actions class
	public void elementRightClick(WebElement target) {
		Actions actions = new Actions(driver);
		actions.contextClick(target).perform();
	}

	// 49,To perform by double click
	public void elementDoubleClick(WebElement target) {
		Actions actions = new Actions(driver);
		actions.doubleClick(target).perform();
	}

	// 50, To Perform KeyUp By Actions Class
	public void keyUpbyActions(CharSequence key) {
		Actions actions = new Actions(driver);
		actions.keyUp(key).perform();
	}

	// 51, To Perform KeyDown By Actions Class
	public void keyDownbyActions(CharSequence key) {
		Actions actions = new Actions(driver);
		actions.keyDown(key).perform();
	}

	// 52, To Perform SendKeys By Actions Class
	public void sendKeysbyActions(WebElement element, CharSequence key) {
		Actions actions = new Actions(driver);
		actions.sendKeys(element, key);
	}

	// 53,Keyboard keyPress action by Robot Class
	public void keypressaction(int keycode) throws AWTException {
		Robot robo = new Robot();
		robo.keyPress(keycode);
	}

	// 54, Keyboard KeyReleas action by Robot Class
	public void keyreleaction(int keycode) throws AWTException {
		Robot robo = new Robot();
		robo.keyRelease(keycode);
	}

	// 55, Send a values by more the webElemetn JavaScript executor
	public void elementmorethenoneSendKeysByJs(WebElement element, WebElement element1, String value) {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value'" + value + "'", element, element1);
	}

	public void elementmorethenonegetvaleByJs(WebElement element1, WebElement element) {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].getAttribute('vale')", element, element1);
	}

	// 56, Send the values by ja
	public Object elementmorethenogetvaleByJs(WebElement element, WebElement element1, String value) {

		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Object executeScript = executor.executeScript("arguments[0].getAttribute('" + value + "')", element, element1);
		return executeScript;
	}

	// 57, Switch to the frame By Index
	public void switchbyIndex(int index) {
		driver.switchTo().frame(index);
	}

	// 58, Switch to the frame By Name
	public void switchbyName(String nameOrId) {
		driver.switchTo().frame(nameOrId);
	}

	// 59, Switch to the frame By WebElement
	public void switchbyWebElement(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	// 60, Switch to the ParenFrame
	public void switchToParentFrame() {
		driver.switchTo().parentFrame();
	}

	// 61, Switch to the defaultFrame
	public void switchToDefaultFrame() {
		driver.switchTo().defaultContent();
	}

}

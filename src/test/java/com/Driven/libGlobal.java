package com.Driven;

		import java.awt.AWTException;

		import java.awt.Robot;
		import java.awt.event.KeyEvent;
		import java.io.File;
		import java.io.FileInputStream;
		import java.io.FileOutputStream;
		import java.io.IOException;
		import java.math.BigDecimal;
		import java.text.SimpleDateFormat;
		import java.util.Date;
		import java.util.List;
		import java.util.Set;
		import java.util.concurrent.TimeUnit;

		import org.apache.commons.io.FileUtils;
		import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
		import org.apache.poi.ss.usermodel.Row;
		import org.apache.poi.ss.usermodel.Sheet;
		import org.apache.poi.ss.usermodel.Workbook;
		import org.apache.poi.xssf.usermodel.XSSFWorkbook;
		import org.openqa.selenium.Alert;
		import org.openqa.selenium.By;
		import org.openqa.selenium.JavascriptExecutor;
		import org.openqa.selenium.Keys;
		import org.openqa.selenium.OutputType;
		import org.openqa.selenium.TakesScreenshot;
		import org.openqa.selenium.WebDriver;
		import org.openqa.selenium.WebElement;
		import org.openqa.selenium.chrome.ChromeDriver;
		import org.openqa.selenium.interactions.Actions;
		import org.openqa.selenium.support.ui.ExpectedConditions;
		import org.openqa.selenium.support.ui.Select;
		import org.openqa.selenium.support.ui.WebDriverWait;

		import io.github.bonigarcia.wdm.WebDriverManager;

		public class libGlobal {
		public String getData(String sheetName, int rownum, int cellnum) throws IOException {
		String data = null;
		File file = new File("D:\\git\\New folder\\GetData\\Data\\Book1.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		      Row row = sheet.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		int cellType = cell.getCellType();
		if(cellType==1) {
		data = cell.getStringCellValue();
		}
		if(cellType==0){

		if (DateUtil.isCellDateFormatted(cell)) {
		Date date = cell.getDateCellValue();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MMM.YY");
		data = dateFormat.format(date);

		} else {
		double d = cell.getNumericCellValue();
		BigDecimal value = BigDecimal.valueOf(d);
		data = value.toString();
		}
		
		}
		return data;
		}

		public void updateData(String sheetName, int row, int cellNum, String olddata, String newdata) throws IOException {
		File file = new File("D:\\git\\New folder\\GetData\\Data\\Book1.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		Row row2 = sheet.getRow(row);
		Cell cell = row2.getCell(cellNum);
		String value = cell.getStringCellValue();
		if (value.equals(olddata)) {
		cell.setCellValue(newdata);
		}
		FileOutputStream o = new FileOutputStream(file);

		workbook.write(o);

		}

		public void writeData(String sheetName, int row, int cellNum, String data) throws IOException {
		File file = new File("D:\\git\\New folder\\GetData\\Data\\Book1.xlsx");
		FileInputStream stream = new FileInputStream(file);
		Workbook workbook = new XSSFWorkbook(stream);
		Sheet sheet = workbook.getSheet(sheetName);
		        Row row2 = sheet.getRow(row);
		Cell Cell = row2.createCell(cellNum);
		Cell.setCellValue(data);
		FileOutputStream o = new FileOutputStream(file);
		workbook.write(o);

		}

		WebDriver driver;

		// 1
		public  void getDriver() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}

		// 2
		public void loadUrl(String Url) {
		driver.get(Url);
		}

		// 3
		public void click(WebElement element) {
		element.click();
		}
		// 4
		public WebElement findElementById(String attributeValue) {
		WebElement element = driver.findElement(By.id(attributeValue));
		return element;
		}

		// 5
		public void type(WebElement element, String data) {
		element.sendKeys(data);
		}

		// 6
		public WebElement findElementByName(String attributeValue) {
		WebElement element = driver.findElement(By.name(attributeValue));
		return element;
		}
		// 7

		public String toGetCurrentUrl() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
		}

		// 8
		public String title() {
		String title = driver.getTitle();
		return title;
		}

		// 9
		public WebElement className(String attributevalue) {
		WebElement element = driver.findElement(By.className("attribute value"));
		return element;
		}

		// 10
		public WebElement xpath(String xpath) {
		WebElement element = driver.findElement(By.xpath("attribute value"));
		return element;
		}

		// 11
		public String getText(WebElement element) {
		String text = element.getText();
		return text;
		}

		// 12
		public String getAttribute(WebElement element, String attributevalue) {
		String attribute = element.getAttribute("value");
		return attribute;
		}

		// 13
		public void clear(WebElement element) {
		element.clear();
		}

		// 14
		public void close() {
		driver.close();
		}

		// 15
		public void quit() {
		driver.quit();
		}
		// 16

		public void sleep(int num) throws InterruptedException {
		Thread.sleep(num);
		}

		// 17
		public void click1(WebElement element) {
		element.click();
		}

		// 18
		public void moveToElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		}

		// 19
		public void dragAndDrop(WebElement element) {
		Actions action = new Actions(driver);
		action.dragAndDrop(element, element).perform();
		}

		// 20
		public void rightClick(WebElement element) {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
		}

		// 21
		public void doubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
		}

		// 22
		public void actionKeys(WebElement element) {
		Actions action = new Actions(driver);
		action.keyDown(Keys.SHIFT).sendKeys(element, "Value").keyDown(Keys.SHIFT).perform();
		}

		// 23
		// Robot:class
		public void keyBoardActions(WebElement element) throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		}

		// 24
		public boolean isMultiple(WebElement element) {
		Select select = new Select(element);
		boolean multiple = select.isMultiple();
		return multiple;
		}

		// 25
		public void selectOptionIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
		}

		// 26
		public void selectOptionByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
		}

		// 27
		public void selectVisibleText(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText("text");
		}

		// 28
		public List<WebElement> getAllSelectedOption(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getAllSelectedOptions();
		return options;
		}

		// 29
		public WebElement getFirstSelectedOptions(WebElement element) {
		Select select = new Select(element);
		WebElement element1 = select.getFirstSelectedOption();
		return element1;
		}

		// 30
		public void deSelectByValue(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByValue("text");
		}

		// 31
		public void deSelectByIndex(WebElement element, int index1) {
		Select select = new Select(element);
		select.deselectByIndex(index1);
		}

		// 32
		public void deSelectByVisibleText(WebElement element, String value) {
		Select select = new Select(element);
		select.deselectByVisibleText("text");
		}

		// 33
		public void deSelectAll(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();
		}

		// 34
		public List<WebElement> getOptions(WebElement element) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		return options;
		}

		// 35
		public void accept() {
		Alert a = driver.switchTo().alert();
		a.accept();
		}

		// 36
		public void dismiss() {
		Alert a1 = driver.switchTo().alert();
		a1.dismiss();
		}

		// 37
		public void sendKeysAlert(String data) {
		Alert a1 = driver.switchTo().alert();
		a1.sendKeys(data);
		}

		// 38 JS
		public void insertByJs(String value, WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].setAttribute('value','" + value + "')", element);
		}

		// 39
		public Object attributeByJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		Object executeScript = executor.executeScript("return arguments[0].getAttribute('value')", element);
		return executeScript;
		}

		// 40
		public void clickByJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", element);
		}

		// 41
		public void scrollDownByJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true)", element);
		}

		// 42
		public void scrollUpByJs(WebElement element) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(false)", element);
		}

		// 43
		public void navigate(String url) {
		driver.navigate().to(url);
		}

		// 44 frame
		public void frameIndex(int num) {
		driver.switchTo().frame(num);
		}

		// 45
		public void frameId(String value) {
		driver.switchTo().frame(value);
		}

		// 46
		public void frameElement(WebElement element) {
		driver.switchTo().frame(element);
		}

		// 47 take ScreenShot
		public File takeScreenshot(String path) throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File s = screen.getScreenshotAs(OutputType.FILE);
		File d = new File(path);
		FileUtils.copyFile(s, d);
		return s;
		}

		// 48take ScreenShot of WebElement
		public File screenshotWebelement(String path, WebElement element, String value) throws IOException {
		element.sendKeys(value);
		File s = element.getScreenshotAs(OutputType.FILE);
		File d = new File(path);
		FileUtils.copyFile(s, d);
		return d;
		}

		// 49
		public void defaultFrame() {
		driver.switchTo().defaultContent();
		}

		// 50
		public void parentFrame() {
		driver.switchTo().parentFrame();
		}

		// 51 switch window
		public String switchWindow() {
		String handle = driver.getWindowHandle();
		driver.switchTo().window(handle);
		return handle;
		}

		// 52
		public Set<String> getWindowHandles() {
		Set<String> handles = driver.getWindowHandles();
		return handles;

		}

		// 53
		public List<WebElement> findElementsByid(String data) {
		List<WebElement> elements = driver.findElements(By.id(data));
		return elements;
		}

		// 54
		public List<WebElement> findElementsByname(String data) {
		List<WebElement> elements = driver.findElements(By.name(data));
		return elements;
		}

		// 55 Navigate
		public void previousPage() {
		driver.navigate().back();
		}

		// 56
		public void nextPage() {
		driver.navigate().forward();
		}

		// 57
		public void refresh() {
		driver.navigate().refresh();
		}

		// 58 Maximize window
		public void maximizeWindow() {
		driver.manage().window().maximize();
		}

		// 59 implicit Wait
		public void implicitWait(int num) {
		driver.manage().timeouts().implicitlyWait(num, TimeUnit.SECONDS);

		}

		// 60 alertIsPresent
		public Alert alertIsPresent(int num) {
		WebDriverWait wait = new WebDriverWait(driver, num);
		Alert until = wait.until(ExpectedConditions.alertIsPresent());
		return until;

		}

		// 61 visibilityOfAllElements
		public List<WebElement> visibilityOfAllElements(int num, WebElement elements) {
		WebDriverWait wait = new WebDriverWait(driver, num);
		List<WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElements(elements));
		return list;

		}

		}


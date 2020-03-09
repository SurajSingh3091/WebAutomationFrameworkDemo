package com.dkatalis.framework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Framework {

	static Properties prop;
	static WebDriver driver;
	ObjectReader orReader =null;
	public void readPropertyFile() throws Exception {

		prop = new Properties();
		String propFileName = System.getProperty("user.dir")
				+ "/src/test/java/com/dkatalis/resources/config.properties";
		System.out.println(propFileName);
		InputStream input = new FileInputStream(propFileName);
		try {
			prop.load(input);
		} catch (FileNotFoundException fnf) {
			System.out.println(fnf);
		}
	}

	public String getPropertyValue(String propertyName) {
		return (prop.getProperty(propertyName));
	}

	public WebDriver initialise(String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/src/test/recources/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("FireFox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") + "/src/test/recources/geckodriver.exe");
			driver = new FirefoxDriver();
		} else {
			System.setProperty("webdriver.ie.driver",
					System.getProperty("user.dir") + "/src/test/recources/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		return driver;

	}

	public boolean visibilityOfElement(String elementName){
		orReader = new ObjectReader();
		try{
			WebDriverWait wait = new WebDriverWait(driver,Long.parseLong(Framework.prop.getProperty("EXPLICIT_TIMEOUT")));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(orReader.getObjectLocator(elementName, "XPATH"))));
			return true;
		}catch(Exception e){
			System.out.println(e);
			return false;
		}
		
		
	}
}

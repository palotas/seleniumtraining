package HtmlElementSamples;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

public class SampleDropDown {
	
	@Test
	public void dropdownTest() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		
		try {
			driver.get("http://gridfusion.net/testpage.html");
			
			Select dropdown = new Select(driver.findElement(By.id("dropdown")));
			dropdown.selectByVisibleText("Mercedes");
			
			//check how many entries are in dropdown
			List<WebElement> options = dropdown.getOptions();
			Assert.assertEquals(4, options.size());
			
			//check if they are the correct entries
			List<String> expectedEntries = new ArrayList<String>();
			expectedEntries.add("Volvo");
			expectedEntries.add("Saab");
			expectedEntries.add("Mercedes");
			expectedEntries.add("Audi");
			int x = 0;
			
			for (WebElement option : options) {
				Assert.assertEquals(expectedEntries.get(x), option.getText());
				x++;
			}
			
			Thread.sleep(2000);
		}
		finally {
			
			driver.quit();
		}
				
	}
	
	
	
	
	/*
	 * directly selects the Sports entry in the dropdown
	 */
	@Test
	public void listBoxDirectSelection() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/home/gridfusion/SeleniumTraining/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://gwt.googleusercontent.com/samples/Showcase/Showcase.html#!CwListBox");
		
		Thread.sleep(2000);
		
		Select select=new Select(driver.findElement(By.id("gwt-debug-cwListBox-dropBox")));
		select.selectByVisibleText("Sports");
			
		Thread.sleep(2000);
		driver.quit();
	}
	
	
	/*
	 * selects the Sports entry in the dropdown via Action Builder
	 * THIS DOES NOT WORK WITH CHROME !!!!
	 */
	@Test
	public void listBoxActionBuilderSelection() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/home/gridfusion/SeleniumTraining/chromedriver");
		//WebDriver wd = new ChromeDriver();
		WebDriver wd = new FirefoxDriver();
		
	    EventFiringWebDriver driver = new EventFiringWebDriver(wd);        

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://gwt.googleusercontent.com/samples/Showcase/Showcase.html#!CwListBox");
		
		Thread.sleep(2000);
		
		WebElement dropDown=driver.findElement(By.id("gwt-debug-cwListBox-dropBox"));
		dropDown.click();
		
		Thread.sleep(2000);
		
	    Actions act = new Actions(driver);
	    act.moveToElement(driver.findElement(By.id("gwt-debug-cwListBox-dropBox-item2"))).click().build().perform();

		Thread.sleep(2000);
		driver.quit();
	}

}

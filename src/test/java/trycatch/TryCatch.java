package trycatch;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class TryCatch {
	
	
	@Test
	public void pageTitleTestFailNoTryCatch() throws FileNotFoundException, IOException {
		WebDriver driver = util.AxaDriverFactory.createAxaIEDriver();

		driver.get("http://www.abraxas.ch");
		Assert.assertEquals(driver.getTitle(), "GRIDFUSION.net - Home");	
		driver.quit();
	}	
	
	
	
	
	/*
	 * upon assertion failure the test stops
	 * and the browser is not closed
	 * add try/catch/finally to fix this
	 */
	@Test
	public void pageTitleTestFailWithTryCatch() throws FileNotFoundException, IOException {
		WebDriver driver = util.AxaDriverFactory.createAxaIEDriver();
		try {
			driver.get("http://www.abraxas.ch");
			Assert.assertEquals("GRIDFUSION.net - Home", driver.getTitle());	
		}
		catch (Error e) {
			System.out.println("Error message: " + e.getMessage());
			/*
			 * note: the test passes because we caught the exception
			 * to make it fail add: Assert.fail();
			 */
			Assert.fail();
		}
		finally {
			driver.quit();
		}
	}

}

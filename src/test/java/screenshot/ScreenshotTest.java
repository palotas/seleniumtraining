package screenshot;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ScreenshotTest {
	
	@Test
	public void testWithScreenshot() throws Exception {
		
		WebDriver driver = util.AxaDriverFactory.createAxaIEDriver();
		driver.get("http://gridfusion.net");
		DoScreenshot.takeScreenshotNoReport(driver);
		driver.quit();
	}


	@Test
	public void testWithScreenshotAndReportRemote() throws Exception {

		WebDriver driver = util.AxaDriverFactory.createAxaRemoteIEDriver();
		
		driver.get("http://gridfusion.net");
		DoScreenshot.remoteWebDriverScreenshot(driver);
		driver.quit();
	}
	
}

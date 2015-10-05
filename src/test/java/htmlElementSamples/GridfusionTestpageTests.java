package htmlElementSamples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

public class GridfusionTestpageTests {

		
	@Test
	public void testpageTest() throws InterruptedException, FileNotFoundException, IOException {
		WebDriver driver = new FirefoxDriver();

        driver.get("http://gridfusion.net/testpage.html");

        GridfusionTestpage mypage = new GridfusionTestpage(driver);
        mypage.selectDropdown();

	}

}

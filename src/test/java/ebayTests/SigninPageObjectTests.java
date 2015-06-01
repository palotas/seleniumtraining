package ebayTests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;
import org.openqa.selenium.WebDriver;

import ebayPageObjects.SigninPage;

public class SigninPageObjectTests {
	
    @Test
    public void signinWithPageObjectSingle() throws InterruptedException, FileNotFoundException, IOException {
        WebDriver driver = util.AxaDriverFactory.createAxaIEDriver();
        SigninPage signinpage = new SigninPage(driver);

        signinpage.enterUsername();
        signinpage.enterPassword();
        signinpage.clickSigninButton();

        Thread.sleep(5000);
        driver.quit();
    }
}



package InterfacePageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by gridfusion on 20/09/15.
 */
public class LoginPageBase {

    @FindBy(id="userid")
    protected WebElement userid;

    @FindBy(id="pass")
    protected WebElement pass;

    @FindBy(id="sgnBt")
    protected WebElement signinButton;

    public LoginPageBase() {

    }

    public LoginPageBase(WebDriver driver) {
        driver.get("https://signin.ebay.de/ws/eBayISAPI.dll?SignIn");
        PageFactory.initElements(driver, this);
    }
}

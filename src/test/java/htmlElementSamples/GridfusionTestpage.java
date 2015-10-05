package htmlElementSamples;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class GridfusionTestpage {


	@FindBy(id="dropdown")
    private WebElement wannabeSelect;



	public GridfusionTestpage(WebDriver driver) {
	    PageFactory.initElements(driver, this);
	}


	public void selectDropdown() throws InterruptedException {

        Select realSelect = new Select(wannabeSelect);
        realSelect.selectByIndex(2);
    }
	

	
	
}


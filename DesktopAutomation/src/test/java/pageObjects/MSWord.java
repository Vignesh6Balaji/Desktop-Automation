
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.Screen;

public class MSWord {

	public WebDriver driver;

	public MSWord(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "Blank document")
	@CacheLookup
	WebElement ele;

	public void clickBlankDoc() {
		ele.click();
	}

	public void writeData(String data) {
		Screen sc = new Screen();
		sc.write(data);
	}
}

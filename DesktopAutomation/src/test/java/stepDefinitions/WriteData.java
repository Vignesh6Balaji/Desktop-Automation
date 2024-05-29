package stepDefinitions;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.windows.WindowsDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BoldItalic;

public class WriteData {
	public static WebDriver driver;
	public static BoldItalic bi;
	
	@Given("Open MsWord App")
	public void open_ms_word_app() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Windows");
		cap.setCapability("deviceName", "Windows");
		cap.setCapability("app", "WINWORD.exe");

		driver = new WindowsDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		bi = new BoldItalic(driver);
	}

	@When("Click on Blank")
	public void click_on_blank() {
	    bi.clickBlankDoc();
	}

	@When("Enter Data as {string}")
	public void enter_data_as(String string) {
	    bi.writeData(string);
	}

	@When("Make the datas Bold and Italic")
	public void make_the_datas_bold_and_italic() throws InterruptedException, AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);
		bi.boldText();
	    Thread.sleep(2000);
	    bi.italicText();
	}

	@Then("Close the Application")
	public void close_the_application() throws AWTException {
		Robot r = new Robot();
		driver.quit();
		for (int i = 0; i <= 4; i++) {
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
		}
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
}

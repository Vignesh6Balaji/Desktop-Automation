package stepDefinitions;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.windows.WindowsDriver;
import io.cucumber.java.en.*;
import pageObjects.MSWord;

public class Steps {

	public static WebDriver driver;
	public static MSWord msw;

	@Given("Open MsWord Application")
	public void open_ms_word_application() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Windows");
		cap.setCapability("deviceName", "Windows");
		cap.setCapability("app", "WINWORD.exe");

		driver = new WindowsDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		msw = new MSWord(driver);
	}

	@When("Click on Blank Template")
	public void click_on_blank_template() {
		msw.clickBlankDoc();
	}

	@Then("Enter Data into Document as {string}")
	public void enter_data_into_document_as(String string) throws AWTException, InterruptedException {
		msw.writeData(string);
		Robot r = new Robot();
		driver.quit();
		for (int i = 0; i <= 4; i++) {
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
			Thread.sleep(1000);
		}
		Thread.sleep(1000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
}

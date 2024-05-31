package utilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class BaseDriver {
	
	public AndroidDriver<AndroidElement> driver;
	
	
	@BeforeMethod
	public void setDriver() {
		try {
			File f = new File("src");
			File fs = new File(f, "myntra.android.apk");
			
			DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
			desiredCapabilities.setCapability("platformName", "android");
			desiredCapabilities.setCapability("udid", "emulator-5554");
			desiredCapabilities.setCapability("deviceName", "local");
			desiredCapabilities.setCapability("appPackage", "com.myntra.android");
			desiredCapabilities.setCapability("appActivity", "com.myntra.android.SplashActivity");
			//desiredCapabilities.setCapability("app", fs.getAbsolutePath());
			URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
			
			driver = new AndroidDriver<>(remoteUrl, desiredCapabilities);
			// Replace the following sleep with explicit wait if needed
			Thread.sleep(3000);
		} 
		catch (MalformedURLException | InterruptedException e) {
			e.printStackTrace();
			// Handle exception as needed, e.g., fail the test or log an error message
		}
	}
	
	public AndroidDriver<AndroidElement> getDriver() {
		return this.driver;
	}
	
	@AfterMethod
	public void quitDriver() {
		if (driver != null) {
			driver.quit();
		}
	}
}

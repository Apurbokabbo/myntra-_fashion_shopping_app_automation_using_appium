package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidElement;
import utilities.BaseDriver;

public class LandingPage extends BaseDriver {

	@Test
    public void testAppOpen() {
        // Assert that the app is open successfully by checking the visibility of an element on the app's home screen
        AndroidElement element = driver.findElementByXPath("//android.widget.Button[@content-desc=\"tabButton_home\"]/android.widget.TextView");
        boolean isElementVisible = element.isDisplayed();
        Assert.assertTrue(isElementVisible, "Element not found or not visible. App might not be opened successfully.");
    }
}

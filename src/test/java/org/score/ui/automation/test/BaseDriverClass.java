package org.score.ui.automation.test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseDriverClass {
    AppiumDriver<MobileElement> driver;


    @BeforeSuite
    public void setUp() {
        try {
            DesiredCapabilities desired = new DesiredCapabilities();
            desired.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
            desired.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
            desired.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.1.1");
            desired.setCapability(MobileCapabilityType.DEVICE_NAME, "pp2");
            desired.setCapability("appPackage", "com.fivemobile.thescore");
            desired.setCapability("appActivity", "com.fivemobile.thescore.ui.MainActivity");

            URL url = new URL("http://127.0.0.1:4723/");
            driver = new  AppiumDriver (url,desired);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }catch(Exception e) {
            System.out.println("Error at" + e.getClass());
        }
    }

    @AfterSuite
    public void tearDown() {
        driver.quit();

    }
}

package org.score.ui.automation.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static org.testng.AssertJUnit.assertEquals;


public class SplashScreenPage {
    public final AppiumDriver<MobileElement>  driver;

    public SplashScreenPage(AppiumDriver<MobileElement>  driver) {
        this.driver =driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public MobileElement getStartedButton() {
        return driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.fivemobile.thescore:id/action_button_text\")"));
    }

    public void assertGetStartedButtonText(WebElement element) {
        String getStartedButtonText = element.getText();
        assertEquals("Get Started", getStartedButtonText);
    }

    public void clickGetStartedButton() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(getStartedButton()));
        assertGetStartedButtonText(getStartedButton());
        element.click();
    }
}


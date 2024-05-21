package org.score.ui.automation.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import static org.testng.AssertJUnit.assertEquals;


public class SplashScreenPage {
    public final AppiumDriver driver;

    public SplashScreenPage(AppiumDriver driver) {
        this.driver =driver;
       // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public WebElement getStartedButton() {
        return driver.findElementById("action_button_text");
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


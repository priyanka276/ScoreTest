package org.score.ui.automation.test;

import org.score.ui.automation.pages.SplashScreenPage;
import org.testng.annotations.Test;

public class SplashTest extends BaseDriverClass{
    public SplashScreenPage splashPage;

    @Test
    public void verifySplashScreen() {
        splashPage = new SplashScreenPage(driver);
        splashPage.clickGetStartedButton();
    }
}

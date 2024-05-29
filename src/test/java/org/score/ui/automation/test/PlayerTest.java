package org.score.ui.automation.test;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.score.ui.automation.pages.LeaguePage;
import org.score.ui.automation.pages.SplashScreenPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PlayerTest extends BaseDriverClass {
    public SplashScreenPage splashPage;
    public LeaguePage leaguePage;
    String text = "Choose your favorite leagues";
    String team = "NHL Hockey";

    @BeforeClass
    public void setUpLeague() {
        splashPage = new SplashScreenPage(driver);
        leaguePage = new LeaguePage(driver);
        splashPage.clickGetStartedButton();
        leaguePage.assertTitle(text);

        //Select league and click Continue Button
        leaguePage.selectItemByName(team).click();
        leaguePage.continueButton().click();

        //Click Later Button and select team
        leaguePage.clickMayBeLaterButton();
        leaguePage.continueButton().click();
        leaguePage.getSwitch(0).click();
        leaguePage.continueButton().click();
        leaguePage.selectLaterButton().click();
        leaguePage.dismissModal().click();
    }

    @Test(dataProvider ="players")
    public void verifyPlayersAreAdded(String playerName) {
        //Add new players and assert added players are displayed correctly
        leaguePage.addButton().click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(leaguePage.selectItemByName("PLAYERS")));
        leaguePage.selectItemByName("PLAYERS").click();
        leaguePage.selectItemByName(playerName).click();
        leaguePage.backButton().click();
        leaguePage.assertPlayerIsAdded(playerName);
        leaguePage.backButton().click();
    }

    @DataProvider(name = "players")
    public Object[][] dataPlayers() {
        return new Object[][] {
                { "Russell Westbrook" },
                { "Tom Brady" },
                { "Kyrie Irving" },
                { "Cristiano Ronaldo" },
                { "Lionel Messi" }
        };
    }
}

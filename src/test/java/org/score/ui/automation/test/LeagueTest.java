package org.score.ui.automation.test;

import org.score.ui.automation.pages.LeaguePage;
import org.score.ui.automation.pages.SplashScreenPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LeagueTest extends BaseDriverClass{
    public SplashScreenPage splashPage;
    public LeaguePage leaguePage;

    @BeforeClass
    public void goToLeaguePage() {
        splashPage = new SplashScreenPage(driver);
        leaguePage = new LeaguePage(driver);
        splashPage.clickGetStartedButton();
    }
    @Test()
    public void verifyLeaguePage() {
        String text = "Choose your favorite leagues";
        leaguePage.assertTitle(text);
    }

    @Parameters({ "league-param", "team-param" })
    @Test
    public void e2eTestSelectLeagueAndTeam(String league, String team){

        //Select league and click Continue Button
        leaguePage.selectItemByName(league).click();
        leaguePage.continueButton().click();

        //Click Later Button and select team
        leaguePage.clickMayBeLaterButton();
        leaguePage.selectTeamByName(team).click();
        leaguePage.continueButton().click();
        leaguePage.getSwitch(0).click();
        leaguePage.continueButton().click();
        leaguePage.selectLaterButton().click();
        leaguePage.dismissModal().click();
    }
}

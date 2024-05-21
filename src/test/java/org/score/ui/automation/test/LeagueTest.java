package org.score.ui.automation.test;

import org.score.ui.automation.pages.LeaguePage;
import org.score.ui.automation.pages.SplashScreenPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
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
    @Test(priority=0)
    public void verifyLeaguePage() {
        String text = "Choose your favorite leagues";
        leaguePage.assertTitle(text);
    }

    @Test(dataProvider ="leagueList", priority=1)
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

    @Test(dataProvider ="players",priority = 2)
    public void verifyPlayersAreAdded(String playerName) {
        leaguePage.addButton().click();
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
                { "Lionel Messi" } };
    }
    @DataProvider(name = "leagueList")
    public Object[][] LeagueData(){
        return new Object[][]{
                {"NHL Hockey","Toronto Maple Leafs"}
        };
    }
}

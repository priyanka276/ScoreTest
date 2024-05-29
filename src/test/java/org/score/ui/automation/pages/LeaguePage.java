package org.score.ui.automation.pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.score.ui.automation.test.BaseDriverClass;
import org.testng.Assert;
import java.util.List;
import java.util.concurrent.TimeUnit;
import static org.testng.AssertJUnit.assertEquals;

public class LeaguePage extends BaseDriverClass {

    protected final AppiumDriver<MobileElement>  driver;

    public LeaguePage(AppiumDriver<MobileElement>  driver) {
        this.driver =driver;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public MobileElement getLeagueTitle() {
        return driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.fivemobile.thescore:id/title_onboarding\")"));
    }

    public MobileElement selectItemByName(String name){
        return driver.findElementByXPath("//*[@text='"+name+"']");
    }

    public MobileElement backButton(){
        return driver.findElementByXPath("//android.widget.ImageButton[@content-desc='Navigate up']");
    }

    public MobileElement selectTeamByName(String name){
       return driver.findElementByXPath("//android.widget.TextView[@text='"+name+"']");
    }

    public MobileElement getSwitch(int index){
        List<MobileElement> elements = driver.findElementsById("selectedSwitch");
        return elements.get(index);
    }

    public MobileElement mayBeLaterButton(){
        return driver.findElementById("btn_disallow");
    }

    public MobileElement selectLaterButton(){
        return driver.findElementById("btn_secondary");
    }

    public MobileElement continueButton(){
        return driver.findElementById("action_button_text");
    }

    public MobileElement dismissModal(){
        return driver.findElementById("dismiss_modal");
    }

    public MobileElement addButton(){
        return driver.findElementsByClassName("android.widget.ImageView").get(1);
    }


    public WebElement playersTab() {
        return driver.findElementByXPath("//android.widget.LinearLayout[@content-desc='Players']");

    }

    public WebElement playerStats() {
        return driver.findElementByXPath("//android.widget.LinearLayout[@content-desc='Player Stats']");
    }

    public WebElement playerName() {
        return driver.findElementByXPath("//*[@resource-id='com.fivemobile.thescore:id/txt_player_name']");
    }

    public MobileElement playerIcon() {
        return driver.findElementsByXPath("//*[@resource-id='com.fivemobile.thescore:id/player_headshot_image_view']").get(0);
    }

    public WebElement getTeamTitle(){
        return getElementByClassText("Choose your favorite teams"," android.widget.TextView");
    }

    public WebElement getElementByClassText(String text, String classText){
        WebElement element = null;
        List<MobileElement> list = driver.findElementsByClassName(classText);
        for(WebElement e : list){
            if(e.getText().equals(text)){
                element = e;
                break;
            }
        }
        return element;
    }

    public void assertTitle(String title) {
        String getStartedButtonText = getLeagueTitle().getText();
        assertEquals(title, getStartedButtonText);
    }
    public void clickMayBeLaterButton() {
        if(mayBeLaterButton().isDisplayed()){
            mayBeLaterButton().click();
        }
    }

    public void assertPlayerIsAdded(String playerName) {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.fivemobile.thescore:id/player_headshot_image_view']")));
        playerIcon().click();
        Assert.assertEquals(playerName().getText(),playerName);
    }
}

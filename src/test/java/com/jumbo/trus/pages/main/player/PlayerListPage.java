package com.jumbo.trus.pages.main.player;

import com.jumbo.trus.pages.main.MainPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class PlayerListPage extends MainPage {

    public PlayerListPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    private WebElement getPlayerList() {
        return waitFor(find.byValueKey("player_list"));
    }

    private WebElement getMenuAddPlayer(String playerName) {
        return scrollUntilVisible(find.byText(playerName), "player_list");
    }

    public AddPlayerPage clickOnPlayer(String playerName) {
        WebElement player = getMenuAddPlayer(playerName);
        if (player == null) {
            Assert.fail("Hráč " + playerName + " nenalezen");
        }
        player.click();
        return new AddPlayerPage(driver);
    }

    public boolean isPlayerDisplayed(String playerName) {
        WebElement player = getMenuAddPlayer(playerName);
        return player != null;
    }

    public boolean isPlayerListDisplayed() {
        return isElementDisplayed(find.byValueKey("player_list"), 8000);
    }
}

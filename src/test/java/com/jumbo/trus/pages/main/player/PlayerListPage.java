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

    private WebElement getPlayerFromList(String playerName) {
        return scrollUntilVisibleByText(find.byValueKey("player_list"), playerName);
    }

    public AddPlayerPage clickOnPlayer(String playerName) {
        WebElement player = getPlayerFromList(playerName);
        if (player == null) {
            Assert.fail("Hráč " + playerName + " nenalezen");
        }
        player.click();
        AddPlayerPage addPlayerPage = new AddPlayerPage(driver);
        Assert.assertTrue(addPlayerPage.isPlayerNameFieldDisplayed(), "Je očekáváno zobrazení obrazovky pro přidání/editaci hráče");
        return addPlayerPage;
    }

    public boolean isPlayerDisplayed(String playerName) {
        WebElement player = getPlayerFromList(playerName);
        return player != null;
    }

    public boolean isPlayerListDisplayed() {
        return isElementDisplayed(find.byValueKey("player_list"), 8000);
    }
}

package com.jumbo.trus.tests.player;

import com.jumbo.trus.pages.login.LoginPage;
import com.jumbo.trus.pages.main.home.HomePage;
import com.jumbo.trus.pages.main.player.AddPlayerPage;
import com.jumbo.trus.pages.main.player.PlayerListPage;
import com.jumbo.trus.tests.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayerPositiveTests extends BaseClass {

    @Test
    public void addEditDeletePlayerWithCustomDateTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage nextPage = loginPage.positiveLogin(LoginPage.VALID_USER, LoginPage.VALID_USER_PASSWORD);
        Assert.assertTrue(nextPage.isPlusButtonDisplayed(), "Po přihlášení očekáváme HomePage");
        AddPlayerPage addPlayerPage = nextPage.clickOnBottomMenu().clickOnAddPlayer().fillNameField("Automation player");
        Assert.assertTrue(addPlayerPage.isPlayerNameFieldDisplayed(), "Je očekáváno zobrazení obrazovky AddPlayer");
        PlayerListPage playerListPage = addPlayerPage.clickOnConfirmButton().clickOnBottomMenu().clickOnPlayerList();
        Assert.assertTrue(playerListPage.isPlayerListDisplayed(), "Je očekáváno zobrazení seznamu hráčů");
        playerListPage.clickOnPlayer("Automation player");
        Assert.assertTrue(addPlayerPage.isPlayerNameFieldDisplayed(), "Je očekáváno zobrazení obrazovky AddPlayer");
    }
}

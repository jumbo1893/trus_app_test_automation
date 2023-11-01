package com.jumbo.trus.tests.player;

import com.jumbo.trus.pages.login.LoginPage;
import com.jumbo.trus.pages.main.home.HomePage;
import com.jumbo.trus.pages.main.player.AddPlayerPage;
import com.jumbo.trus.pages.main.player.PlayerListPage;
import com.jumbo.trus.tests.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayerNegativeTests extends BaseClass {

    @Test
    public void addPlayerWithoutNameTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage nextPage = loginPage.positiveLogin(LoginPage.VALID_USER, LoginPage.VALID_USER_PASSWORD);
        Assert.assertTrue(nextPage.isPlusButtonDisplayed(), "Po přihlášení očekáváme HomePage");
        AddPlayerPage addPlayerPage = nextPage.clickOnBottomMenu().clickOnAddPlayer();
        Assert.assertTrue(addPlayerPage.isPlayerNameFieldDisplayed(), "Je očekáváno zobrazení obrazovky AddPlayer");
        addPlayerPage.clickOnConfirmButton();
        Assert.assertTrue(addPlayerPage.isPlayerNameFieldErrorTextDisplayed(), "Je očekávána chyba toto musíš vyplnit");
    }

    @Test
    public void EditPlayerWithoutNameTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage nextPage = loginPage.positiveLogin(LoginPage.VALID_USER, LoginPage.VALID_USER_PASSWORD);
        Assert.assertTrue(nextPage.isPlusButtonDisplayed(), "Po přihlášení očekáváme HomePage");
        PlayerListPage playerListPage = nextPage.clickOnBottomMenu().clickOnPlayerList();
        Assert.assertTrue(playerListPage.isPlayerListDisplayed(), "Je očekáváno zobrazení seznamu hráčů");
        AddPlayerPage addPlayerPage = playerListPage.clickOnPlayer(AddPlayerPage.EXISTING_PLAYER);
        Assert.assertTrue(addPlayerPage.isPlayerNameFieldDisplayed(), "Je očekáváno zobrazení obrazovky AddPlayer");
        addPlayerPage.cleanNameField().clickOnConfirmButton();
        Assert.assertTrue(addPlayerPage.isPlayerNameFieldErrorTextDisplayed(), "Je očekávána chyba toto musíš vyplnit");
    }
}

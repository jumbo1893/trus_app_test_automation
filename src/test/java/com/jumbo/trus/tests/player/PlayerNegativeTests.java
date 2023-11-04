package com.jumbo.trus.tests.player;

import com.jumbo.trus.pages.login.LoginPage;
import com.jumbo.trus.pages.main.player.AddPlayerPage;
import com.jumbo.trus.tests.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlayerNegativeTests extends BaseClass {

    @Test
    public void addPlayerWithoutNameTest() {
        LoginPage loginPage = new LoginPage(driver);
        AddPlayerPage addPlayerPage = loginPage
                .loginToHomePage()
                .navigateToAddPlayerPage()
                .clickOnConfirmButton();
        Assert.assertTrue(addPlayerPage.isPlayerNameFieldErrorTextDisplayed(), "Je očekávána chyba toto musíš vyplnit");
    }

    @Test
    public void editPlayerWithoutNameTest() {
        LoginPage loginPage = new LoginPage(driver);
        AddPlayerPage addPlayerPage = loginPage
                .loginToHomePage()
                .navigateToPlayerListPage()
                .clickOnPlayer(AddPlayerPage.EXISTING_PLAYER)
                .cleanNameField()
                .clickOnConfirmButton();
        Assert.assertTrue(addPlayerPage.isPlayerNameFieldErrorTextDisplayed(), "Je očekávána chyba toto musíš vyplnit");
    }
}

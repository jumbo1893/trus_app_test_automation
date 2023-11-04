package com.jumbo.trus.tests.match;

import com.jumbo.trus.pages.login.LoginPage;
import com.jumbo.trus.pages.main.match.AddMatchPage;
import com.jumbo.trus.tests.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MatchNegativeTests extends BaseClass {

    @Test
    public void addMatchWithoutNameTest() {
        LoginPage loginPage = new LoginPage(driver);
        AddMatchPage addMatchPage = loginPage
                .loginToHomePage()
                .navigateToAddMatchPage()
                .clickOnConfirmButton();
        Assert.assertTrue(addMatchPage.isMatchNameFieldErrorTextDisplayed(), "Je očekávána chyba toto musíš vyplnit");
    }
    @Test
    public void addMatchWithoutPlayersTest() {
        LoginPage loginPage = new LoginPage(driver);
        AddMatchPage addMatchPage = loginPage
                .loginToHomePage()
                .navigateToAddMatchPage()
                .setPlayer("Anti", false)
                .clickOnConfirmButton();
        Assert.assertTrue(addMatchPage.isPlayersMissingErrorDisplayed(), "Je očekávána chyba musí být označen aspoň jeden hráč");
    }

    @Test
    public void editMatchWithoutNameTest() {
        LoginPage loginPage = new LoginPage(driver);
        AddMatchPage addMatchPage = loginPage
                .loginToHomePage()
                .navigateToMatchListPage()
                .setSeason("Všechny sezony")
                .clickOnMatch(AddMatchPage.EXISTING_MATCH)
                .cleanNameField()
                .clickOnConfirmButton();
        Assert.assertTrue(addMatchPage.isMatchNameFieldErrorTextDisplayed(), "Je očekávána chyba toto musíš vyplnit");
    }

    @Test
    public void editMatchWithoutPlayersTest() {
        LoginPage loginPage = new LoginPage(driver);
        AddMatchPage addMatchPage = loginPage
                .loginToHomePage()
                .navigateToMatchListPage()
                .setSeason("Všechny sezony")
                .clickOnMatch(AddMatchPage.EXISTING_MATCH)
                .setPlayer(AddMatchPage.EXISTING_MATCH_PLAYER, true)
                .clickOnConfirmButton();
        Assert.assertTrue(addMatchPage.isPlayersMissingErrorDisplayed(), "Je očekávána chyba musí být označen aspoň jeden hráč");
    }
}

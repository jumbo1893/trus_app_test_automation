package com.jumbo.trus.tests.player;

import com.jumbo.trus.pages.login.LoginPage;
import com.jumbo.trus.pages.main.player.PlayerListPage;
import com.jumbo.trus.tests.BaseClass;
import com.jumbo.trus.util.CalendarDateTranslator;
import com.jumbo.trus.util.RandomStringGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class PlayerPositiveTests extends BaseClass {

    @Test
    public void addEditDeletePlayerWithCustomDateTest() {
        RandomStringGenerator random = new RandomStringGenerator();
        String newPlayerName = random.getRandomName();
        LocalDate newDate = random.getRandomDate();
        String editPlayerName = random.getRandomName();
        LoginPage loginPage = new LoginPage(driver);
        PlayerListPage playerListPage = loginPage
                .loginToHomePage()
                .navigateToAddPlayerPage()
                .fillNameField(newPlayerName)
                .fillDateField(newDate)
                .clickOnConfirmButton()
                .navigateToPlayerListPage()
                .clickOnPlayer(newPlayerName)
                .checkCorrectTextInFields(newDate, newPlayerName)
                .fillNameField(editPlayerName)
                .clickOnConfirmButton()
                .navigateToPlayerListPage()
                .clickOnPlayer(editPlayerName)
                .checkCorrectTextInFields(newDate, editPlayerName)
                .clickOnDeleteButton()
                .clickOnConfirmDeleteButton()
                .navigateToPlayerListPage();
        Assert.assertFalse(playerListPage.isPlayerDisplayed(editPlayerName), "Je očekáváno že nebude zobrazen smazaný hráč " + editPlayerName);
    }

    @Test
    public void addEditDeletePlayerWithInitDateTest() {
        RandomStringGenerator random = new RandomStringGenerator();
        String newPlayerName = random.getRandomName();
        CalendarDateTranslator calendarDateTranslator = new CalendarDateTranslator();
        LocalDate newDate = random.getRandomDate();
        LocalDate initPlayerDate = calendarDateTranslator.getInitPlayerDate();
        LoginPage loginPage = new LoginPage(driver);
        PlayerListPage playerListPage = loginPage
                .loginToHomePage()
                .navigateToAddPlayerPage()
                .fillNameField(newPlayerName)
                .clickOnConfirmButton()
                .navigateToPlayerListPage()
                .clickOnPlayer(newPlayerName)
                .checkCorrectTextInFields(initPlayerDate, newPlayerName)
                .fillDateField(newDate)
                .clickOnConfirmButton()
                .navigateToPlayerListPage()
                .clickOnPlayer(newPlayerName)
                .checkCorrectTextInFields(newDate, newPlayerName)
                .clickOnDeleteButton()
                .clickOnConfirmDeleteButton()
                .navigateToPlayerListPage();
        Assert.assertFalse(playerListPage.isPlayerDisplayed(newPlayerName), "Je očekáváno že nebude zobrazen smazaný hráč " + newPlayerName);
    }
}

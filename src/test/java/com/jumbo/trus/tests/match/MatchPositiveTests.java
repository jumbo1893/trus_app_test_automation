package com.jumbo.trus.tests.match;

import com.jumbo.trus.pages.login.LoginPage;
import com.jumbo.trus.pages.main.match.AddMatchPage;
import com.jumbo.trus.pages.main.match.MatchListPage;
import com.jumbo.trus.pages.main.player.PlayerListPage;
import com.jumbo.trus.pages.main.season.AddSeasonPage;
import com.jumbo.trus.tests.BaseClass;
import com.jumbo.trus.util.CalendarDateTranslator;
import com.jumbo.trus.util.RandomStringGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class MatchPositiveTests extends BaseClass {

    @Test
    public void addEditDeleteMatchWithAutomaticSeasonTest() {
        RandomStringGenerator random = new RandomStringGenerator();
        String newMatchName = random.getRandomName();
        String newMatchFullName = "Liščí Trus - " + newMatchName;
        LocalDate newDate = LocalDate.of(2023, 3, 3);
        LocalDate editDate = random.getRandomDate();
        String editMatchName = random.getRandomName();
        String editMatchFullName = "Liščí Trus - " + editMatchName;
        LoginPage loginPage = new LoginPage(driver);
        MatchListPage matchListPage = loginPage
                .loginToHomePage()
                .navigateToAddMatchPage()
                .fillNameField(newMatchName)
                .fillDateField(newDate)
                .setPlayer(AddMatchPage.EXISTING_MATCH_PLAYER, true)
                .setPlayer("Anti", false)
                .clickOnConfirmButton()
                .navigateToMatchListPage()
                .setSeason("Všechny sezony")
                .clickOnMatch("newMatchFullName")
                .checkCorrectTextInFields(newDate, newMatchName)
                .checkCorrectSeason("Jaro 2023")
                .fillNameField(editMatchName)
                .fillDateField(editDate)
                .setPlayer("Anti", false)
                .clickOnConfirmButton()
                .navigateToMatchListPage()
                .setSeason("Všechny sezony")
                .clickOnMatch(editMatchFullName)
                .checkCorrectTextInFields(editDate, editMatchName)
                .checkCorrectSeason("Jaro 2023")
                .clickOnDeleteButton()
                .clickOnConfirmDeleteButton()
                .navigateToMatchListPage();
        Assert.assertFalse(matchListPage.isMatchDisplayed(editMatchFullName), "Je očekáváno že nebude zobrazen smazaný zápas " + editMatchName);
    }

    @Test
    public void addEditDeleteMatchCustomSeasonTest() {
        RandomStringGenerator random = new RandomStringGenerator();
        String newMatchName = random.getRandomName();
        LocalDate newDate = random.getRandomDate();
        LocalDate editDate = random.getRandomDate();
        String editMatchName = random.getRandomName();
        LoginPage loginPage = new LoginPage(driver);
        MatchListPage matchListPage = loginPage
                .loginToHomePage()
                .navigateToAddMatchPage()
                .fillNameField(newMatchName)
                .fillDateField(newDate)
                .setSeason("Jaro 2023")
                .setPlayer(AddMatchPage.EXISTING_MATCH_PLAYER, true)
                .setPlayer("Anti", false)
                .clickOnConfirmButton()
                .navigateToMatchListPage()
                .setSeason("Všechny sezony")
                .clickOnMatch("Liščí Trus - " + newMatchName)
                .checkCorrectTextInFields(newDate, newMatchName)
                .checkCorrectSeason(AddSeasonPage.EXISTING_SEASON)
                .fillNameField(editMatchName)
                .fillDateField(editDate)
                .setSeason("Podzim 2023")
                .clickOnConfirmButton()
                .navigateToMatchListPage()
                .setSeason("Podzim 2023")
                .clickOnMatch("Liščí Trus - " + editMatchName)
                .checkCorrectTextInFields(editDate, editMatchName)
                .checkCorrectSeason("Podzim 2023")
                .clickOnDeleteButton()
                .clickOnConfirmDeleteButton()
                .navigateToMatchListPage();
        Assert.assertFalse(matchListPage.isMatchDisplayed(editMatchName), "Je očekáváno že nebude zobrazen smazaný zápas " + editMatchName);
    }

    @Test
    public void addEditDeleteMatchAutomaticOtherSeasonTest() {
        RandomStringGenerator random = new RandomStringGenerator();
        String newMatchName = random.getRandomName();
        LocalDate newDate = random.getRandomDateForSeasonStart();
        LocalDate editDate = random.getRandomDate();
        String editMatchName = random.getRandomName();
        LoginPage loginPage = new LoginPage(driver);
        MatchListPage matchListPage = loginPage
                .loginToHomePage()
                .navigateToAddMatchPage()
                .fillNameField(newMatchName)
                .fillDateField(newDate)
                .setPlayer(AddMatchPage.EXISTING_MATCH_PLAYER, true)
                .setPlayer("Anti", false)
                .clickOnConfirmButton()
                .navigateToMatchListPage()
                .setSeason("Všechny sezony")
                .clickOnMatch(newMatchName)
                .checkCorrectTextInFields(newDate, newMatchName)
                .checkCorrectSeason("Ostatní")
                .fillNameField(editMatchName)
                .fillDateField(editDate)
                .clickOnConfirmButton()
                .navigateToMatchListPage()
                .setSeason("Všechny sezony")
                .clickOnMatch(editMatchName)
                .checkCorrectTextInFields(editDate, editMatchName)
                .checkCorrectSeason("Ostatní")
                .clickOnDeleteButton()
                .clickOnConfirmDeleteButton()
                .navigateToMatchListPage();
        Assert.assertFalse(matchListPage.isMatchDisplayed(editMatchName), "Je očekáváno že nebude zobrazen smazaný zápas " + editMatchName);
    }
}

package com.jumbo.trus.tests.season;

import com.jumbo.trus.pages.login.LoginPage;
import com.jumbo.trus.pages.main.season.AddSeasonPage;
import com.jumbo.trus.tests.BaseClass;
import com.jumbo.trus.util.RandomStringGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class SeasonNegativeTests extends BaseClass {

    @Test
    public void addSeasonWithoutNameTest() {
        LoginPage loginPage = new LoginPage(driver);
        AddSeasonPage addSeasonPage = loginPage
                .loginToHomePage()
                .navigateToAddSeasonPage()
                .clickOnConfirmButton();
        Assert.assertTrue(addSeasonPage.isSeasonNameFieldErrorTextDisplayed(), "Je očekávána chyba toto musíš vyplnit");
    }

    @Test
    public void editSeasonWithoutNameTest() {
        LoginPage loginPage = new LoginPage(driver);
        AddSeasonPage addSeasonPage = loginPage
                .loginToHomePage()
                .navigateToSeasonListPage()
                .clickOnSeason(AddSeasonPage.EXISTING_SEASON)
                .cleanNameField()
                .clickOnConfirmButton();
        Assert.assertTrue(addSeasonPage.isSeasonNameFieldErrorTextDisplayed(), "Je očekávána chyba toto musíš vyplnit");
    }

    @Test
    public void addSeasonWithOlderStartDate() {
        RandomStringGenerator random = new RandomStringGenerator();
        String newSeasonName = random.getRandomName();
        LocalDate startDate = LocalDate.of(2010, 1, 1);
        LocalDate endDate = LocalDate.of(2009, 12, 31);
        LoginPage loginPage = new LoginPage(driver);
        AddSeasonPage addSeasonPage = loginPage
                .loginToHomePage()
                .navigateToAddSeasonPage()
                .fillNameField(newSeasonName)
                .fillStartDateField(startDate)
                .fillEndDateField(endDate)
                .clickOnConfirmButton();
        Assert.assertTrue(addSeasonPage.isSeasonOlderStartDateErrorTextDisplayed(), "Je očekávána chyba Konečné datum musí být starší než počáteční");
    }

    @Test
    public void addSeasonWithSeasonCollision() {
        RandomStringGenerator random = new RandomStringGenerator();
        String newSeasonName = random.getRandomName();
        LoginPage loginPage = new LoginPage(driver);
        AddSeasonPage addSeasonPage = loginPage
                .loginToHomePage()
                .navigateToAddSeasonPage()
                .fillNameField(newSeasonName)
                .fillStartDateField(AddSeasonPage.EXISTING_SEASON_START_DATE)
                .fillEndDateField(AddSeasonPage.EXISTING_SEASON_END_DATE)
                .clickOnConfirmButton();
        Assert.assertTrue(addSeasonPage.isSeasonCollisionErrorTextDisplayed(), "Je očekávána chyba Datum se kryje se sezonou ");
    }
}

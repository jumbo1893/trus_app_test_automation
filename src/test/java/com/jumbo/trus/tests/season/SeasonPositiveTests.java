package com.jumbo.trus.tests.season;

import com.jumbo.trus.pages.login.LoginPage;
import com.jumbo.trus.pages.main.season.AddSeasonPage;
import com.jumbo.trus.pages.main.season.SeasonListPage;
import com.jumbo.trus.tests.BaseClass;
import com.jumbo.trus.util.RandomStringGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class SeasonPositiveTests extends BaseClass {

    @Test
    public void addEditDeleteSeason() {
        RandomStringGenerator random = new RandomStringGenerator();
        String newSeasonName = random.getRandomName();
        String editSeasonName = random.getRandomName();
        LocalDate newStartDate = random.getRandomDateForSeasonStart();
        LocalDate newEndDate = random.getRandomDateForSeasonEnd();
        LocalDate editStartDate = random.getRandomDateForSeasonStart();
        LocalDate editEndDate = random.getRandomDateForSeasonEnd();
        LoginPage loginPage = new LoginPage(driver);
        SeasonListPage seasonListPage = loginPage
                .loginToHomePage()
                .navigateToAddSeasonPage()
                .fillNameField(newSeasonName)
                .fillStartDateField(newStartDate)
                .fillEndDateField(newEndDate)
                .clickOnConfirmButton()
                .navigateToSeasonListPage()
                .clickOnSeason(newSeasonName)
                .checkCorrectTextInFields(newStartDate, newEndDate, newSeasonName)
                .fillNameField(editSeasonName)
                .fillStartDateField(editStartDate)
                .fillEndDateField(editEndDate)
                .clickOnConfirmButton()
                .navigateToSeasonListPage()
                .clickOnSeason(editSeasonName)
                .checkCorrectTextInFields(editStartDate, editEndDate, editSeasonName)
                .clickOnDeleteButton()
                .clickOnConfirmDeleteButton()
                .navigateToSeasonListPage();
        Assert.assertFalse(seasonListPage.isSeasonDisplayed(editSeasonName), "Je očekáváno že nebude zobrazena smazaná sezona " + editSeasonName);
    }
}

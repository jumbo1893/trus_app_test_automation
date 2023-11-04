package com.jumbo.trus.pages.main.season;

import com.jumbo.trus.pages.main.MainPage;
import com.jumbo.trus.pages.main.player.AddPlayerPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.LocalDate;

public class AddSeasonPage extends MainPage {

    public static final String EXISTING_SEASON = "Automation season";

    public static final LocalDate EXISTING_SEASON_START_DATE = LocalDate.of(1990, 1,1);

    public static final LocalDate EXISTING_SEASON_END_DATE = LocalDate.of(1991, 12,31);

    public AddSeasonPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    private WebElement getNameField() {
        return waitFor(find.byValueKey("season_name_field_text"));
    }

    private WebElement getNameFieldButton() {
        return waitFor(find.byValueKey("season_name_field_text_button"));
    }

    private WebElement getStartDateField() {
        return waitFor(find.byValueKey("season_start_date_field_text"));
    }

    private WebElement getStartDateFieldButton() {
        return waitFor(find.byValueKey("season_start_date_field_text_button"));
    }

    private WebElement getEndDateField() {
        return waitFor(find.byValueKey("season_end_date_field_text"));
    }

    private WebElement getEndDateFieldButton() {
        return waitFor(find.byValueKey("season_end_date_field_text_button"));
    }

    private WebElement getConfirmButton() {
        return waitFor(find.byValueKey("confirm_button"));
    }

    private WebElement getDeleteButton() {
        return waitFor(find.byValueKey("delete_button"));
    }

    public AddSeasonPage fillNameField(String name) {
        getNameField().sendKeys(name);
        return this;
    }

    public AddSeasonPage cleanNameField() {
        getNameFieldButton().click();
        return this;
    }

    public AddSeasonPage fillStartDateField(LocalDate date) {
        getStartDateFieldButton().click();
        setCalendarDate(date.getDayOfMonth(), date.getMonthValue(), date.getYear());
        return this;
    }

    public AddSeasonPage fillEndDateField(LocalDate date) {
        getEndDateFieldButton().click();
        setCalendarDate(date.getDayOfMonth(), date.getMonthValue(), date.getYear());
        return this;
    }

    public AddSeasonPage clickOnConfirmButton() {
        getConfirmButton().click();
        return this;
    }

    public AddSeasonPage clickOnDeleteButton() {
        getDeleteButton().click();
        return this;
    }

    public boolean isSeasonNameFieldDisplayed() {
        return isElementDisplayed(find.byValueKey("season_name_field_text"), 15000);
    }

    public boolean isSeasonNameFieldErrorTextDisplayed() {
        return isTextDisplayed("toto musíš vyplnit");
    }

    public boolean isSeasonOlderStartDateErrorTextDisplayed() {
        return isTextDisplayed("Konečné datum musí být starší než počáteční");
    }

    public boolean isSeasonCollisionErrorTextDisplayed() {
        return isTextDisplayed("Datum se kryje se sezonou " + EXISTING_SEASON);
    }

    public AddSeasonPage checkCorrectTextInFields(LocalDate startDate, LocalDate endDate, String seasonName) {
        Assert.assertTrue(isCalendarTextDisplayed(startDate), "Je očekáváno zobrazení datumu " + startDate.getDayOfMonth() + "." + startDate.getMonthValue() +  ". " + startDate.getYear() + " při editaci/přidání sezony");
        Assert.assertTrue(isCalendarTextDisplayed(endDate), "Je očekáváno zobrazení datumu " + endDate.getDayOfMonth() + "." + endDate.getMonthValue() +  ". " + endDate.getYear() + " při editaci/přidání sezony");
        Assert.assertTrue(isTextDisplayed(seasonName), "Je očekáváno jméno sezony " + seasonName + " zvoleného při přidání/editai");
        return this;
    }
}

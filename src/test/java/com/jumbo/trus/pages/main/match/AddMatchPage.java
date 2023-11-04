package com.jumbo.trus.pages.main.match;

import com.jumbo.trus.pages.main.MainPage;
import com.jumbo.trus.pages.main.season.AddSeasonPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.LocalDate;

public class AddMatchPage extends MainPage {

    public static final String EXISTING_MATCH = "Liščí Trus - Automation match";

    public static final String EXISTING_MATCH_PLAYER = "Automation player";

    public AddMatchPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    private WebElement getNameField() {
        return waitFor(find.byValueKey("match_name_field_text"));
    }

    private WebElement getNameFieldButton() {
        return waitFor(find.byValueKey("match_name_field_text_button"));
    }

    private WebElement getDateField() {
        return waitFor(find.byValueKey("match_date_field_text"));
    }

    private WebElement getDateFieldButton() {
        return waitFor(find.byValueKey("match_date_field_text_button"));
    }

    private WebElement getHomeField() {
        return waitFor(find.byValueKey("match_home_field_switch"));
    }

    private WebElement getSeasonField() {
        return waitFor(find.byValueKey("match_season_field_text"));
    }

    private WebElement getSeasonFieldButton() {
        return waitFor(find.byValueKey("match_season_field_dropdown"));
    }

    private WebElement getConfirmButton() {
        return waitFor(find.byValueKey("confirm_button"));
    }

    private WebElement getDeleteButton() {
        return waitFor(find.byValueKey("delete_button"));
    }

    private WebElement getSeasonItems() {
        return waitFor(find.byValueKey("season_items"));
    }

    private WebElement getPlayerFromList(String seasonName, boolean player) {
        return scrollHorizontallyUntilVisibleByText(find.byValueKey(player ? "match_player_field" : "match_fan_field"), seasonName);
    }

    private AddMatchPage clickDateButton() {
        getDateFieldButton().click();
        return this;
    }

    private AddMatchPage clickSeason() {
        getSeasonField().click();
        return this;
    }

    public AddMatchPage fillNameField(String name) {
        getNameField().sendKeys(name);
        return this;
    }

    public AddMatchPage cleanNameField() {
        getNameFieldButton().click();
        return this;
    }

    public AddMatchPage clickOnConfirmButton() {
        getConfirmButton().click();
        return this;
    }

    public AddMatchPage clickOnDeleteButton() {
        getDeleteButton().click();
        return this;
    }

    public AddMatchPage fillDateField(LocalDate date) {
        getDateFieldButton().click();
        setCalendarDate(date.getDayOfMonth(), date.getMonthValue(), date.getYear());
        return this;
    }

    public AddMatchPage setSeason(String seasonName) {
        getSeasonFieldButton().click();
        WebElement season = scrollUntilVisibleByText(find.byType("Scrollable"), seasonName);
        if (season == null) {
            Assert.fail("Sezona " + seasonName + " nenalezena");
        }
        season.click();
        return this;
    }

    public AddMatchPage setPlayer(String playerName, boolean player) {
        WebElement foundPlayer = getPlayerFromList(playerName, player);
        if (foundPlayer == null) {
            Assert.fail("Hráč " + playerName + " nenalezen");
        }
        foundPlayer.click();
        return this;
    }

    public boolean isMatchNameFieldDisplayed() {
        return isElementDisplayed(find.byValueKey("match_name_field_text"), 15000);
    }

    public boolean isMatchNameFieldErrorTextDisplayed() {
        return isTextDisplayed("toto musíš vyplnit");
    }

    public boolean isPlayersMissingErrorDisplayed() {
        return isTextDisplayed("musí být označen aspoň jeden hráč");
    }

    public AddMatchPage checkCorrectTextInFields(LocalDate date, String matchName) {
        Assert.assertTrue(isCalendarTextDisplayed(date), "Je očekáváno zobrazení datumu " + date.getDayOfMonth() + "." + date.getMonthValue() +  ". " + date.getYear() + " při přidání/editaci zápasu");
        Assert.assertTrue(isTextDisplayed(matchName), "Je očekáváno jméno zápasu " + matchName + " zvoleného při přidání/editaci");
        return this;
    }

    public AddMatchPage checkCorrectSeason(String seasonName) {
        Assert.assertTrue(isTextDisplayed(seasonName), "Je očekáváno jméno sezony " + seasonName + " zvoleného při přidání/editaci");
        return this;
    }
}

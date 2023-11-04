package com.jumbo.trus.pages.main.player;

import com.jumbo.trus.pages.main.MainPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.time.LocalDate;

public class AddPlayerPage extends MainPage {

    public static final String EXISTING_PLAYER = "Automation player";

    public AddPlayerPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    private WebElement getNameField() {
        return waitFor(find.byValueKey("player_name_field_text"));
    }

    private WebElement getNameFieldButton() {
        return waitFor(find.byValueKey("player_name_field_text_button"));
    }

    private WebElement getNameFieldRow() {
        return waitFor(find.byValueKey("player_name_field"));
    }

    private WebElement getDateField() {
        return waitFor(find.byValueKey("player_date_field_text"));
    }

    private WebElement getDateFieldButton() {
        return waitFor(find.byValueKey("player_date_field_text_button"));
    }

    private WebElement getFanField() {
        return waitFor(find.byValueKey("player_fan_field_switch"));
    }

    private WebElement getActiveField() {
        return waitFor(find.byValueKey("player_active_field_switch"));
    }

    private WebElement getConfirmButton() {
        return waitFor(find.byValueKey("confirm_button"));
    }

    private WebElement getDeleteButton() {
        return waitFor(find.byValueKey("delete_button"));
    }

    private AddPlayerPage clickDateButton() {
        getDateFieldButton().click();
        return this;
    }

    public AddPlayerPage fillNameField(String name) {
        getNameField().sendKeys(name);
        return this;
    }

    public AddPlayerPage cleanNameField() {
        getNameFieldButton().click();
        return this;
    }

    public AddPlayerPage clickOnConfirmButton() {
        getConfirmButton().click();
        return this;
    }

    public AddPlayerPage clickOnDeleteButton() {
        getDeleteButton().click();
        return this;
    }

    public AddPlayerPage fillDateField(LocalDate date) {
        getDateFieldButton().click();
        setCalendarDate(date.getDayOfMonth(), date.getMonthValue(), date.getYear());
        return this;
    }

    public boolean isPlayerNameFieldDisplayed() {
        return isElementDisplayed(find.byValueKey("player_name_field_text"), 15000);
    }

    public boolean isPlayerNameFieldErrorTextDisplayed() {
        return isTextDisplayed("toto musíš vyplnit");
    }

    public AddPlayerPage checkCorrectTextInFields(LocalDate date, String playerName) {
        Assert.assertTrue(isCalendarTextDisplayed(date), "Je očekáváno zobrazení datumu " + date.getDayOfMonth() + "." + date.getMonthValue() +  ". " + date.getYear() + " při přidání/editaci hráče");
        Assert.assertTrue(isTextDisplayed(playerName), "Je očekáváno jména hráče " + playerName + " zvoleného při přidání");
        return this;
    }
}

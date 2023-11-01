package com.jumbo.trus.pages.main.player;

import com.jumbo.trus.pages.main.MainPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.reporters.jq.Main;

public class AddPlayerPage extends MainPage {

    public static final String EXISTING_PLAYER = "Automation player";

    public AddPlayerPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    private WebElement getNameField() {
        return waitFor(find.byValueKey("player_name_field_text"));
    }

    private WebElement getNameFieldButton() {
        return waitFor(find.byValueKey("player_name_field_button"));
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

    private WebElement getDeleteConfirmButton() {
        return waitFor(find.byText("OK"));
    }

    public AddPlayerPage fillNameField(String name) {
        getNameField().sendKeys(name);
        return this;
    }

    public AddPlayerPage cleanNameField() {
        getNameFieldButton().click();
        return this;
    }

    public AddPlayerPage clickDateButton() {
        getDateFieldButton().click();
        return this;
    }

    public MainPage clickOnConfirmButton() {
        getConfirmButton().click();
        return this;
    }

    public AddPlayerPage clickOnDeleteButton() {
        getDeleteButton().click();
        return this;
    }

    public AddPlayerPage clickOnConfirmDeleteButton() {
        getDeleteConfirmButton().click();
        return this;
    }

    public AddPlayerPage fillDateField(String name) {
        getNameField().sendKeys(name);
        return this;
    }

    public boolean isPlayerNameFieldDisplayed() {
        return isElementDisplayed(find.byValueKey("player_name_field_text"), 15000);
    }

    public boolean isPlayerNameFieldErrorTextDisplayed() {
        return isTextDisplayed("toto musíš vyplnit");
    }
}

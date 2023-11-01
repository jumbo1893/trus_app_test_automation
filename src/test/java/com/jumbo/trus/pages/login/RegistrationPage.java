package com.jumbo.trus.pages.login;

import com.jumbo.trus.pages.BasePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends BasePage {

    public static final String VALID_MAIL = "valid_user@seznam.cz";
    public static final String PASSWORD = "password";
    public static final String INVALID_MAIL = "invalidUser@mail";
    public static final String USED_MAIL = "used_mail@seznam.cz";

    public static final String WEAK_PASSWORD = "a";


    public RegistrationPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    private WebElement getEmailField() {
       return waitFor(find.byValueKey("email_text_field"));
    }

    private WebElement getPasswordField() {
        return waitFor(find.byValueKey("password_text_field"));
    }

    private WebElement getRegistrationButton() {
        return waitFor(find.byValueKey("confirm_button"));
    }

    public RegistrationPage fillLoginName(String name) {
        getEmailField().sendKeys(name);
        return this;
    }

    public RegistrationPage fillPassword(String password) {
        getPasswordField().sendKeys(password);
        return this;
    }

    public UserInformationPage clickRegistrationPositive() {
        getRegistrationButton().click();
        return new UserInformationPage(driver);
    }

    public RegistrationPage clickRegistrationNegative() {
        getRegistrationButton().click();
        return this;
    }

    public UserInformationPage positiveSignUp(String name, String password) {
        fillLoginName(name);
        fillPassword(password);
        return clickRegistrationPositive();
    }

    public RegistrationPage negativeSignUp(String name, String password) {
        fillLoginName(name);
        fillPassword(password);
        return clickRegistrationNegative();
    }

    public boolean isAlreadyUsedMailMessageDisplayed() {
        return isTextDisplayed("Na tento mail se již někdo zaregistroval");
    }

    public boolean isWeakPasswordMessageDisplayed() {
        return isTextDisplayed("Moc slabý heslo, zadej takový aby vyhovovalo googlu");
    }

    public boolean isNoLoginDisplayed() {
        return isTextDisplayed("toto musíš vyplnit");
    }

    public boolean isNoPasswordDisplayed() {
        return isTextDisplayed("toto musíš vyplnit");
    }

    public boolean isInvalidMailFormatDisplayed() {
        return isTextDisplayed("Email není ve správném formátu");
    }

    public boolean isEmailFieldDisplayed() {
        return isElementDisplayed(find.byValueKey("email_text_field"), 5000);
    }

}

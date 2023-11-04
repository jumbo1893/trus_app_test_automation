package com.jumbo.trus.pages.login;

import com.jumbo.trus.pages.BasePage;
import com.jumbo.trus.pages.main.home.HomePage;
import com.jumbo.trus.pages.main.season.AddSeasonPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static org.testng.Assert.assertTrue;

public class LoginPage extends BasePage {

    public static final String VALID_USER = "automat_admin@mail.com";
    public static final String VALID_USER_PASSWORD = "Heslo12!";
    public static final String VALID_USER_NAME = "admin";
    public static final String INVALID_USER = "invalid_user@mail.com";
    public static final String INVALID_PASSWORD = "invalid_password";
    public static final String INVALID_FORMAT_USER = "a_a@";
    public static final String FORGOTTEN_PASSWORD_USER = "read_user@mail.com";


    public LoginPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    private WebElement getEmailField() {
       return waitFor(find.byValueKey("email_text_field"));
    }

    private WebElement getPasswordField() {
        return waitFor(find.byValueKey("password_text_field"));
    }

    private WebElement getRegistrationButton() {
        return waitFor(find.byValueKey("registration_button"));
    }

    private WebElement getLoginButton() {
        return waitFor(find.byValueKey("login_button"));
    }

    private WebElement getForgottenPasswordButton() {
        return waitFor(find.byValueKey("forgotten_password_button"));
    }

    private WebElement getLogoImage() {
        return waitFor(find.byValueKey("logo_image"));
    }

    public LoginPage fillLoginName(String name) {
        getEmailField().sendKeys(name);
        return this;
    }

    public LoginPage fillPassword(String password) {
        getPasswordField().sendKeys(password);
        return this;
    }

    public LoginPage clickLoginNegative() {
        getLoginButton().click();
        return this;
    }

    public HomePage clickLoginPositive() {
        getLoginButton().click();
        return new HomePage(driver);
    }

    public RegistrationPage clickRegister() {
        getRegistrationButton().click();
        return new RegistrationPage(driver);
    }

    public LoginPage clickForgottenPassword() {
        getForgottenPasswordButton().click();
        return this;
    }

    public LoginPage negativeLogin(String name, String password) {
        return fillLoginName(name).fillPassword(password).clickLoginNegative();
    }

    public HomePage positiveLogin(String name, String password) {
        return fillLoginName(name).fillPassword(password).clickLoginPositive();
    }

    public HomePage loginToHomePage() {
        HomePage homePage = positiveLogin(LoginPage.VALID_USER, LoginPage.VALID_USER_PASSWORD);
        Assert.assertTrue(homePage.isPlusButtonDisplayed(), "Po přihlášení očekáváme HomePage");
        return homePage;
    }

    public RegistrationPage navigateToRegistrationPage() {
        RegistrationPage registrationPage = clickRegister();
        assertTrue(registrationPage.isEmailFieldDisplayed(), "Očekáváme zobrazení RegistrationPage");
        return registrationPage;
    }

    public LoginPage resetPassword(String name) {
        return fillLoginName(name).clickForgottenPassword();
    }

    public boolean isWrongPasswordDisplayed() {
        return isTextDisplayed("Zadal jsi špatné heslo!");
    }

    public boolean isWrongLoginDisplayed() {
        return isTextDisplayed("uživatel nebyl nalezen!");
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

    public boolean isForgottenPasswordSentMessageDisplayed(String mail) {
        return isTextDisplayed("Na mail " + mail + ", zaslán link pro reset hesla. Stojí tě to přesně jednu rundu");
    }

    public boolean isLogoDisplayed() {
        return isElementDisplayed(find.byValueKey("logo_image"), 20000);
    }

}

package com.jumbo.trus.pages.main.home;

import com.jumbo.trus.pages.main.MainPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends MainPage {

    public HomePage(AppiumDriver<WebElement> driver) {
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

    public void fillLoginName(String name) {
        getEmailField().sendKeys(name);
    }

    public void fillPassword(String password) {
        getPasswordField().sendKeys(password);
    }

    public void clickRegistration() {
        getRegistrationButton().click();
    }

    public void signUp(String name, String password) {
        fillLoginName(name);
        fillPassword(password);
        clickRegistration();
    }

    public boolean isSnackBarWrongPasswordDisplayed() {
        return isTextDisplayed("Špatné heslo");
    }

}

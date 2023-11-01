package com.jumbo.trus.pages.login;

import com.jumbo.trus.pages.BasePage;
import com.jumbo.trus.pages.main.home.HomePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class UserInformationPage extends BasePage {

    public UserInformationPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    private WebElement getNameField() {
       return waitFor(find.byValueKey("name_text_field"));
    }

    private WebElement getRegistrationButton() {
        return waitFor(find.byValueKey("confirm_button"));
    }

    public UserInformationPage fillLoginName(String name) {
        getNameField().sendKeys(name);
        return this;
    }

    public HomePage clickRegistration() {
        getRegistrationButton().click();
        return new HomePage(driver);
    }

    public HomePage finishSignUp(String name) {
        return fillLoginName(name).clickRegistration();
    }

    public boolean isNameFieldDisplayed() {
        return isElementDisplayed(getNameField());
    }
}

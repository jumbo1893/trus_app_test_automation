package com.jumbo.trus.pages.login;

import com.jumbo.trus.pages.BasePage;
import com.jumbo.trus.pages.main.home.HomePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

import static org.testng.Assert.assertTrue;

public class UserInformationPage extends BasePage {

    public UserInformationPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    private WebElement nameField() {
        return find.byValueKey("name_text_field");
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
        HomePage homePage = fillLoginName(name).clickRegistration();
        assertTrue(homePage.isPlusButtonDisplayed(), "Očekáváme zobrazení HomePage");
        return homePage;
    }

    public boolean isNameFieldDisplayed() {
        return isElementDisplayed(nameField());
    }
}

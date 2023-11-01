package com.jumbo.trus.tests.login;

import com.jumbo.trus.pages.login.LoginPage;
import com.jumbo.trus.pages.login.RegistrationPage;
import com.jumbo.trus.pages.login.UserInformationPage;
import com.jumbo.trus.pages.main.MainPage;
import com.jumbo.trus.pages.main.home.HomePage;
import com.jumbo.trus.tests.BaseClass;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

public class PositiveRegistrationTests extends BaseClass {


    //positive registration tests

    @Test
    public void registrationTest() {
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage registrationPage = loginPage.clickRegister();
        assertTrue(registrationPage.isEmailFieldDisplayed(), "Očekáváme zobrazení RegistrationPage");
        UserInformationPage userPage = registrationPage.positiveSignUp(LoginPage.VALID_USER, LoginPage.VALID_USER_PASSWORD);
        assertTrue(userPage.isNameFieldDisplayed(), "Očekáváme zobrazení UserPage");
        HomePage homePage = userPage.finishSignUp(getNewUserName());
        assertTrue(homePage.isPlusButtonDisplayed(), "Očekáváme zobrazení HomePage");
    }

    public String getNewUserName() {
        return "automat admin";
        //return "test" + System.currentTimeMillis();
    }
}

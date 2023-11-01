package com.jumbo.trus.tests.login;

import com.jumbo.trus.pages.login.LoginPage;
import com.jumbo.trus.pages.login.RegistrationPage;
import com.jumbo.trus.tests.BaseClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class NegativeRegistrationTests extends BaseClass {


    @Test
    public void invalidRegistrationTest() {
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage nextPage = loginPage.clickRegister()
                .negativeSignUp(LoginPage.VALID_USER, LoginPage.VALID_USER_PASSWORD);
        assertTrue(nextPage.isAlreadyUsedMailMessageDisplayed(), "Měla se zobrazit chyba o již použitém mailu");
    }

    @Test
    public void invalidRegistrationWeakPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage nextPage = loginPage.clickRegister()
                .negativeSignUp(getNewUserEmail(), RegistrationPage.WEAK_PASSWORD);
        assertTrue(nextPage.isWeakPasswordMessageDisplayed(), "Očekáváme chybovou zprávu o slabém hesle");
    }

    @Test
    public void noNameRegistrationTest() {
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage nextPage = loginPage.clickRegister().fillPassword(LoginPage.VALID_USER_PASSWORD).clickRegistrationNegative();
        assertTrue(nextPage.isNoLoginDisplayed(), "Měla se zobrazit chyba s chybějícím loginem");
    }

    @Test
    public void noPasswordRegistrationTest() {
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage nextPage = loginPage.clickRegister().fillLoginName(getNewUserEmail()).clickRegistrationNegative();
        assertTrue(nextPage.isNoPasswordDisplayed(), "Měla se zobrazit chyba s chybějícím heslem");
    }

    @Test
    public void invalidMailFormatLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        RegistrationPage nextPage = loginPage.clickRegister().negativeSignUp(LoginPage.INVALID_FORMAT_USER, LoginPage.VALID_USER_PASSWORD);
        assertTrue(nextPage.isInvalidMailFormatDisplayed(), "Měla se zobrazit chyba s vadným formátem mailu");
    }

    public String getNewUserEmail() {
        return "test" + System.currentTimeMillis() + "@gmail.com";
    }
}

package com.jumbo.trus.tests.login;

import com.jumbo.trus.pages.login.LoginPage;
import com.jumbo.trus.tests.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ForgottenPasswordTests extends BaseClass {

    //negative tests

    @Test
    public void unregisteredUserForgottenPasswordTest() {
        LoginPage loginPage = new LoginPage(driver)
                .resetPassword(LoginPage.INVALID_USER);
        assertTrue(loginPage.isWrongLoginDisplayed(), "Měla se zobrazit chyba o chybném loginu");
    }

    @Test
    public void unfilledUserForgottenPasswordTest() {
        LoginPage loginPage = new LoginPage(driver)
                .clickForgottenPassword();
        assertTrue(loginPage.isNoLoginDisplayed(), "Měla se zobrazit chyba o nevyplněném loginu");
    }

    @Test
    public void invalidMailFormatForgottenPasswordTest() {
        LoginPage loginPage = new LoginPage(driver)
                .resetPassword(LoginPage.INVALID_FORMAT_USER);
        assertTrue(loginPage.isInvalidMailFormatDisplayed(), "Měla se zobrazit chyba o špatném formátu hesla");
    }

    //positive tests

    @Test
    public void resetPasswordTest() {
        LoginPage loginPage = new LoginPage(driver)
                .resetPassword(LoginPage.FORGOTTEN_PASSWORD_USER);
        Assert.assertTrue(loginPage.isForgottenPasswordSentMessageDisplayed(LoginPage.FORGOTTEN_PASSWORD_USER), "Měla se zobrazit zpráva o zaslání nového hesla");
    }
}

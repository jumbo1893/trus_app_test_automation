package com.jumbo.trus.tests.login;

import com.jumbo.trus.pages.login.LoginPage;
import com.jumbo.trus.tests.BaseClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class NegativeLoginTests extends BaseClass {


    @Test
    public void invalidLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.negativeLogin(LoginPage.INVALID_USER, LoginPage.VALID_USER_PASSWORD);
        assertTrue(loginPage.isWrongLoginDisplayed(), "Měla se zobrazit chyba s chybným loginem");
    }

    @Test
    public void invalidPasswordTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.negativeLogin(LoginPage.VALID_USER, LoginPage.INVALID_PASSWORD);
        assertTrue(loginPage.isWrongPasswordDisplayed(), "Měla se zobrazit chyba se špatným heslem");
    }

    @Test
    public void noLoginNameTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillPassword("password").clickLoginNegative();
        assertTrue(loginPage.isNoLoginDisplayed(), "Měla se zobrazit chyba s chybějícím loginem");
    }

    @Test
    public void noPasswordLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginName(LoginPage.VALID_USER).clickLoginNegative();
        assertTrue(loginPage.isNoPasswordDisplayed(), "Měla se zobrazit chyba s chybějícím heslem");
    }

    @Test
    public void invalidMailFormatLoginTest() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.negativeLogin(LoginPage.INVALID_FORMAT_USER, LoginPage.VALID_USER_PASSWORD);
        assertTrue(loginPage.isInvalidMailFormatDisplayed(), "Měla se zobrazit chyba s vadným formátem mailu");
    }
}

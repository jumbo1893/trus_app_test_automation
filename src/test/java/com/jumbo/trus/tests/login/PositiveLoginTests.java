package com.jumbo.trus.tests.login;

import com.jumbo.trus.pages.BasePage;
import com.jumbo.trus.pages.login.LoginPage;
import com.jumbo.trus.pages.main.MainPage;
import com.jumbo.trus.pages.main.home.HomePage;
import com.jumbo.trus.tests.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginTests extends BaseClass {


    //Positive login tests

    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage nextPage = loginPage.positiveLogin(LoginPage.VALID_USER, LoginPage.VALID_USER_PASSWORD);
        Assert.assertTrue(nextPage.isPlusButtonDisplayed(), "Po přihlášení očekáváme HomePage");
    }

    @Test
    public void loginTestAndLogoutTest() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage nextPage = loginPage.positiveLogin(LoginPage.VALID_USER, LoginPage.VALID_USER_PASSWORD);
        Assert.assertTrue(nextPage.isPlusButtonDisplayed(), "Po přihlášení očekáváme HomePage");
        nextPage.clickOnBottomMenu().logout();
        Assert.assertTrue(loginPage.isLogoDisplayed(), "Po odhlášení očekáváme přihlašovací obrazovku");
    }
}

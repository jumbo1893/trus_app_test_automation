package com.jumbo.trus.tests.login;

import com.jumbo.trus.pages.login.LoginPage;
import com.jumbo.trus.tests.BaseClass;
import com.jumbo.trus.util.RandomStringGenerator;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class PositiveRegistrationTests extends BaseClass {


    //positive registration tests

    @Test
    public void registrationAndAccountDeleteTest() {
        RandomStringGenerator random = new RandomStringGenerator();
        String newUserName = random.getRandomName();
        String newEmail = newUserName + "@mail.com";
        LoginPage loginPage = new LoginPage(driver);
        loginPage.navigateToRegistrationPage()
                .positiveSignUp(newEmail, LoginPage.VALID_USER_PASSWORD)
                .finishSignUp(newUserName)
                .deleteAccount()
                .negativeLogin(newEmail, LoginPage.VALID_USER_PASSWORD);
        Assert.assertTrue(loginPage.isWrongLoginDisplayed(), "Je očekáváno zobrazení neexistujícího loginu po smazání účtu");
        //přidat smazání
    }
}

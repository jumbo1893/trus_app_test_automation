package com.jumbo.trus.pages.main;

import com.jumbo.trus.pages.BasePage;
import com.jumbo.trus.pages.MatchPage;
import com.jumbo.trus.pages.login.LoginPage;
import com.jumbo.trus.pages.main.player.AddPlayerPage;
import com.jumbo.trus.pages.main.player.PlayerListPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MainPage extends BasePage {


    public MainPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    private WebElement getBeerButton() {
        return waitFor(find.byValueKey("beer_button"));
    }

    private WebElement getPlusButton() {
        return waitFor(find.byValueKey("plus_button"));
    }

    private WebElement getNotificationButton() {
        return waitFor(find.byValueKey("notifications_button"));
    }

    private WebElement getHomeButton() {
        return waitFor(find.byValueKey("home_button"));
    }

    private WebElement getFineButton() {
        return waitFor(find.byValueKey("fine_button"));
    }

    private WebElement getStatsButton() {
        return waitFor(find.byValueKey("stats_button"));
    }

    private WebElement getMenuButton() {
        return waitFor(find.byValueKey("menu_button"));
    }

    private WebElement getLogoutButton() {
        return waitFor(find.byValueKey("logout_button"));
    }

    private WebElement getMenuAddPlayer() {
        return scrollUntilVisible(find.byValueKey("bottom_navigation"), "menu_add_player");
    }

    private WebElement getMenuPlayerList() {
        return scrollUntilVisible(find.byValueKey("bottom_navigation"), "menu_player_list");
    }


    public boolean isPlusButtonDisplayed() {
        return isElementDisplayed(find.byValueKey("plus_button"), 20000);
    }

    private void clickOnMenuItem(WebElement menuItem) {
        if (menuItem == null) {
            Assert.fail("Element v menu nenalezen");
        }
        menuItem.click();
    }

    public MatchPage clickOnAddMatch() {
        getPlusButton().click();
        return new MatchPage(driver);
    }

    public void clickOnAddBeer() {
        getBeerButton().click();
    }

    public MainPage clickOnBottomMenu() {
        getMenuButton().click();
        return this;
    }

    public LoginPage logout() {
        getLogoutButton().click();
        return new LoginPage(driver);
    }

    public AddPlayerPage clickOnAddPlayer() {
        clickOnMenuItem(getMenuAddPlayer());
        return new AddPlayerPage(driver);
    }

    public PlayerListPage clickOnPlayerList() {
        clickOnMenuItem(getMenuPlayerList());
        return new PlayerListPage(driver);
    }

}

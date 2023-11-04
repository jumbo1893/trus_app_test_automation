package com.jumbo.trus.pages.main;

import com.jumbo.trus.pages.BasePage;
import com.jumbo.trus.pages.login.LoginPage;
import com.jumbo.trus.pages.main.match.AddMatchPage;
import com.jumbo.trus.pages.main.match.MatchListPage;
import com.jumbo.trus.pages.main.player.AddPlayerPage;
import com.jumbo.trus.pages.main.player.PlayerListPage;
import com.jumbo.trus.pages.main.season.AddSeasonPage;
import com.jumbo.trus.pages.main.season.SeasonListPage;
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

    private WebElement getMenuSeasonList() {
        return scrollUntilVisible(find.byValueKey("bottom_navigation"), "menu_season");
    }

    private WebElement getMenuAddFine() {
        return scrollUntilVisible(find.byValueKey("bottom_navigation"), "menu_add_fine");
    }

    private WebElement getMenuFineList() {
        return scrollUntilVisible(find.byValueKey("bottom_navigation"), "menu_fine_list");
    }

    private WebElement getMenuAddMatch() {
        return scrollUntilVisible(find.byValueKey("bottom_navigation"), "menu_add_match");
    }

    private WebElement getMenuMatchList() {
        return scrollUntilVisible(find.byValueKey("bottom_navigation"), "menu_match_list");
    }

    private WebElement getMenuDeleteAccount() {
        return scrollUntilVisible(find.byValueKey("bottom_navigation"), "menu_delete_account");
    }

    private WebElement getDeleteConfirmButton() {
        return waitFor(find.byText("OK"));
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
    public void clickOnAddBeer() {
        getBeerButton().click();
    }

    protected MainPage clickOnBottomMenu() {
        getMenuButton().click();
        return this;
    }

    public LoginPage logout() {
        clickOnBottomMenu().getLogoutButton().click();
        return new LoginPage(driver);
    }

    public LoginPage deleteAccount() {
        LoginPage loginPage = clickOnDeleteAccount().clickOnConfirmDeleteButtonForDelete();
        Assert.assertTrue(loginPage.isLogoDisplayed(), "Je očekáváno zobrazení Login page po smazání účtu");
        return loginPage;
    }

    private MainPage clickOnDeleteAccount() {
        clickOnBottomMenu().clickOnMenuItem(getMenuDeleteAccount());
        return this;
    }

    protected AddPlayerPage clickOnAddPlayer() {
        clickOnMenuItem(getMenuAddPlayer());
        return new AddPlayerPage(driver);
    }

    protected PlayerListPage clickOnPlayerList() {
        clickOnMenuItem(getMenuPlayerList());
        return new PlayerListPage(driver);
    }

    protected SeasonListPage clickOnSeasonList() {
        clickOnMenuItem(getMenuSeasonList());
        return new SeasonListPage(driver);
    }

    protected AddSeasonPage clickOnAddFine() {
        clickOnMenuItem(getMenuAddFine());
        return new AddSeasonPage(driver);
    }

    protected SeasonListPage clickOnFineList() {
        clickOnMenuItem(getMenuFineList());
        return new SeasonListPage(driver);
    }

    protected AddMatchPage clickOnAddMatch() {
        clickOnMenuItem(getMenuAddMatch());
        return new AddMatchPage(driver);
    }

    protected MatchListPage clickOnMatchList() {
        clickOnMenuItem(getMenuMatchList());
        return new MatchListPage(driver);
    }

    public AddPlayerPage navigateToAddPlayerPage() {
        AddPlayerPage addPlayerPage = clickOnBottomMenu().clickOnAddPlayer();
        Assert.assertTrue(addPlayerPage.isPlayerNameFieldDisplayed(), "Je očekáváno zobrazení obrazovky pro přidání/editaci hráče");
        return addPlayerPage;
    }

    public PlayerListPage navigateToPlayerListPage() {
        PlayerListPage playerListPage = clickOnBottomMenu().clickOnPlayerList();
        Assert.assertTrue(playerListPage.isPlayerListDisplayed(), "Je očekáváno zobrazení seznamu hráčů");
        return playerListPage;
    }

    public AddSeasonPage navigateToAddSeasonPage() {
        AddSeasonPage addSeasonPage = navigateToSeasonListPage().clickOnAddSeason();
        Assert.assertTrue(addSeasonPage.isSeasonNameFieldDisplayed(), "Je očekáváno zobrazení obrazovky pro přidání/editaci sezony");
        return addSeasonPage;
    }

    public SeasonListPage navigateToSeasonListPage() {
        SeasonListPage seasonListPage = clickOnBottomMenu().clickOnSeasonList();
        Assert.assertTrue(seasonListPage.isSeasonListDisplayed(), "Je očekáváno zobrazení seznamu sezon");
        return seasonListPage;
    }

    public AddMatchPage navigateToAddMatchPage() {
        AddMatchPage addMatchPage = clickOnBottomMenu().clickOnAddMatch();
        Assert.assertTrue(addMatchPage.isMatchNameFieldDisplayed(), "Je očekáváno zobrazení obrazovky pro přidání/editaci hráče");
        return addMatchPage;
    }

    public MatchListPage navigateToMatchListPage() {
        MatchListPage matchListPage = clickOnBottomMenu().clickOnMatchList();
        Assert.assertTrue(matchListPage.isMatchListDisplayed(), "Je očekáváno zobrazení seznamu hráčů");
        return matchListPage;
    }

    private LoginPage clickOnConfirmDeleteButtonForDelete() {
        getDeleteConfirmButton().click();
        return new LoginPage(driver);
    }

    public MainPage clickOnConfirmDeleteButton() {
        getDeleteConfirmButton().click();
        return this;
    }

}

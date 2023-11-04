package com.jumbo.trus.pages.main.match;

import com.jumbo.trus.pages.main.MainPage;
import com.jumbo.trus.pages.main.season.AddSeasonPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class MatchListPage extends MainPage {

    public MatchListPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    private WebElement getMatchList() {
        return waitFor(find.byValueKey("match_list"));
    }

    private WebElement getAddMatchButton() {
        return waitFor(find.byValueKey("add_match_floating_button"));
    }
    private WebElement getMatchFromList(String matchName) {
        return scrollUntilVisibleByText(find.byValueKey("match_screen"), matchName);
    }

    private WebElement getSeasonField() {
        return waitFor(find.byValueKey("season_dropdown"));
    }

    public AddMatchPage clickOnMatch(String matchName) {
        WebElement match = getMatchFromList(matchName);
        if (match == null) {
            Assert.fail("Zápas " + matchName + " nenalezen");
        }
        match.click();
        AddMatchPage addMatchPage = new AddMatchPage(driver);
        Assert.assertTrue(addMatchPage.isMatchNameFieldDisplayed(), "Je očekáváno zobrazení obrazovky pro přidání/editaci sezony");
        return addMatchPage;
    }

    public MatchListPage setSeason(String seasonName) {
        getSeasonField().click();
        WebElement season = scrollUntilVisibleByText(find.byValueKey("season_dropdown"), seasonName);
        if (season == null) {
            Assert.fail("Sezona " + seasonName + " nenalezena");
        }
        season.click();
        return this;
    }

    public AddMatchPage clickOnAddMatchButton() {
        getAddMatchButton().click();
        return new AddMatchPage(driver);
    }

    public boolean isMatchDisplayed(String matchName) {
        WebElement match = getMatchFromList(matchName);
        return match != null;
    }

    public boolean isMatchListDisplayed() {
        return isElementDisplayed(find.byValueKey("match_list"), 8000);
    }
}

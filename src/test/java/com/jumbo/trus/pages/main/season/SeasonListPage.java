package com.jumbo.trus.pages.main.season;

import com.jumbo.trus.pages.main.MainPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SeasonListPage extends MainPage {

    public SeasonListPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    private WebElement getSeasonList() {
        return waitFor(find.byValueKey("season_list"));
    }

    private WebElement getAddSeasonButton() {
        return waitFor(find.byValueKey("add_season_floating_button"));
    }

    public AddSeasonPage clickOnSeason(String seasonName) {
        WebElement season = scrollUntilVisibleByText(find.byValueKey("season_list"), seasonName);
        if (season == null) {
            Assert.fail("Sezona " + seasonName + " nenalezena");
        }
        season.click();
        AddSeasonPage addSeasonPage = new AddSeasonPage(driver);
        Assert.assertTrue(addSeasonPage.isSeasonNameFieldDisplayed(), "Je očekáváno zobrazení obrazovky pro přidání/editaci sezony");
        return addSeasonPage;
    }

    public AddSeasonPage clickOnAddSeason() {
        getAddSeasonButton().click();
        return new AddSeasonPage(driver);
    }

    public boolean isSeasonDisplayed(String seasonName) {
        WebElement season = scrollUntilVisibleByText(find.byValueKey("season_list"), seasonName);
        return season != null;
    }

    public boolean isSeasonListDisplayed() {
        return isElementDisplayed(find.byValueKey("season_list"), 8000);
    }
}

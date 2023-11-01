package com.jumbo.trus.pages;

import com.jumbo.trus.pages.main.MainPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MatchPage extends MainPage {

    AppiumDriver driver;

    public MatchPage(AppiumDriver driver) {
        super(driver);
    }

    @AndroidFindBy(id = "btn_refuse")
    private WebElement btn_refuse;

    @AndroidFindBy(id = "btn_commit")
    private WebElement btn_commit;

    @AndroidFindBy(id = "tv_interest")
    private WebElement tv_interest;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/androidx.viewpager.widget.ViewPager/android.view.ViewGroup/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")
    private WebElement text_opponent;

    @AndroidFindBy(id = "tvCalendar")
    private WebElement tvCalendar;

    @AndroidFindBy(id = "swHome")
    private WebElement swHome;

    @AndroidFindBy(id = "tvSeason")
    private WebElement tvSeason;

    @AndroidFindBy(id = "tvPlayers")
    private WebElement tvPlayers;

    @AndroidFindBy(className = "android.widget.CheckedTextView")
    private List<WebElement> checkedPlayers;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[2]")
    private WebElement btn_checkedPlayers_commit;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.Button[1]")
    private WebElement btn_checkedPlayers_cancel;

    @AndroidFindBy(id = "btnCommit")
    private WebElement btnCommit;

    public boolean isTvPKFLpresent() {
        return tv_interest.isDisplayed();
    }

    public void loadPKFLMatch() {
        btn_commit.click();
    }

    public void clickOnCheckedPlayers() {
        tvPlayers.click();
    }

    public void checkPlayers(int... players) {
        for (int player: players) {
            checkedPlayers.get(player).click();
        }
    }

    public void confirmCheckedPlayers() {
        btn_checkedPlayers_commit.click();
    }

    public boolean isPlayerTextEmpty() {
        return tvPlayers.getText().trim().isEmpty();
    }

}

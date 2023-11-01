package com.jumbo.trus.pages.widget;

import com.jumbo.trus.pages.main.MainPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class CalendarPage extends MainPage {

    public CalendarPage(AppiumDriver<WebElement> driver) {
        super(driver);
    }

    private WebElement getConfirmButton() {
        return waitFor(find.byText("OK"));
    }

    private WebElement getCancelButton() {
        return waitFor(find.byText("CANCEL"));
    }

    private WebElement getEditButton() {
        return waitFor(find.byToolTip("Switch to input"));
    }

    private WebElement getCalendarText() {
        return waitFor(find.byType("TextFormField"));
    }

    public void setDate(int day, int month, int year) {
        getEditButton().click();
        getCalendarText().sendKeys(month+  "/" + day + "/" + year);
        getConfirmButton().click();
    }
}

package com.jumbo.trus.pages;

import com.jumbo.trus.pages.widget.CalendarPage;
import com.jumbo.trus.util.CalendarDateTranslator;
import io.appium.java_client.AppiumDriver;
import io.github.ashwith.flutter.FlutterFinder;
import org.openqa.selenium.WebElement;

import java.time.LocalDate;
import java.util.HashMap;

public class BasePage {

    protected FlutterFinder find;

    protected AppiumDriver<WebElement> driver;

    public BasePage(AppiumDriver<WebElement> driver) {
        this.driver = driver;
        find = new FlutterFinder(driver);
    }

    protected WebElement waitFor(WebElement element){
        return (WebElement) driver.executeScript("flutter:waitFor", element, 20000);
    }

    protected WebElement scrollUntilVisible(WebElement inElement, String elementKey) {
        WebElement searchedElement = find.byValueKey(elementKey);
        for (int i = 0; i < 10; i++) {
            WebElement returnElement = isElementPresent(searchedElement);
            if (returnElement != null) {
                return returnElement;
            }
            driver.executeScript("flutter:scroll", inElement, new HashMap<String, Object>() {{
                put("dx", 50);
                put("dy", -200);
                put("durationMilliseconds", 500);
            }});
        }
        return null;
    }

    protected WebElement scrollUntilVisibleByText(WebElement inElement, String elementText) {
        WebElement searchedElement = find.byText(elementText);
        for (int i = 0; i < 10; i++) {
            WebElement returnElement = isElementPresent(searchedElement);
            if (returnElement != null) {
                return returnElement;
            }
            driver.executeScript("flutter:scroll", inElement, new HashMap<String, Object>() {{
                put("dx", 50);
                put("dy", -400);
                put("durationMilliseconds", 500);
            }});
        }
        return null;
    }

    protected WebElement scrollHorizontallyUntilVisibleByText(WebElement inElement, String elementText) {
        WebElement searchedElement = find.byText(elementText);
        for (int i = 0; i < 15; i++) {
            WebElement returnElement = isElementPresent(searchedElement);
            if (returnElement != null) {
                return returnElement;
            }
            driver.executeScript("flutter:scroll", inElement, new HashMap<String, Object>() {{
                put("dx", -200);
                put("dy", 0);
                put("durationMilliseconds", 500);
            }});
        }
        return null;
    }

    protected WebElement waitFor(WebElement element, int durationInMs){
        return (WebElement) driver.executeScript("flutter:waitFor", element, durationInMs);
    }

    protected WebElement waitForText(String text){
        return (WebElement) driver.executeScript("flutter:waitFor", find.byText(text), 20000);
    }

    protected WebElement waitForSnackBar(String text){
        return (WebElement) driver.executeScript("flutter:waitFor", find.byText(text), 2000);
    }

    public boolean isTextDisplayed(String text) {
        try {
            waitForText(text);
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    protected boolean isSnackBarDisplayed(String text) {
        try {
            waitForSnackBar(text);
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    protected boolean isElementDisplayed(WebElement element) {
        try {
            waitFor(element);
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    protected boolean isElementDisplayed(WebElement element, int durationInMs) {
        try {
            waitFor(element, durationInMs);
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    protected WebElement isElementPresent(WebElement element) {
        try {
            return waitFor(element, 2000);
        } catch (Exception ignored) {
            return null;
        }
    }

    public BasePage setCalendarDate(int day, int month, int year) {
        CalendarPage calendarPage = new CalendarPage(driver);
        calendarPage.setDate(day, month, year);
        return this;
    }

    public boolean isCalendarTextDisplayed(LocalDate date) {
        CalendarDateTranslator calendarDateTranslator = new CalendarDateTranslator();
        return isTextDisplayed(calendarDateTranslator.getCalendarDay(date));
    }
}

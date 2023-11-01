package com.jumbo.trus.tests;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import io.github.ashwith.flutter.FlutterFinder;
import io.github.ashwith.flutter.FlutterElement;
import io.appium.java_client.AppiumDriver;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BaseClass {

    protected AppiumDriver<WebElement> driver;
    protected FlutterFinder find;

    public static String appPtah = "/app-debug.apk";


    //@BeforeClass
    @BeforeMethod
    public void setup() {
        File rootFile = new File("");
        File appFile = new File(rootFile.getAbsolutePath() + appPtah);
        appPtah = appFile.getAbsolutePath();
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung");
        cap.setCapability(MobileCapabilityType.UDID, "R58N507C1BY");
        cap.setCapability(CapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12");
        cap.setCapability("appPackage", "com.jumbo.trus_app");
        cap.setCapability("appActivity", "com.jumbo.trus_app.MainActivity");
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Flutter");
        cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "3");
        cap.setCapability("noReset", "false");
        //cap.setCapability("skipUnlock","true");

        cap.setCapability("autoGrantPermissions", "true");
        //flutterCapabilities.setCapability("udid",udid);
        //cap.setCapability("app",appPtah);
        URL url = null;
        try {
            url = new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new AndroidDriver<>(url, cap);
        find = new FlutterFinder(driver);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    protected void hideKeyboard() {
        driver.hideKeyboard();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

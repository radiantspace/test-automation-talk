package com.microsoft.samples.appium.ios;

import com.xamarin.testcloud.appium.EnhancedIOSDriver;
import com.xamarin.testcloud.appium.Factory;
import io.appium.java_client.MobileElement;
import org.junit.*;
import org.junit.experimental.categories.Category;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AddTaskTest {
    @Rule
    public TestWatcher watcher = Factory.createWatcher();

    private static EnhancedIOSDriver<MobileElement> driver;

    @Before
    public void before() throws Exception {
        File app = new File("Tasky.app");
        
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone Simulator");
        capabilities.setCapability("app", app.getAbsolutePath());
        capabilities.setCapability("platformVersion", "11.1");

        URL url = new URL("http://localhost:4723/wd/hub");

        driver = Factory.createIOSDriver(url, capabilities);
    }

    @After
    public void after() throws Exception {
        if (driver != null) {
            driver.quit();
        }
    }
}
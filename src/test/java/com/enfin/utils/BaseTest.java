package com.enfin.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.time.Duration;

public class BaseTest {

    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected Logger log = Logger.getLogger(this.getClass());

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*", "--start-maximized");
        driver.set(new ChromeDriver(options));
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        getDriver().get("https://www.demoblaze.com/");
        log.info("Browser launched and navigated to Demoblaze");
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    @AfterMethod
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            log.info("Browser closed");
            driver.remove();
        }
    }
}

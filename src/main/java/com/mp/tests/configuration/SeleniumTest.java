package com.mp.tests.configuration;

import com.mp.tests.pages.PageGenerator;
import com.mp.tests.util.PropertiesLoader;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Slf4j
public abstract class SeleniumTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    protected PageGenerator browser;
    protected Properties properties = PropertiesLoader.loadProperties();


    @BeforeEach
    protected void setup() {

        System.setProperty("webdriver.http.factory", "jdk-http-client");
        createDriver();
        createWaitDriver();
        browser = new PageGenerator(driver);
    }

    @AfterEach
    protected void teardown() {

        driver.quit();
    }

    private void createDriver() {

        WebDriverManager.chromedriver().setup();
        List<String> optionList = new ArrayList<>();
        if (Boolean.parseBoolean(properties.getProperty("webdriver.headless"))) {
            optionList.add("headless");
        }
        optionList.add("start-maximized");
        ChromeOptions options = new ChromeOptions();
        options.addArguments(optionList);
        driver = new ChromeDriver(options);
    }

    private void createWaitDriver() {

        int timeout = Integer.parseInt(properties.getProperty("webdriver.wait.timeout"));
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }
}

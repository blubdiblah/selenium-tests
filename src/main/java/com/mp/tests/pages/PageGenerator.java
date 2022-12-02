package com.mp.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageGenerator {

    protected WebDriver driver;

    public PageGenerator(WebDriver driver) {
        this.driver = driver;
    }

    public <TPage extends BasePage> TPage open(Class<TPage> pageClass) {
        try {
            TPage page = PageFactory.initElements(driver, pageClass);
            page.goTo();
            return page;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}

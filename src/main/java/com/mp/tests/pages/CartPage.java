package com.mp.tests.pages;

import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage{

    public final String pageUrl = baseUrl + "cart.html";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected BasePage goTo() {
        driver.get(pageUrl);
        return this;
    }
}

package com.mp.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.assertj.core.api.Assertions.assertThat;


public class CartPage extends BasePage{

    public final String pageUrl = baseUrl + "cart.html";

    @FindBy(how = How.CLASS_NAME, using = "inventory_item_name")
    private WebElement itemInCart;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected BasePage goTo() {
        driver.get(pageUrl);
        return this;
    }

    public CartPage checkThatItemNameIs(String itemName) {
        assertThat(itemInCart.getText()).isEqualTo(itemName);
        return this;
    }
}

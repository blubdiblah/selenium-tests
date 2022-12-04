package com.mp.tests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage extends BasePage {

    public final String pageUrl = baseUrl + "inventory.html";

    @FindBy(how = How.CLASS_NAME, using = "shopping_cart_link")
    private WebElement openCartButton;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @Override
    protected BasePage goTo() {
        driver.get(pageUrl);
        return this;
    }

    public InventoryPage clickAddToCartButtonFor(String itemName) {
        By addToCartLocator = By.id("add-to-cart-" + itemName);
        WebElement addToCartButton = driver.findElement(addToCartLocator);
        click(addToCartButton);
        return this;
    }

    public CartPage clickOpenCartButton() {
        click(openCartButton);
        return PageFactory.initElements(driver, CartPage.class);
    }
}

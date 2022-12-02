package tests;

import com.mp.tests.configuration.SeleniumTest;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.assertj.core.api.Assertions.assertThat;

public class Part1Tests extends SeleniumTest {

    @Test
    void webdriverTest() {

        driver.get("https://www.saucedemo.com/");
    }

    @Test
    void webdriverWaitWorks() {

        driver.get("https://www.saucedemo.com/");
        wait.until(ExpectedConditions.titleIs("Swag Labs"));
    }

    @Test
    void addSauceLabsBackbackToCart() {

        By inputFieldUsername = By.cssSelector("#user-name");
        By inputFieldPassword = By.cssSelector("#password");
        By loginButton = By.cssSelector("#login-button");
        By addBackpackToCartButton = By.cssSelector("#add-to-cart-sauce-labs-backpack");
        By openCartButton = By.cssSelector(".shopping_cart_link");
        By itemInCart = By.cssSelector(".inventory_item_name");

        //Login
        driver.get("https://www.saucedemo.com/");
        wait.until(ExpectedConditions.presenceOfElementLocated(inputFieldUsername));
        driver.findElement(inputFieldUsername).sendKeys("standard_user");
        driver.findElement(inputFieldPassword).sendKeys("secret_sauce");
        driver.findElement(loginButton).click();
        //Add backpack to cart
        wait.until(ExpectedConditions.presenceOfElementLocated(addBackpackToCartButton));
        driver.findElement(addBackpackToCartButton).click();
        //Go to cart
        driver.findElement(openCartButton).click();
        //Check backpack is in the cart
        wait.until(ExpectedConditions.presenceOfElementLocated(itemInCart));
        String itemName = driver.findElement(itemInCart).getText();
        assertThat(itemName).isEqualTo("Sauce Labs Backpack");
    }


}

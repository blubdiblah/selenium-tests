package tests;

import com.mp.tests.configuration.SeleniumTest;
import com.mp.tests.pages.LoginPage;
import org.junit.jupiter.api.Test;

public class PageObjectSeleniumTests extends SeleniumTest {

    @Test
    void addSauceLabsBackbackToCart() {

        browser.open(LoginPage.class)
                .typeUsername("standard_user")
                .typePassword("secret_sauce")
                .clickLoginButton()
                .clickAddToCartButtonFor("sauce-labs-backpack")
                .clickOpenCartButton()
                .checkThatItemNameIs("Sauce Labs Backpack");
    }
}

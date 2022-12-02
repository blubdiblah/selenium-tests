package tests;

import com.mp.tests.configuration.SeleniumTest;
import com.mp.tests.pages.InventoryPage;
import com.mp.tests.pages.LoginPage;
import org.junit.jupiter.api.Test;

public class Part2Tests extends SeleniumTest {

    @Test
    void webdriverTest() {

        browser.open(LoginPage.class)
                .login("standard_user", "secret_sauce")
                .clickAddToCartButtonFor("sauce-labs-backpack")
                .clickOpenCartButton()
                .open(InventoryPage.class);
    }
}

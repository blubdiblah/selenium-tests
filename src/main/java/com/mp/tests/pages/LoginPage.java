package com.mp.tests.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

@Getter
public class LoginPage extends BasePage {

    public final String pageUrl = baseUrl;

    @FindBy(how = How.ID, using = "user-name")
    private WebElement usernameInputField;

    @FindBy(how = How.ID, using = "password")
    private WebElement passwordInputField;

    @FindBy(how = How.ID, using = "login-button")
    private WebElement loginButton;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    protected BasePage goTo() {
        driver.get(pageUrl);
        return this;
    }

    public InventoryPage login(String username, String password) {
        writeText(username, usernameInputField);
        writeText(password, passwordInputField);
        click(loginButton);
        return PageFactory.initElements(driver, InventoryPage.class);
    }

    public LoginPage typeUsername(String username) {
        writeText(username, usernameInputField);
        return this;
    }

    public LoginPage typePassword(String password) {
        writeText(password, passwordInputField);
        return this;
    }

    public InventoryPage clickLoginButton() {
        click(loginButton);
        return PageFactory.initElements(driver, InventoryPage.class);
    }
}

package com.qamadness.qamadness_test_task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    final String url;
    private final WebDriver driver;
    @FindBy(xpath = "//span[contains(text(),'Continue with email')]")
    private WebElement continueWithEmailButton;
    @FindBy(xpath = "//input[@id='username']")
    private WebElement emailInput;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;
    @FindBy(xpath = "//span[contains(text(),'Sign in')]")
    private WebElement signInButton;
    @FindBy(xpath = "//div[@id='password-note']")
    private WebElement passwordNote;
    @FindBy(xpath = "//div[@id='username-note']")
    private WebElement usernameNote;


    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        url = "https://account.booking.com/";
    }

    public void enterEmail(String username) {
        emailInput.sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public void clickContinueWithEmailButton() {
        continueWithEmailButton.click();
    }

    public void clickSignInButton() {
        signInButton.click();
    }


    public void open() {
        driver.get(url);
    }

    public WebElement getPasswordNote() {
        return passwordNote;
    }

    public WebElement getUsernameNote() {
        return usernameNote;
    }
}

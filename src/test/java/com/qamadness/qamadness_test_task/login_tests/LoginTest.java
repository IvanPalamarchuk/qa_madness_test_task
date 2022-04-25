package com.qamadness.qamadness_test_task.login_tests;

import com.qamadness.qamadness_test_task.LoginPage;
import com.qamadness.qamadness_test_task.MainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test_utils.SearchTestUtils;

import java.time.Duration;

class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private MainPage mainPage;
    private WebDriverWait driverWait;

    @BeforeEach
    void setUp() {
        SearchTestUtils searchTestUtils = new SearchTestUtils();
        driver = searchTestUtils.getConfiguredChromeDriver();
        loginPage = new LoginPage(this.driver);
        mainPage = new MainPage(this.driver);
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

    @Test
    void verifyThatUserCanLogin() {
        loginPage.open();
        loginPage.enterEmailInput("rekruit.free@gmail.com");
        loginPage.clickContinueWithEmailButton();
        loginPage.enterPasswordInput("passworD123");
        loginPage.clickSignInButton();
        driverWait.until(ExpectedConditions.visibilityOf(mainPage.getSearchButton()));
        Assertions.assertEquals(mainPage.getTitle(), driver.getTitle());
    }

    @Test
    void verifyThatUserCantLoginWithoutPassword() {
        mainPage.open();
        mainPage.clickSignInRegisterButton();
        loginPage.enterEmailInput("rekruit.free@gmail.com");
        loginPage.clickContinueWithEmailButton();
        loginPage.clickSignInButton();
        Assertions.assertEquals(loginPage.getPasswordNote().getText(), "Please enter your Booking.com password");
    }

    @Test
    void verifyThatUserCantLoginWithoutEmail() {
        mainPage.open();
        mainPage.clickSignInRegisterButton();
        loginPage.clickContinueWithEmailButton();
        Assertions.assertEquals(loginPage.getUsernameNote().getText(), "Please enter your email address");
    }

}
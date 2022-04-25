package com.qamadness.qamadness_test_task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    final String url;
    private final String title;
    private final WebDriver driver;
    @FindBy(xpath = "//span[contains(text(),'Search')]")
    private WebElement searchButton;
    @FindBy(xpath = "//span[contains(text(),'Sign in / Register')]")
    private WebElement signInRegisterButton;


    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        url = "https://www.booking.com/en-gb/";
        title = "Booking.com | Official site | The best hotels, flights, car rentals & accommodations";
    }

    public String getTitle() {
        return title;
    }

    public void clickSignInRegisterButton() {
        signInRegisterButton.click();
    }


    public WebElement getSearchButton() {
        return searchButton;
    }

    public void open() {
        driver.get(url);
    }
}

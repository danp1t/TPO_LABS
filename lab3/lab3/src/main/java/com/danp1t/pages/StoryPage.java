package com.danp1t.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StoryPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div[2]/main/div[1]/div/div/div[1]/div")
    private WebElement cityButton;

    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div[2]/main/div[1]/div/div/div[1]/div/span")
    private WebElement city;

    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div[2]/main/div[2]/div[1]/div[1]/h2/span[1]")
    private WebElement storeAddress;

    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div[2]/main/div[2]/div[1]/div[1]/div[1]/div[3]")
    private WebElement storeWorkingHours;

    public StoryPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOfAllElements(cityButton));
        this.driver = driver;
    }


    public String getStoreAddress() {
        return storeAddress.getText();
    }

    public String getStoreWorkingHours() {
        return storeWorkingHours.getText();
    }

    public boolean isStoreListDisplayed() {
        return city.isDisplayed();
    }
}
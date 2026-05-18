package com.danp1t.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    private final WebDriver driver;

    @FindBy(xpath = "//button[contains(@class, 'ga-header__tab_type_search')]")
    private WebElement searchButton;

    @FindBy(xpath = "//input[@placeholder='хочу купить']")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div[2]/aside[8]/div[2]/div/div/div/div/div/div[1]/div/div/div/form/div[2]/button[1]")
    private WebElement searchAcceptButton;

    @FindBy(xpath = "//span[number(@data-category-products-count) > 0]")
    private WebElement searchResultsCount;

    @FindBy(xpath = "//a[contains(@href, '/brands')]")
    private WebElement brandsTab;

    @FindBy(xpath = "//a[contains(@href, '/flacon/articles')]")
    private WebElement flaconTab;

    @FindBy(xpath = "//a[contains(@href, '/cards')]")
    private WebElement presentCards;

    @FindBy(xpath = "//a[contains(@href, '/customer/account')]")
    private WebElement accountButton;

    @FindBy(xpath = "//button[contains(@class, 'ga-header__tab_type_profile')]")
    private WebElement authorizationButton;

    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div[2]/div[6]/aside/div[2]/div/div/div/div/div/div[1]/div[3]/div/ul/li[2]/button[1]")
    private WebElement vkAuthButton;

    @FindBy(xpath = "//a[contains(@href, '/stockists')]")
    private WebElement storyButton;


    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public BrandPage searchBrand() {
        brandsTab.click();
        return new BrandPage(driver);
    }

    public AuthorizationPage authorization() {
        authorizationButton.click();
        wait.until(ExpectedConditions.visibilityOf(vkAuthButton));
        vkAuthButton.click();
        return new AuthorizationPage(driver);
    }

    public void searchProduct(String productName) {
        searchButton.click();
        wait.until(ExpectedConditions.visibilityOf(searchInput));
        typeText(searchInput, productName);
        wait.until(ExpectedConditions.visibilityOf(searchInput));
        searchAcceptButton.click();
        wait.until(ExpectedConditions.visibilityOf(searchResultsCount));
    }

    public StoryPage findStory() {
        storyButton.click();
        return new StoryPage(driver);
    }

    public boolean isAccountButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(accountButton)).isDisplayed();
    }

    public boolean isSearchResultsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(searchResultsCount)).isDisplayed();
    }

    public FlaconPage openFlacon() {
        flaconTab.click();
        return new FlaconPage(driver);
    }
}

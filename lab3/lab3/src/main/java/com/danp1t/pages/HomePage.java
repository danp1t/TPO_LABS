package com.danp1t.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    private final WebDriver driver;

    @FindBy(xpath = "//button[contains(@class, 'ga-header__tab_type_search')]")
    private WebElement searchButton;

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

    public boolean isAccountButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(accountButton)).isDisplayed();
    }
}

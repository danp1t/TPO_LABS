package com.danp1t.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BrandPage extends BasePage {
    private final WebDriver driver;

    @FindBy(xpath = "//input[@placeholder='найти бренды']")
    private WebElement searchInput;

    @FindBy(xpath = "//a[contains(@data-transaction-name, 'ga-brands-item')]")
    private List<WebElement> brandResults;

    @FindBy(xpath = "//*[@id=\"__layout\"]/div/main/div[2]/div/div[2]/p")
    private WebElement noResultsMessage;

    public BrandPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@placeholder='найти бренды']")
        ));
        this.driver = driver;
    }


    public void inputSearch(String search) {
        typeText(searchInput, search);
        waitForResultsOrEmpty();
    }

    private void waitForResultsOrEmpty() {
        wait.until(driver -> {
            boolean hasResults = !brandResults.isEmpty() && brandResults.getFirst().isDisplayed();
            boolean noMessages = false;
            try {
                noMessages = noResultsMessage.isDisplayed();
            } catch (Exception ignored) {}
            return hasResults || noMessages;
        });
    }


    public List<String> getBrandNames() {
        return brandResults.stream()
                .map(WebElement::getText)
                .toList();
    }

    public boolean isNoResultsDisplayed() {
        try {
            return noResultsMessage.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public String getNoResultsText() {
        return getText(noResultsMessage);
    }
}
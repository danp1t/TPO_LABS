package com.danp1t.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class FlaconPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div[2]/div[2]/div[2]/div/div/div/div/div[2]")
    private List<WebElement> categoryButtons;

    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div[2]/div[2]/div[3]/div[1]/article[1]/div/div[2]")
    private List<WebElement> articleTitles;

    public FlaconPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOfAllElements(categoryButtons));
        this.driver = driver;
    }

    public List<String> getCategoryNames() {
        return categoryButtons.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }


    public boolean isArticleListDisplayed() {
        return !articleTitles.isEmpty();
    }

    public List<String> getArticleTitles() {
        return articleTitles.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
package com.danp1t.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductCardPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div[2]/main/article/header/div[2]/div/div")
    private WebElement productTitle;

    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div[2]/main/article/div[1]/div[1]/form/div[2]/div[2]/div/div[1]")
    private WebElement productPrice;

    public ProductCardPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOf(productPrice));
        this.driver = driver;
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }
}

package com.danp1t.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductCardPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div[2]/main/div[3]/div[1]/div[1]/div/div[1]/div/div[1]/div/div/article/div/a/div[2]/div[4]/div/span[2]")
    private WebElement productTitle;

    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div[2]/main/div[3]/div[1]/div[1]/div/div[1]/div/div[1]/div/div/article/div/a/div[2]/div[6]/div/span[1]/div")
    private WebElement productPrice;

    @FindBy(xpath = "//button[contains(text(), 'В корзину')]")
    private WebElement addToCartButton;

    public ProductCardPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOf(productTitle));
        this.driver = driver;
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }

    public boolean isAddToCartButtonDisplayed() {
        return addToCartButton.isDisplayed();
    }
}
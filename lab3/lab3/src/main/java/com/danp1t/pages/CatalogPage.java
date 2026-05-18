package com.danp1t.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CatalogPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div[2]/main/div[3]/div[1]/div[1]/div/div[1]/div/div[1]/div/div/article/div/a")
    private WebElement linkProduct;

    public CatalogPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOf(linkProduct));
        this.driver = driver;
    }

    public ProductCardPage visitProductCardPage(){
        linkProduct.click();
        return new ProductCardPage(driver);
    }
}
package com.danp1t.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AuthorizationPage extends BasePage{
    private final WebDriver driver;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/div[1]/div/div/div/div/div/form/div[2]/button")
    private WebElement authVkButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[1]/div[2]/div[2]/button[1]")
    private WebElement authVkAcceptButton;


    public AuthorizationPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOf(authVkButton));
        this.driver = driver;
    }

    public void clickAuthVkButton() {
        authVkButton.click();
    }

    public void clickAuthVkAcceptButton() {
        wait.until(ExpectedConditions.visibilityOf(authVkAcceptButton)).click();
    }
}

package com.danp1t.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GiftCardPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"buy-card\"]/div[1]/div/div[1]/div/div[2]/div[2]/button")
    private WebElement electronicType;

    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div[2]/aside[9]/div[2]/div/div/div/div/footer/button")
    private WebElement designOptions;

    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div[2]/aside[9]/div[2]/div/div/div/div/footer/button")
    private WebElement nominalButtons;

    @FindBy(xpath = "//*[@id=\"buy-card\"]/div[1]/div/div[1]/div/div[2]/div[1]/h2")
    private WebElement electronicCard;

    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div[2]/aside[9]/div[2]/div/div/div/div/div[2]/div/div/form/div/div[1]/div[1]/label[1]/span")
    private WebElement forSelfRadio;

    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div[2]/aside[9]/div[2]/div/div/div/div/div[2]/div/div/form/div/div[1]/div[1]/label[1]/input")
    private WebElement forSelfRadioInput;

    @FindBy(xpath = "//input[@type='radio' and @value='friend']")
    private WebElement forFriendRadio;

    @FindBy(xpath = "//*[@name='recipientPhone']")
    private WebElement phoneInput;


    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div[2]/aside[9]/div[2]/div/div/div/div/footer/button")
    private WebElement phoneInputButtonSubmit;

    @FindBy(xpath = "//*[@name='setRecipePhone']")
    private WebElement setRecipePhone;

    @FindBy(xpath = "//textarea[@placeholder='Текст поздравления']")
    private WebElement messageTextarea;

    @FindBy(xpath = "//input[@placeholder='Имя отправителя']")
    private WebElement senderNameInput;

    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div[2]/aside[9]/div[2]/div/div/div/div/footer/button")
    private WebElement sendNowButton;

    @FindBy(xpath = "//button[contains(text(), 'Выбрать время')]")
    private WebElement chooseTimeButton;

    @FindBy(xpath = "//input[@type='date']")
    private WebElement datePicker;

    @FindBy(xpath = "//input[@type='time']")
    private WebElement timePicker;

    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div[2]/aside[9]/div[2]/div/div/div/div/footer/button")
    private WebElement payButton;

    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div[2]/div[25]/aside/div[2]/div/div/div/div/div/div/div[2]/button")
    private WebElement continueButton;

    @FindBy(xpath = "//*[@id=\"__nuxt\"]/div[2]/div[25]/aside/div[2]/div/div/div/div/div/div/div[2]/button")
    private WebElement continue2Button;

    public GiftCardPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.visibilityOf(electronicCard));
        this.driver = driver;
    }

    public void selectElectronicType() {
        moveMouseTo(electronicCard);
        electronicType.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(designOptions));
    }

    public void selectFirstDesign() {
        designOptions.click();
        wait.until(ExpectedConditions.visibilityOfAllElements(nominalButtons));
    }

    public void selectFirstNominal() {
        nominalButtons.click();
        wait.until(ExpectedConditions.visibilityOf(phoneInput));
    }

    public void fillForSelf(String phone) {
        typeText(phoneInput, phone);
        phoneInputButtonSubmit.click();
    }

    public void selectSendNow(String phone) {
        sendNowButton.click();
        wait.until(ExpectedConditions.visibilityOf(payButton));
        payButton.click();
        wait.until(ExpectedConditions.visibilityOf(setRecipePhone));
        typeText(setRecipePhone, phone);
        wait.until(ExpectedConditions.visibilityOf(continueButton));
        continueButton.click();
        wait.until(ExpectedConditions.visibilityOf(continue2Button));
        continue2Button.click();
    }

    public void selectScheduleTime(String date, String time) {
        chooseTimeButton.click();
        wait.until(ExpectedConditions.visibilityOf(datePicker));
        typeText(datePicker, date);
        typeText(timePicker, time);
        wait.until(ExpectedConditions.visibilityOf(payButton));
    }

}
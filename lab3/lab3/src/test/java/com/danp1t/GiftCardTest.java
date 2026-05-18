package com.danp1t;

import com.danp1t.pages.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GiftCardTest {

    private Utils utils;
    private WebDriver driver;

    @BeforeAll
    void globalSetUp() {
        utils = new Utils();
        utils.setupDriver();
        driver = utils.getDriver();
    }

    @BeforeEach
    void openHomePage() {
        driver.get("https://goldapple.ru/");
    }

    @AfterAll
    void tearDown() {
        utils.quitDriver();
    }

    @Test
    @DisplayName("TS-06: Полный цикл оформления подарочной карты")
    void shouldCompleteGiftCardOrder() {
        HomePage homePage = new HomePage(driver);
        GiftCardPage giftPage = homePage.openGiftCards();

        giftPage.selectElectronicType();
        giftPage.selectFirstDesign();
        giftPage.selectFirstNominal();
        giftPage.fillForSelf("9123456789");
        giftPage.selectSendNow("9123456789");

    }
}
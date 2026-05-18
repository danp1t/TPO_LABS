package com.danp1t;

import com.danp1t.pages.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StoreAvailabilityTest {

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
        driver.get("https://goldapple.ru/19000306604-f732");
    }

    @AfterAll
    void tearDown() {
        utils.quitDriver();
    }

    @Test
    @DisplayName("TS-09-01: Открытие меню выбора города для проверки наличия")
    void shouldOpenCitySelectionMenu() {
        ProductCardPage productCard = new ProductCardPage(driver);
        productCard.clickStoreAvailability();

        assertFalse(productCard.getCityNames().isEmpty(),
                "Должен отображаться список городов для выбора");
    }
}
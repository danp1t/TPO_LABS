package com.danp1t;

import com.danp1t.pages.HomePage;
import com.danp1t.pages.ProductCardPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProductCardTest {

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
    @DisplayName("TS-07-01: Переход в карточку товара из категории")
    void shouldOpenProductCardFromCategory() {
        HomePage homePage = new HomePage(driver);
        ProductCardPage productCard = homePage.selectCategory();

        assertFalse(productCard.getProductTitle().isEmpty(), "Название товара не пустое");
        assertFalse(productCard.getProductPrice().isEmpty(), "Цена товара не пустая");
    }
}
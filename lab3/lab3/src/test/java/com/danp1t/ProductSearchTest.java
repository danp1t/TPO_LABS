package com.danp1t;

import com.danp1t.pages.HomePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ProductSearchTest {

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
    @DisplayName("TS-02-01: Поиск товара – счётчик результатов больше 0")
    void shouldFindProductsByKeyword() {
        HomePage homePage = new HomePage(driver);
        String query = "крем";

        homePage.searchProduct(query);

        assertTrue(homePage.isSearchResultsDisplayed(),
                "Счётчик найденных товаров должен быть виден, а значит, найден > 0 товаров");
    }
}
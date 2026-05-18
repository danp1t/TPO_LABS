package com.danp1t;

import com.danp1t.pages.BrandPage;
import com.danp1t.pages.HomePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BrandSearchTest {
    private final Random random = new Random();
    private Utils utils;
    private WebDriver driver;
    private HomePage homePage;

    @BeforeAll
    void globalSetUp() {
        utils = new Utils();
        utils.setupDriver();
        driver = utils.getDriver();
    }

    @BeforeEach
    void openHomePage() throws InterruptedException {
        driver.get("https://goldapple.ru/");
        homePage = new HomePage(driver);
    }

    @AfterAll
    void tearDown() {
        utils.quitDriver();
    }

    @Test
    @DisplayName("TS-03-01: Поиск существующего бренда – должны отобразиться результаты")
    void shouldFindExistingBrand() {
        String brand = "Cucciolo";
        BrandPage brandPage = homePage.searchBrand();
        brandPage.inputSearch(brand);

        assertFalse(brandPage.isNoResultsDisplayed(),
                "Не должно быть сообщения «Ничего не найдено»");
        assertTrue(brandPage.getBrandNames().stream()
                        .anyMatch(name -> name.equalsIgnoreCase(brand)),
                "Список брендов должен содержать " + brand);
    }

    @Test
    @DisplayName("TS-03-01: Поиск несуществующего бренда – сообщение «Ничего не найдено»")
    void shouldShowEmptyMessageForUnknownBrand() {
        String fakeBrand = "Abracadabra123";
        BrandPage brandPage = homePage.searchBrand();
        brandPage.inputSearch(fakeBrand);

        assertTrue(brandPage.isNoResultsDisplayed(),
                "Должно появиться сообщение «Ничего не найдено»");
        String expected = "Ничего не найдено. Попробуйте изменить запрос и мы поищем ещё раз.";
        assertEquals(expected, brandPage.getNoResultsText());
    }
}
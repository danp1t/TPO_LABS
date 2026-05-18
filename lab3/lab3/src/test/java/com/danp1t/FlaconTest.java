package com.danp1t;

import com.danp1t.pages.FlaconPage;
import com.danp1t.pages.HomePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class FlaconTest {

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
    @DisplayName("TS-05-01: Переход на вкладку Flacon – отображаются категории")
    void shouldNavigateToFlaconSection() {
        HomePage homePage = new HomePage(driver);
        FlaconPage flaconPage = homePage.openFlacon();

        assertFalse(flaconPage.getCategoryNames().isEmpty(),
                "Список категорий должен быть не пустым");
    }

    @Test
    @DisplayName("TS-05-02: Выбор категории – отображаются статьи с выбранной категорией")
    void shouldDisplayArticlesForSelectedCategory() {
        HomePage homePage = new HomePage(driver);
        FlaconPage flaconPage = homePage.openFlacon();

        assertTrue(flaconPage.isArticleListDisplayed(),
                "Список статей должен отображаться после выбора категории");
        assertFalse(flaconPage.getArticleTitles().isEmpty(),
                "Должен быть хотя бы один заголовок статьи");
    }
}
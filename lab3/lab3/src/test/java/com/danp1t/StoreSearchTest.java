package com.danp1t;

import com.danp1t.pages.HomePage;
import com.danp1t.pages.StoryPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StoreSearchTest {

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
    @DisplayName("TS-04-01: Выбор города – отображается список магазинов")
    void shouldShowStoreListAfterSelectingCity() {
        HomePage homePage = new HomePage(driver);
        StoryPage storyPage = homePage.findStory();

        assertTrue(storyPage.isStoreListDisplayed(), "Список магазинов должен отображаться");
    }

    @Test
    @DisplayName("TS-04-02: Выбор конкретного магазина – отображается адрес и время работы")
    void shouldShowStoreDetails() {
        HomePage homePage = new HomePage(driver);
        StoryPage storyPage = homePage.findStory();

        assertNotNull(storyPage.getStoreAddress(), "Адрес магазина должен быть виден");
        assertFalse(storyPage.getStoreAddress().isEmpty(), "Адрес не должен быть пустым");
        assertNotNull(storyPage.getStoreWorkingHours(), "Время работы должно быть видно");
        assertFalse(storyPage.getStoreWorkingHours().isEmpty(), "Время работы не должно быть пустым");
    }
}
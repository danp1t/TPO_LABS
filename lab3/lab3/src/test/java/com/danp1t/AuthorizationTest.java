package com.danp1t;

import com.danp1t.pages.AuthorizationPage;
import com.danp1t.pages.HomePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AuthorizationTest {

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
    void openHomePage() {
        driver.get("https://goldapple.ru/");
        homePage = new HomePage(driver);
    }

    @AfterAll
    void tearDown() {
        utils.quitDriver();
    }

    @Test
    @DisplayName("TS-01-01: Успешная авторизация через VK")
    void shouldAuthorizeViaVk() {
        AuthorizationPage authPage = homePage.authorization();
        authPage.clickAuthVkButton();

        String mainWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String handle : allWindows) {
            if (!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
                break;
            }
        }

        authPage.clickAuthVkAcceptButton();

        driver.switchTo().window(mainWindow);

        HomePage homeAfterLogin = new HomePage(driver);
        assertTrue(homeAfterLogin.isAccountButtonDisplayed(),
                "Кнопка аккаунта должна быть видна после входа");
    }
}
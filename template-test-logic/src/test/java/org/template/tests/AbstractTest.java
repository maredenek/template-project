package org.template.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.template.configuration.TestData;
import org.template.factory.UserSessionFlyweightFactory;
import org.template.factory.WebDriverFactory;
import org.template.model.User;

public abstract class AbstractTest {

    protected final WebDriver driver = WebDriverFactory.getWebDriver();
    protected final TestData testData = new TestData();

    @BeforeEach
    void setUp() {
        driver.get("http://automationpractice.com");
    }

    @AfterAll
    static void tearDown() {
        WebDriverFactory.quitWebDriver();
    }

    protected void addSessionCookieToBrowserOf(User user) {
        //Cookie userSessionCookie = UserSessionFlyweightFactory.logUserInWith(user.getEmail(), user.getPassword());
        driver.manage().deleteAllCookies();
        driver.manage().addCookie(user.getSessionCookie());
        driver.navigate().refresh();
    }

}

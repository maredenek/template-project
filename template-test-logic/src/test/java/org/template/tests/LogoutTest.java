package org.template.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.template.model.User;
import org.template.pageobjects.HomePage;

public class LogoutTest extends AbstractTest {

    User user = testData.getUsersData().get(0);

    @BeforeEach
    public void logUserIn() {
        addSessionCookieToBrowserOf(user);
    }

    @Test
    public void shouldSuccessfullyLogOutUser() {
        HomePage homePage = new HomePage(driver);
        homePage.header().clickSingOutButton();
        Assertions.assertTrue(homePage.header().isSignInButtonDisplayed());
    }

}

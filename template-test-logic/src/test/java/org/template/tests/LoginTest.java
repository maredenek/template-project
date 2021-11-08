package org.template.tests;

import org.junit.jupiter.api.Test;
import org.template.model.User;

public class LoginTest extends AbstractTest {

    User user = testData.getUsersData().get(0);

    /**
     * Run both test in debugging mode and check how many times request to fetch user cookie is made.
     */

    @Test
    public void firstTest() {
        addSessionCookieToBrowserOf(user);
        driver.navigate().refresh();
        //here user should be already logged
        System.out.println("Cookie from 1st test :" +  user.getSessionCookie());
    }

    @Test
    public void secondTest() {
        addSessionCookieToBrowserOf(user);
        driver.navigate().refresh();
        //here user should be already logged
        System.out.println("Cookie from 2nd test :" +  user.getSessionCookie());
    }

}

package org.template.factory;

import org.openqa.selenium.Cookie;
import org.template.authentication.PostAuthenticateApiRequest;
import org.template.configuration.TestData;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class UserSessionFlyweightFactory {

    private static TestData testData = new TestData();
    private static final Map<String, Cookie> sessionsIds = new HashMap<>();

    public static Cookie logUserInWith(String email, String password) {
        Cookie sessionCookie = sessionsIds.get(email);
        if(sessionCookie == null) {
            PostAuthenticateApiRequest apiRequest = new PostAuthenticateApiRequest(testData.getEnvironmentData().getUrl(), "");
            Map<String, String> cookies = apiRequest
                    .setEmail(email)
                    .setPassword(password)
                    .sendRequest()
                    .assertRequestSuccess()
                    .getResponseCookies();
            String cookieName = cookies.keySet().stream()
                    .filter(name -> name.startsWith("PrestaShop"))
                    .findFirst()
                    .orElseThrow(NoSuchElementException::new);
            sessionCookie = new Cookie(cookieName, cookies.get(cookieName));
            sessionsIds.put(email, sessionCookie);
        }
        return sessionCookie;
    }

    public static void deleteUserCookie(String email) {
        sessionsIds.remove(email);
    }
}

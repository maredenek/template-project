package org.template.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.template.AbstractPage;
import org.template.pageobjects.HomePage;
import org.template.pageobjects.LoginPage;

public class Header extends AbstractPage {

    @FindBy(xpath = "//a[@class='login']")
    private WebElement singInButton;
    @FindBy(css = "a.logout")
    private WebElement singOutButton;

    public Header(WebDriver driver) {
        super(driver);
    }

    public LoginPage goToLogInPage() {
        singInButton.click();
        return new LoginPage(driver);
    }

    public void clickSingOutButton() {
        singOutButton.click();
    }

    public boolean isSignInButtonDisplayed() {
        return singInButton.isDisplayed();
    }

}

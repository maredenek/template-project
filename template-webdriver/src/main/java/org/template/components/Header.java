package org.template.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.template.AbstractPage;
import org.template.pageobjects.LoginPage;

public class Header extends AbstractPage {

    @FindBy(xpath = "//a[@class='login']")
    private WebElement singInButton;
    public Header(WebDriver driver) {
        super(driver);
    }

    public LoginPage goToLogInPage() {
        singInButton.click();
        return new LoginPage(driver);
    }

}

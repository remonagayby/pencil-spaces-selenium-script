package pages;

import actions.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends ElementActions {

    private final By welcomePageHeader = By.xpath("//span[contains(@class, 'card-title')]");
    private final By btnContinueWithMail = By.xpath("//span[contains(@class, 'label') and contains(text(), 'Continue with Email')]");
    private final By lblEmail = By.id("email-value");
    private final By btnEmailInputContinue = By.id("emailInputContinue");
    private final By lblPassword = By.id("password-value");
    private final By btnSigningContinueBtn = By.xpath("//span[contains(@class, 'label') and contains(text(), 'Continue')]");

    public static long startTime = System.currentTimeMillis();

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage validateWelcomePageUrl() {
        Assert.assertEquals(getPageURL(), loginPageUrl, "Welcome page URL is not matching");
        return this;
    }

    public LoginPage isTitlePresent() {
        isElementDisplayed(welcomePageHeader);
        return this;
    }

    public LoginPage clickContinueWithMail() {
        clickElement(btnContinueWithMail);
        return this;
    }

    public LoginPage enterEmailAddress(String email) {
        sendKeysToElement(lblEmail, email);
        return this;
    }

    public LoginPage clickContinueBtn() {
        clickElement(btnEmailInputContinue);
        return this;
    }

    public LoginPage enterPassword(String password) {
        sendKeysToElement(lblPassword, password);
        return this;
    }

    public HomePage clickSigningContinueBtn() {
        clickElement(btnSigningContinueBtn);
        return new HomePage(driver);
    }

}

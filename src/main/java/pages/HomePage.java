package pages;

import actions.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static pages.LoginPage.startTime;

public class HomePage extends ElementActions {

    private final By txtHomePageTitle = By.xpath("//span[@class='title-text' and text()=' Home ']");
    private final By spaceTable = By.xpath("//tr[@class='space-row ng-star-inserted']");
    private final By txtSpaceName = By.xpath("//div[contains(@class, 'space-title') and contains(text(), 'Space')]");
    private final By txtNavBarEntriesNames = By.xpath("//ul[@class='list-group w-100']/li");
    private final By btnCreateSpace = By.xpath("//button[@class='theme-primary']");
    private final By avgProfilePic = By.xpath("//app-profile-photo[@class='cursor-pointer is-header']");
    private final By btnEnterSpace = By.xpath("//app-pencil-button[@data-name='spaces-manager-enter-space']");
    private final By btnSignOut = By.xpath("//app-pencil-button[@icon='logout']");
    private final By btnConfirmSignOut = By.xpath("//*[@data-name='spaces-logout-confirm']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage validateHomePageUrl() {
        Assert.assertEquals(getPageURL(), homePageUrl, "Home page URL is not matching");
        return this;
    }

    public HomePage validatePageLoadTime() {

        isElementDisplayed(txtHomePageTitle);

        long endTime = System.currentTimeMillis(); // Record end time
        long loadTime = endTime - startTime;
        logger.info("Page loaded within time: {} ms", loadTime);
        System.out.println("Page loaded within time: " + loadTime + " ms");
        Assert.assertTrue(loadTime <= 10000, "Load time exceeded 10000 ms");
        return this;
    }

    public HomePage validateNoOfSpacesAvailable(int spaces) {
        logger.info("No of spaces available: {}", getElementsSize(spaceTable));
        System.out.println("No of spaces available: " + getElementsSize(spaceTable));
        Assert.assertEquals(spaces, getElementsSize(spaceTable), "Spaces available is not matched");
        return this;
    }

    public HomePage validateSpaceName(String spaceName) {
        logger.info("Space name: {}", getElementText(txtSpaceName));
        System.out.println(getElementText(txtSpaceName));
        Assert.assertEquals(getElementText(txtSpaceName), spaceName, "Space name is not matching");
        return this;
    }

    public HomePage validateLeftNavBarEntriesName(String entryName) {
        System.out.println(getElementsText(txtNavBarEntriesNames));
        logger.info("Left navigation bar has entry name {}", getElementsText(txtNavBarEntriesNames));
        Assert.assertTrue(getElementsText(txtNavBarEntriesNames).contains(entryName), "Nav bar entry name is not matching");
        return this;
    }

    public HomePage validateCreateSpaceBtnAvailable() {
        logger.info("Create space button is available: {}", isElementDisplayed(btnCreateSpace));
        Assert.assertTrue(isElementDisplayed(btnCreateSpace), "Create space button is not available");
        return this;
    }

    public HomePage validateProfilePicAvailable() {
        logger.info("Profile picture is available: {}", isElementDisplayed(avgProfilePic));
        Assert.assertTrue(isElementDisplayed(avgProfilePic), "Profile picture is not available");
        return this;
    }

    public SpacesPage enterFirstSpace() {
        clickElement(btnEnterSpace);
        return new SpacesPage(driver);
    }

    public HomePage clickProfilePic() {
        clickElement(avgProfilePic);
        return this;
    }

    public HomePage clickSignOutBtn() {
        clickElement(btnSignOut);
        return this;
    }

    public LoginPage clickConfirmSignOut() {
        clickElement(btnConfirmSignOut);
        return new LoginPage(driver);
    }
}

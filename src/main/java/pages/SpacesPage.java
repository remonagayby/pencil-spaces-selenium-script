package pages;

import actions.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class SpacesPage extends ElementActions {

    Actions actions = new Actions(driver);

    private final By btnPenTool = By.xpath("//button[@data-name='space-toolbar-button-draw']");
    private final By btnMoveTool = By.xpath("//button[@data-name='space-toolbar-button-pan']");
    private final By spaceBoard = By.xpath("//canvas[@class='upper-canvas fabric-canvas']");
    private final By btnTextTool = By.xpath("//button[@data-name='space-toolbar-button-text']");
    private final By btnSpaceMenu = By.xpath("//div[@data-name='space-icon-menu-toggle']");
    private final By btnLeaveSpace = By.xpath("//button[@data-name='space-icon-menu-back-to-home']");

    public SpacesPage(WebDriver driver) {
        super(driver);
    }

    public SpacesPage clickPenTool() {
        isElementDisplayed(btnSpaceMenu);
        clickElement(btnPenTool);
        return this;
    }

    public SpacesPage clickHandMoveTool() {
        clickElement(btnMoveTool);
        return this;
    }

    public SpacesPage clickInsertTxtTool() {
        clickElement(btnTextTool);
        return this;
    }

    public SpacesPage writeTextInsideBoard(String text) {
        sendKeysToElement(btnTextTool, text);
        return this;
    }

    public SpacesPage moveInXYDirections(int xOffset, int yOffset) {
        WebElement space = driver.findElement(spaceBoard);

        actions.moveToElement(space, 100, 100)
                .clickAndHold()
                .moveByOffset(xOffset, yOffset)  // Vertical line of 50px
                .release()
                .build()
                .perform();
        return this;
    }

    public SpacesPage clickSpaceMenuBtn() {
        logger.info("Space menu button is available: {}", isElementDisplayed(btnSpaceMenu));
        clickElement(btnSpaceMenu);
        return this;
    }

    public HomePage clickLeaveSpaceBtn() {
        logger.info("Leave space button is available: {}", isElementDisplayed(btnLeaveSpace));
        clickElement(btnLeaveSpace);
        return new HomePage(driver);
    }
}

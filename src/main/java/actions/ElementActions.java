package actions;

import base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public abstract class ElementActions extends BaseClass {

    public ElementActions(WebDriver driver) {
        super();
    }

    private static final int TIMEOUT = 50;

    private static WebDriverWait getWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
    }

    private static WebElement fluentWait(By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(TIMEOUT))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(Exception.class);

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void clickElement(By locator) {
        try {
            getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
            logger.info("Element Clicked");

        } catch (Exception e) {
            String errorMessage = "Exception while clicking the element: " + e.getMessage();
            logger.error(errorMessage, e);
            throw new RuntimeException(errorMessage, e);
        }
    }

    protected void sendKeysToElement(By locator, String keys) {
        try {
            getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(keys);
            logger.info("Typed {}", keys);
        } catch (Exception e) {
            String errorMessage = "Exception while sending keys to element: " + e.getMessage();
            logger.error(errorMessage, e);
            throw new RuntimeException(errorMessage, e);
        }
    }

    protected boolean isElementDisplayed(By locator) {
        try {
            return fluentWait(locator).isDisplayed();
        } catch (Exception e) {
            String errorMessage = "Exception while checking if element is displayed: " + e.getMessage();
            logger.error(errorMessage, e);
            throw new RuntimeException(errorMessage, e);
        }
    }

    protected String getPageURL() {
        return driver.getCurrentUrl();
    }

    protected String getElementText(By locator) {
        try {
            return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
        } catch (Exception e) {
            String errorMessage = "Exception while retrieving text from element: " + e.getMessage();
            logger.error(errorMessage, e);
            throw new RuntimeException(errorMessage, e);
        }
    }

    protected List<String> getElementsText(By locator) {
        try {
            List<WebElement> list = driver.findElements(locator);
            return list.stream()
                    .map(WebElement::getText)
                    .collect(Collectors.toList());
        } catch (Exception e) {
            String errorMessage = "Exception while retrieving text from elements: " + e.getMessage();
            logger.error(errorMessage, e);
            throw new RuntimeException(errorMessage, e);
        }
    }

    protected int getElementsSize(By locator) {
        try {
            List<WebElement> elements = getWait().until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
            return elements.size();
        } catch (Exception e) {
            String errorMessage = "Exception while retrieving the count of elements: " + e.getMessage();
            logger.error(errorMessage, e);
            throw new RuntimeException(errorMessage, e);
        }
    }
}

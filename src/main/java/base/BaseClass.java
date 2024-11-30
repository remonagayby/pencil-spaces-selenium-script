package base;

import lombok.SneakyThrows;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public abstract class BaseClass {
    public static WebDriver driver;
    public ChromeOptions chromeOptions = new ChromeOptions();
    public FirefoxOptions firefoxOptions = new FirefoxOptions();
    public static Properties properties;
    protected static FileInputStream file;
    public static Logger logger = LogManager.getLogger(BaseClass.class);
    public static String loginPageUrl;
    public static String homePageUrl;

    public void initiateDriver(Properties properties) {
        String browserName = properties.getProperty("browser");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--incognito");
        chromeOptions.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);
        firefoxOptions.addPreference("dom.webnotifications.enabled", false);
        firefoxOptions.addArguments("-private");
        if (browserName.equalsIgnoreCase("chrome"))
            driver = new ChromeDriver(chromeOptions);
        else if (browserName.equalsIgnoreCase("firefox"))
            driver = new FirefoxDriver(firefoxOptions);
        else
            System.out.println(browserName + " is incorrect browser name");

        loginPageUrl = properties.getProperty("loginPageUrl");
        homePageUrl = properties.getProperty("homePageUrl");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(loginPageUrl);
    }

    @SneakyThrows
    public static void initiateProperties() {
        properties = new Properties();
        file = new FileInputStream("src/test/resources/config/config.properties");
        properties.load(file);
    }

    @SneakyThrows
    public static String captureScreenshot(String testCaseName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        String screenshotPath = System.getProperty("user.dir")
                + "/src/test/resources/screenshots/" + testCaseName + ".png";
        FileUtils.copyFile(takesScreenshot.getScreenshotAs(OutputType.FILE), new File(screenshotPath));
        return screenshotPath;
    }
}

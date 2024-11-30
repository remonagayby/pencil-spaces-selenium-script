package tests;

import base.BaseClass;
import lombok.SneakyThrows;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import pages.SpacesPage;
import pages.LoginPage;

public class BaseTest extends BaseClass {
    LoginPage loginPage;
    HomePage homePage;
    SpacesPage spacesPage;

    @BeforeMethod
    public void setUp() {
        initiateProperties();
        initiateDriver(properties);
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        spacesPage = new SpacesPage(driver);
    }

    @AfterMethod
    @SneakyThrows
    public void tearDown() {
        file.close();
        driver.quit();
    }

}

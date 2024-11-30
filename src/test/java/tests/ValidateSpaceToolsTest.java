package tests;

import dataprovider.DataProviderHelper;
import org.testng.annotations.Test;

public class ValidateSpaceToolsTest extends BaseTest {

    @Test(dataProvider = "loginData", dataProviderClass = DataProviderHelper.class)
    public void createNewAccount(String email, String password) {
        loginPage.isTitlePresent()
                .validateWelcomePageUrl()
                .clickContinueWithMail()
                .enterEmailAddress(email)
                .clickContinueBtn()
                .enterPassword(password)
                .clickSigningContinueBtn()
                .validatePageLoadTime()
                .validateHomePageUrl()
                .validateNoOfSpacesAvailable(1)
                .validateSpaceName("My First Space")
                .validateLeftNavBarEntriesName("Home")
                .validateLeftNavBarEntriesName("Schedule")
                .validateCreateSpaceBtnAvailable()
                .validateProfilePicAvailable()
                .enterFirstSpace()
                .clickPenTool()
                .moveInXYDirections(0, 50)
                .clickHandMoveTool()
                .moveInXYDirections(10, 0)
                .clickInsertTxtTool()
                .moveInXYDirections(50, 50)
                .writeTextInsideBoard("This is a test")
                .moveInXYDirections(100, 100)
                .clickSpaceMenuBtn()
                .clickLeaveSpaceBtn()
                .validateProfilePicAvailable()
                .validateHomePageUrl()
                .clickProfilePic()
                .clickSignOutBtn()
                .clickConfirmSignOut()
                .isTitlePresent()
                .validateWelcomePageUrl();
    }
}

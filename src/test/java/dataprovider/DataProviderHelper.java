package dataprovider;

import org.testng.annotations.DataProvider;
import utils.ExcelUtils;

public class DataProviderHelper {

    String filePath = "src/test/resources/testData/loginData.xlsx";
    String sheetName;

    @DataProvider(name = "loginData")
    protected Object[][] getLoginData() {
        sheetName = "Credentials";
        int totalCells = ExcelUtils.getTotalCells(filePath, sheetName, 1);

        Object[][] data = new Object[1][2];
        if (totalCells >= 2) {
            data[0][0] = ExcelUtils.getCellData(filePath, sheetName, 1, 0);
            data[0][1] = ExcelUtils.getCellData(filePath, sheetName, 1, 1);
        }
        return data;
    }

}
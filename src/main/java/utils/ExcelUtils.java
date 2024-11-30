package utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {

    public static int getTotalRows(String filePath, String sheetName) {
        try (FileInputStream file = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(file)) {
            XSSFSheet sheet = workbook.getSheet(sheetName);
            return sheet.getLastRowNum();
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static int getTotalCells(String filePath, String sheetName, int rowNumber) {
        try (FileInputStream file = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(file)) {
            XSSFSheet sheet = workbook.getSheet(sheetName);
            XSSFRow row = sheet.getRow(rowNumber);
            row.iterator();
            return row.getLastCellNum();
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static String getCellData(String filePath, String sheetName, int rowNumber, int colNumber) {
        try (FileInputStream file = new FileInputStream(filePath);
             XSSFWorkbook workbook = new XSSFWorkbook(file)) {
            XSSFSheet sheet = workbook.getSheet(sheetName);
            XSSFRow row = sheet.getRow(rowNumber);
            XSSFCell cell = row.getCell(colNumber);
            return cell != null ? cell.toString() : "";
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}

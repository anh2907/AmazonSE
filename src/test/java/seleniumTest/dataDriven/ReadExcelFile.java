package seleniumTest.dataDriven;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ReadExcelFile {
    XSSFWorkbook work_book;
    XSSFSheet sheet;

    public ReadExcelFile(String excelFilePath) {
        try {
            File src = new File(excelFilePath);
            FileInputStream fis = new FileInputStream(src);
            work_book = new XSSFWorkbook(fis);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getData(String sheetName, int row, int column) {
        sheet = work_book.getSheet(sheetName);
        String data;
        Cell cell=sheet.getRow(row).getCell(column);
        if(cell.getCellType()== CellType.STRING)
            data = cell.getStringCellValue();
        else if(cell.getCellType()==CellType.NUMERIC)
            data = String.valueOf(cell.getNumericCellValue());
        else
            data = sheet.getRow(row).getCell(column).getStringCellValue();
        return data;
    }

    public int getRowCount(String sheetName) {
        int row = work_book.getSheet(sheetName).getLastRowNum();
        row = row + 1;
        return row;
    }
}

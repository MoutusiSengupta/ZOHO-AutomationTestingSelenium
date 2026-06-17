package utilities;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class readxlsdata {
    @DataProvider(name="testdata")

    public String[][] getData(Method m) throws IOException {
        File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testdata.xlsx");
        String excelSheetName = m.getName();
        FileInputStream fis = new FileInputStream(f);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheetName = wb.getSheet(excelSheetName);
        int totalRows= sheetName.getLastRowNum();
        System.out.println(totalRows);
        Row rowCells = sheetName.getRow(0);
        int totalCols= rowCells.getLastCellNum();
        System.out.println(totalCols);
        String testData[][] = new String[totalRows][totalCols];
        DataFormatter df = new DataFormatter();
        for(int i=0; i<=totalRows;i++){
            for(int j=0;j<totalCols;j++){
                testData[i-1][j]=df.formatCellValue(sheetName.getRow(i).getCell(j));
                System.out.println(testData[totalRows][totalCols]);
            }
        }
        return testData;
    }
}

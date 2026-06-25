package utilities;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;

public class readxlsdata {

    public String[] getLoginData() throws Exception {

        File f = new File(
                System.getProperty("user.dir")
                        + "\\src\\test\\resources\\testdata\\testdata.xlsx");

        FileInputStream fis = new FileInputStream(f);

        Workbook wb = WorkbookFactory.create(fis);

        //  your sheet name
        Sheet sheet = wb.getSheet("logintest");

        DataFormatter df = new DataFormatter();

        // Row 1 because row 0 is header
        String username =
                df.formatCellValue(sheet.getRow(1).getCell(0));

        String password =
                df.formatCellValue(sheet.getRow(1).getCell(1));

        wb.close();

        return new String[]{username, password};
    }
}
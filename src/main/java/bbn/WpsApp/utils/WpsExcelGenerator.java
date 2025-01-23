package bbn.WpsApp.utils;

import bbn.WpsApp.entity.Wps;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class WpsExcelGenerator {

    public void generateExcel(Wps wps, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("WPS Specification");

        // Create styles
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

        // Example row
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Number WQR");
        cell.setCellStyle(headerStyle);

        cell = row.createCell(1);
        cell.setCellValue(wps.getId());

        // Add other rows as necessary

        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
        }
        workbook.close();
    }


}

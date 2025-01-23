package bbn.WpsApp.utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelGenerator {

    public void generate() throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("A4 Format");

        // Set up page to fit A4
        sheet.getPrintSetup().setPaperSize(PrintSetup.A4_PAPERSIZE);

        // Set column width (approx. 2.5 cm = ~256*10 width in POI units)
        for (int i = 0; i < 8; i++) {
            sheet.setColumnWidth(i, 256 * 10); // 10 characters wide
        }

        // Create bold border style
        CellStyle borderStyle = workbook.createCellStyle();
        borderStyle.setBorderTop(BorderStyle.THICK);
        borderStyle.setBorderBottom(BorderStyle.THICK);
        borderStyle.setBorderLeft(BorderStyle.THICK);
        borderStyle.setBorderRight(BorderStyle.THICK);
        borderStyle.setAlignment(HorizontalAlignment.CENTER);

        // Create header row and merge cells
        Row row1 = sheet.createRow(0);
        Cell cellA1 = row1.createCell(0);
        cellA1.setCellValue("A1:B1");
        cellA1.setCellStyle(borderStyle);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 1));

        Cell cellC1 = row1.createCell(2);
        cellC1.setCellValue("C1:F1");
        cellC1.setCellStyle(borderStyle);
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 2, 5));

        Cell cellG1 = row1.createCell(6);
        cellG1.setCellValue("G1");
        cellG1.setCellStyle(borderStyle);

        Cell cellH1 = row1.createCell(7);
        cellH1.setCellValue(""); // Leave H1 empty
        cellH1.setCellStyle(borderStyle);

        // Create remaining rows and cells
        for (int i = 1; i < 14; i++) {
            Row row = sheet.createRow(i);
            for (int j = 0; j < 8; j++) {
                Cell cell = row.createCell(j);
                cell.setCellStyle(borderStyle);
                if (i == 1 && j == 0) { // Example for filling a specific cell
                    cell.setCellValue("Data");
                }
            }
        }

        // Write to file
        try (FileOutputStream fos = new FileOutputStream("src/main/resources/A4_Excel_Sheet.xlsx")) {
            workbook.write(fos);
        }

        workbook.close();
        System.out.println("Excel file created successfully!");
    }
}

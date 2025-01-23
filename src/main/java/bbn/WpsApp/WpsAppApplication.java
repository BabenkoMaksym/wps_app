package bbn.WpsApp;

import bbn.WpsApp.utils.ExcelGenerator;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileOutputStream;
import java.io.IOException;

@SpringBootApplication
public class WpsAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(WpsAppApplication.class, args);

		XSSFWorkbook workbook = new XSSFWorkbook();
		// Створення аркуша
		Sheet sheet = workbook.createSheet("Sheet_1");

		// Створення рядка і клітинки
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("Hello");
		row.createCell(1).setCellValue("World");

		// Запис в файл
		try (FileOutputStream fileOut = new FileOutputStream("src/main/resources/example.xlsx")) {
			workbook.write(fileOut);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		try {
			workbook.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

	}

}

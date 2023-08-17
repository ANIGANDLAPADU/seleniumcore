package partice;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class brokenheart {

	public static void main(String[] args) throws IOException {
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\testdata\\myfile.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook();
		Scanner sc = new Scanner(System.in);
		XSSFSheet sheet = wb.createSheet();
		for (int i = 0; i <= 4; i++) {
			XSSFRow rows = sheet.createRow(i);
			for (int j = 0; j < 3; j++) {
				System.out.println("Enter data:");
				String value = sc.next();
				rows.createCell(j).setCellValue(value);

			}
		}
		System.out.println("Writing  done...!");
		wb.write(file);
		wb.close();
		file.close();

	}

}
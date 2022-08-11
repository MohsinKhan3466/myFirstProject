package files;

import  org.apache.poi.xssf.usermodel.XSSFWorkbook;
import  org.apache.poi.xssf.usermodel.XSSFRow;
import  org.apache.poi.xssf.usermodel.XSSFSheet;
import java.io.*;


public class ExcelFileCreation {
    public static void main(String[] args) throws IOException {
        XSSFWorkbook wb = new XSSFWorkbook();
        FileOutputStream fileOut = new FileOutputStream("D:\\com.gradle.j\\src\\main\\java\\files\\UserLog.xlsx");
        System.out.println("Excel File has been created successfully.");
        XSSFSheet sheet = wb.createSheet("UserLog"
        );
        XSSFRow rowhead = sheet.createRow((short)0);
        rowhead.createCell(0).setCellValue("UserName");
        rowhead.createCell(1).setCellValue("Password");
        XSSFRow rowhead1 = sheet.createRow((short)1);
        rowhead1.createCell(0).setCellValue(EmailGenerator.createEmailAddress());
        rowhead1.createCell(1).setCellValue("Test@1234");

        wb.write(fileOut);
        fileOut.close();
        wb.close();
    }

}


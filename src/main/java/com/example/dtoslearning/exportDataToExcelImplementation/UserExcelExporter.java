package com.example.dtoslearning.exportDataToExcelImplementation;

import com.example.dtoslearning.dto.UserDto;
import com.example.dtoslearning.model.User;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.util.List;

public class UserExcelExporter {
    XSSFWorkbook workbook;
    XSSFSheet sheet;

    private List<UserDto> userList;

    public UserExcelExporter(List<UserDto> userList) {
        this.userList = userList;
        workbook = new XSSFWorkbook();
        sheet = workbook.createSheet("Users");
    }
    private void writeHeaderRow(){
        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        Cell cell = row.createCell(0);
        cell.setCellValue("User ID");
        cell.setCellStyle(style);

        cell = row.createCell(1);
        cell.setCellValue("First Name");
        cell.setCellStyle(style);

        cell = row.createCell(2);
        cell.setCellValue("Last Name");
        cell.setCellStyle(style);

        cell = row.createCell(3);
        cell.setCellValue("Email");
        cell.setCellStyle(style);
    }
    private void writeDataRow(){
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (UserDto users : userList) {
            Row row = sheet.createRow(rowCount++);

            Cell cell = row.createCell(0);
            cell.setCellValue(users.getUserId());
            sheet.autoSizeColumn(0);
            cell.setCellStyle(style);

            cell = row.createCell(1);
            cell.setCellValue(users.getFirstName());
            sheet.autoSizeColumn(1);
            cell.setCellStyle(style);

            cell = row.createCell(2);
            cell.setCellValue(users.getLastName());
            sheet.autoSizeColumn(2);
            cell.setCellStyle(style);

            cell = row.createCell(3);
            cell.setCellValue(users.getEmail());
            sheet.autoSizeColumn(3);
            cell.setCellStyle(style);
        }
    }

    public void export(HttpServletResponse response) throws IOException {
        writeHeaderRow();
        writeDataRow();

        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}

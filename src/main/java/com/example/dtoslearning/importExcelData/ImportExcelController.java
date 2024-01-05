package com.example.dtoslearning.importExcelData;

import com.example.dtoslearning.dto.UserDto;
import com.example.dtoslearning.model.User;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ImportExcelController {
    @PostMapping("/import-excel")
    public ResponseEntity<List<UserDto>> importExcelFile(@RequestParam("file") MultipartFile files)throws IOException{
        HttpStatus status = HttpStatus.OK;
        List<UserDto> userList = new ArrayList<>();

        XSSFWorkbook workbook = new XSSFWorkbook(files.getInputStream());
        XSSFSheet workbookSheet =  workbook.getSheetAt(0);

        for (int index=0;index<workbookSheet.getPhysicalNumberOfRows();index++){
            if (index>0){
                UserDto user = new UserDto();
                XSSFRow row = workbookSheet.getRow(index);
                Integer id = (int) row.getCell(0).getNumericCellValue();

                user.setUserId(Long.parseLong(id.toString()));
                user.setFirstName(row.getCell(1).getStringCellValue());
                user.setLastName(row.getCell(2).getStringCellValue());
                user.setEmail(row.getCell(3).getStringCellValue());

                userList.add(user);
            }
        }

        return new ResponseEntity<>(userList,status);
    }
}

package utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {

    public List<Map<String, String>> getData(String excelFilepath, String sheetname) throws IOException{
        FileInputStream fis = new FileInputStream(excelFilepath);
        Workbook wb = new XSSFWorkbook(fis);
        Sheet sheet = wb.getSheet(sheetname);

        List<Map<String,String>> data = new ArrayList<>();
        Row headerRow = sheet.getRow(0);

        for(int i = 0; i< sheet.getPhysicalNumberOfRows(); i++){
            Row currentRow = sheet.getRow(i);
            Map<String, String> rowmap = new LinkedHashMap<>();

            for(int j =0; j< headerRow.getPhysicalNumberOfCells(); j++){

                String header = headerRow.getCell(j).getStringCellValue();
                String value = currentRow.getCell(j) == null ? "" : currentRow.getCell(j).toString();
                rowmap.put(header,value);

            }
            data.add(rowmap);
        }
        wb.close();
        fis.close();
        return data;
    }
}

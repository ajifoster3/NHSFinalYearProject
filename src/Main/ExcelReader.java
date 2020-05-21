package Main;

/*
 * Dependencies: Apache POI Library from http://poi.apache.org/
 */

import java.util.LinkedList;
import java.util.List;

import org.apache.poi.ss.usermodel.*;

/**
 *
 * @author Munawwar
 */
public final class ExcelReader {

    private static Sheet currentSheet;

    private static final ExcelReader INSTANCE = new ExcelReader();

    private ExcelReader(){}

    public static ExcelReader getInstance(){
        return INSTANCE;
    }

    public void setCurrentSheet(Sheet sheet){
        this.currentSheet = sheet;
    }

    public List<String> ExcelHeadersAsList() {
        List<String> csv = new LinkedList<>();
        Row row = currentSheet.getRow(0);
        for (int j = 0; j < row.getLastCellNum(); j++) {
            Cell cell = row.getCell(j);
            if (cell != null) {
                csv.add(cell.toString());
            }
        }
        return csv;
    }

    public List<String> ExcelColumnAsList(String columnHeader){

        List<String> excelHeaders = ExcelHeadersAsList();
        int index = excelHeaders.indexOf(columnHeader);

        List<String> csv = new LinkedList<>();

        for(int i = 1; i < currentSheet.getPhysicalNumberOfRows(); i++){
            Cell cell = currentSheet.getRow(i).getCell(index);
            if (cell != null) {
                csv.add(cell.toString());
            }else{
                csv.add("");
            }
        }

        return csv;
    }
}
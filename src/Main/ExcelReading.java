/*
 * Dependencies: Apache POI Library from http://poi.apache.org/
 */
package Main;

import java.util.LinkedList;
import java.util.List;
import org.apache.poi.ss.usermodel.*;

/**
 *
 * @author Munawwar
 */
public class ExcelReading {

    public static List<String> ExcelHeadersAsList(Sheet sheet) {
        List<String> csv = new LinkedList<>();
        Row row = sheet.getRow(0);
        for (int j = 0; j < row.getLastCellNum(); j++) {
            Cell cell = row.getCell(j);
            if (cell != null) {
                csv.add(cell.toString());
            }
        }
        return csv;
    }
}
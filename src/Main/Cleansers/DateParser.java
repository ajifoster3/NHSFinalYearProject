package Main.Cleansers;

import Main.ExcelReader;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class DateParser {

    private static final String[] formats = {
            "yyyy",
            "yyyy-MM-dd",
            "yyyy/MM/dd",
            "dd-MM-yyyy",
            "dd/MM/yyyy",
            "yyyy-MM-dd HH:mm:ss",
            "yyyy/MM/dd HH:mm:ss",
            "dd-MM-yyyy HH:mm:ss",
            "dd/MM/yyyy HH:mm:ss"
    };


    static  List<LocalDate> getDates(String header, ExcelReader excelReader) {
        List<String> dateList = excelReader.ExcelColumnAsList(header);
        List<LocalDate> parsedDates = new LinkedList<>();
        ZoneId defaultZoneId = ZoneId.systemDefault();
        dateList.forEach(date -> {
            for (String parse : formats) {
                Boolean isDateSet = false;
                DateTimeFormatter format = new DateTimeFormatterBuilder()
                        .appendPattern(parse)
                        .parseDefaulting(ChronoField.MONTH_OF_YEAR, 1)
                        .parseDefaulting(ChronoField.DAY_OF_MONTH, 1)
                        .toFormatter();
                try {
                    parsedDates.add(LocalDate.parse(date, format));
                    break;
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });

        return parsedDates;
    }

}

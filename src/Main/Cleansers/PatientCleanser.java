package Main.Cleansers;

import Main.ExcelReader;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static Main.Cleansers.DateParser.getDates;

class PatientCleanser {

    private ExcelReader excelReader = ExcelReader.getInstance();

    protected List<String> cleansehospitalNumber(String header){
        List<String> hospitalNumbersList = excelReader.ExcelColumnAsList(header);
        return hospitalNumbersList;
    }

    protected List<String> cleansefirstName(String header){
        List<String> firstNameList = excelReader.ExcelColumnAsList(header);
        return firstNameList;
    }

    protected List<String> cleanselastName(String header){
        List<String> lastNameList = excelReader.ExcelColumnAsList(header);
        return lastNameList;
    }

    protected List<LocalDate> cleansedateOfBirth(String header){
        return getDates(header, excelReader);
    }

    protected List<Integer> cleanseage(String header){
        List<String> ageList = excelReader.ExcelColumnAsList(header);
        List<Integer> parsedAgeList = new LinkedList<>();
        ageList.forEach(value -> parsedAgeList.add(Integer.valueOf(value)));
        return parsedAgeList;
    }

    protected List<String> cleansesex(String header){
        List<String> sexList = excelReader.ExcelColumnAsList(header);
        return sexList;
    }

}

package Main.Cleansing;


import Main.Cleansing.CleansingHelpers.ExcelReader;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

class PatientCleanser {

    private ExcelReader excelReader = ExcelReader.getInstance();

    protected List<String> cleansehospitalNumber(String header){
        List<String> hospitalNumbersList = excelReader.ExcelColumnAsList(header);
        int i = 0;
        for (String s : hospitalNumbersList) {
            if(s.matches("-?\\d+(\\.\\d+)?")){
                hospitalNumbersList.set(i, String.valueOf((int)Double.parseDouble(s)));
            }
            i++;
        }
        return hospitalNumbersList;
    }

    protected List<String> cleansefirstName(String header){
        List<String> firstNameList = excelReader.ExcelColumnAsList(header);
        firstNameList.replaceAll(String::trim);
        firstNameList.replaceAll(String::toUpperCase);
        return firstNameList;
    }

    protected List<String> cleanselastName(String header){
        List<String> lastNameList = excelReader.ExcelColumnAsList(header);
        lastNameList.replaceAll(String::trim);
        lastNameList.replaceAll(String::toUpperCase);
        return lastNameList;
    }

    protected List<LocalDate> cleansedateOfBirth(String header){
        return DateParser.getDates(header, excelReader);
    }

    protected List<Integer> cleanseage(String header){
        List<String> ageList = excelReader.ExcelColumnAsList(header);
        List<Integer> parsedAgeList = new LinkedList<>();
        ageList.forEach( value -> {
            if(!value.replaceAll("[^\\.0123456789]","").isEmpty()){
                parsedAgeList.add((int)Double.parseDouble(value.trim().replaceAll("[^\\.0123456789-]","")));
            }
            else{
                parsedAgeList.add(-1);
            }
        } );
        return parsedAgeList;
    }

    protected List<String> cleansesex(String header){
        List<String> sexList = excelReader.ExcelColumnAsList(header);
        sexList.replaceAll(String::trim);
        sexList.replaceAll(String::toUpperCase);
        return sexList;
    }

}

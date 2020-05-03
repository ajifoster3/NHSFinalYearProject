package Main.Cleansers;

import Main.ExcelReader;

import java.util.List;

public class PatientCleanser {

    private ExcelReader excelReader = ExcelReader.getInstance();

    public List<String> cleansehospitalNumber(String header){
        List<String> hospitalNumbersList = excelReader.ExcelColumnAsList(header);
        return hospitalNumbersList;
    }

    public List<String> cleansefirstName(String header){
        List<String> firstNameList = excelReader.ExcelColumnAsList(header);
        return firstNameList;
    }

    public List<String> cleanselastName(String header){
        List<String> lastNameList = excelReader.ExcelColumnAsList(header);
        return lastNameList;
    }

    public List<String> cleansedateOfBirth(String header){
        List<String> dateOfBirthList = excelReader.ExcelColumnAsList(header);
        return dateOfBirthList;
    }

    public List<String> cleanseage(String header){
        List<String> ageList = excelReader.ExcelColumnAsList(header);
        return ageList;
    }

    public List<String> cleansesex(String header){
        List<String> sexList = excelReader.ExcelColumnAsList(header);
        return sexList;
    }

}

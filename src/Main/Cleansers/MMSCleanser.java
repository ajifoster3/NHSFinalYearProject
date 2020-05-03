package Main.Cleansers;

import Main.ExcelReader;

import java.util.List;

public class MMSCleanser {

    private ExcelReader excelReader = ExcelReader.getInstance();

    public List<String> cleansecompleted(String header){
        List<String> completedList = excelReader.ExcelColumnAsList(header);
        return completedList;
    }

    public List<String> cleansemms(String header){
        List<String> mmsList = excelReader.ExcelColumnAsList(header);
        return mmsList;
    }

}

package Main.Cleansers;

import Main.ExcelReader;

import java.util.LinkedList;
import java.util.List;

class MMSCleanser {

    private ExcelReader excelReader = ExcelReader.getInstance();

    protected List<Boolean> cleansecompleted(String header){
        List<String> completedList = excelReader.ExcelColumnAsList(header);
        List<Boolean> cleansedcompletedList = new LinkedList<>();
        completedList.forEach(value -> cleansedcompletedList.add(Boolean.parseBoolean(value)));
        return cleansedcompletedList;
    }

    protected List<String> cleansemms(String header){
        List<String> mmsList = excelReader.ExcelColumnAsList(header);
        return mmsList;
    }

}

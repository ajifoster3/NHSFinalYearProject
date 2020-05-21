package Main.Cleansing;


import Main.ExcelReader;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

class VisitCleanser {

    private ExcelReader excelReader = ExcelReader.getInstance();

    protected List<String> cleansePOID(String header){
        List<String> POIDList = excelReader.ExcelColumnAsList(header);
        List<String> cleansedPOIDList = new LinkedList<>();
        POIDList.forEach( value -> {
            if(!value.isEmpty() && value.matches("-?\\d+(\\.\\d+)?")){
                cleansedPOIDList.add(String.valueOf((int)Double.parseDouble(value.trim())));
            }else{
                cleansedPOIDList.add("");
            }
        });
        return cleansedPOIDList;
    }

    protected List<String> cleansediagnosis(String header){
        List<String> diagnosisList = excelReader.ExcelColumnAsList(header);
        diagnosisList.replaceAll(String::toUpperCase);
        diagnosisList.replaceAll(String::trim);
        diagnosisList.forEach( value -> {
            if(!value.isEmpty() && value.matches("-?\\d+(\\.\\d+)?")){
                diagnosisList.set(diagnosisList.indexOf(value), String.valueOf((int)Double.parseDouble(value.trim())));
            }
        });
        return diagnosisList;
    }

    protected List<String> cleansepatientCategory(String header){
        List<String> patientCategoryList = excelReader.ExcelColumnAsList(header);
        patientCategoryList.replaceAll(String::toUpperCase);
        patientCategoryList.replaceAll(String::trim);
        return patientCategoryList;
    }

    protected List<LocalDate> cleanseadmitDateHos(String header){
        return DateParser.getDates(header, excelReader);
    }

    protected List<LocalDate> cleansedischargeDateHos(String header){
        return DateParser.getDates(header, excelReader);
    }

    protected List<LocalDate> cleanseadmitDateICU(String header){
        return DateParser.getDates(header, excelReader);
    }

    protected List<LocalDate> cleansedischargeDateICU(String header){
        return DateParser.getDates(header, excelReader);
    }

    protected List<Integer> cleanselengthOfStayHosp(String header){
        List<String> lengthOfStayHosp = excelReader.ExcelColumnAsList(header);
        List<Integer> cleansedlengthOfStayHosp = new LinkedList<>();
        lengthOfStayHosp.forEach( value -> {
            if(!value.isEmpty()){
                cleansedlengthOfStayHosp.add((int)Double.parseDouble(value.replaceAll("[^\\.0123456789]","")));
            }else{
                cleansedlengthOfStayHosp.add(-1);
            }
        });
        return cleansedlengthOfStayHosp;
    }

    protected List<Integer> cleanselengthOfStayICU(String header){
        List<String> lengthOfStayICUList = excelReader.ExcelColumnAsList(header);
        List<Integer> cleansedlengthOfStayICUList = new LinkedList<>();
        lengthOfStayICUList.forEach( value -> {
            if(!value.isEmpty()){
                cleansedlengthOfStayICUList.add((int)Double.parseDouble(value.replaceAll("[^\\.0123456789]","")));
            }else{
                cleansedlengthOfStayICUList.add(-1);
            }
        });
        return cleansedlengthOfStayICUList;

    }

    protected List<String> cleanseadmitType(String header){
        List<String> admitTypeList = excelReader.ExcelColumnAsList(header);
        admitTypeList.replaceAll(String::toUpperCase);
        return admitTypeList;
    }

    protected List<String> cleanseadmitFrom(String header){
        List<String> admitFromList = excelReader.ExcelColumnAsList(header);
        admitFromList.replaceAll(String::toUpperCase);
        return admitFromList;
    }

    protected List<String> cleansedependencyPreAdmit(String header){
        List<String> dependencyPreAdmitList = excelReader.ExcelColumnAsList(header);
        dependencyPreAdmitList.replaceAll(String::toUpperCase);
        return dependencyPreAdmitList;
    }

    protected List<String> cleansepastMedicalHistory(String header){
        List<String> pastMedicalHistoryList = excelReader.ExcelColumnAsList(header);
        pastMedicalHistoryList.replaceAll(String::toUpperCase);
        return pastMedicalHistoryList;
    }

    protected List<String> cleansehistory(String header){
        List<String> historyList = excelReader.ExcelColumnAsList(header);
        historyList.replaceAll(String::toUpperCase);
        return historyList;
    }

    protected List<Boolean> cleanseoutcome(String header){
        List<String> outcomeList = excelReader.ExcelColumnAsList(header);
        List<Boolean> cleansedoutcomeList = new LinkedList<>();
        outcomeList.forEach(fitForPhysio -> cleansedoutcomeList.add(Boolean.parseBoolean(fitForPhysio)));
        return cleansedoutcomeList;
    }

}

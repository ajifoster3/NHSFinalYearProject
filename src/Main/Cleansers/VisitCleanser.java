package Main.Cleansers;

import Main.ExcelReader;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static Main.Cleansers.DateParser.getDates;

class VisitCleanser {

    private ExcelReader excelReader = ExcelReader.getInstance();

    protected List<String> cleansePOID(String header){
        List<String> POIDList = excelReader.ExcelColumnAsList(header);
        return POIDList;
    }

    protected List<String> cleansediagnosis(String header){
        List<String> diagnosisList = excelReader.ExcelColumnAsList(header);
        return diagnosisList;
    }

    protected List<String> cleansepatientCategory(String header){
        List<String> patientCategoryList = excelReader.ExcelColumnAsList(header);
        return patientCategoryList;
    }

    protected List<LocalDate> cleanseadmitDateHos(String header){
        return getDates(header, excelReader);
    }

    protected List<LocalDate> cleansedischargeDateHos(String header){
        return getDates(header, excelReader);
    }

    protected List<LocalDate> cleanseadmitDateICU(String header){
        return getDates(header, excelReader);
    }

    protected List<LocalDate> cleansedischargeDateICU(String header){
        return getDates(header, excelReader);
    }

    protected List<Integer> cleanselengthOfStayHosp(String header){
        List<String> lengthOfStayHosp = excelReader.ExcelColumnAsList(header);
        List<Integer> cleansedlengthOfStayHosp = new LinkedList<>();
        lengthOfStayHosp.forEach( value -> cleansedlengthOfStayHosp.add(Integer.valueOf(value)) );
        return cleansedlengthOfStayHosp;
    }

    protected List<Integer> cleanselengthOfStayICU(String header){
        List<String> lengthOfStayICUList = excelReader.ExcelColumnAsList(header);
        List<Integer> cleansedlengthOfStayICUList = new LinkedList<>();
        lengthOfStayICUList.forEach( value -> cleansedlengthOfStayICUList.add(Integer.valueOf(value)) );
        return cleansedlengthOfStayICUList;

    }

    protected List<String> cleanseadmitType(String header){
        List<String> admitTypeList = excelReader.ExcelColumnAsList(header);
        return admitTypeList;
    }

    protected List<String> cleanseadmitFrom(String header){
        List<String> admitFromList = excelReader.ExcelColumnAsList(header);
        return admitFromList;
    }

    protected List<String> cleansedependencyPreAdmit(String header){
        List<String> dependencyPreAdmitList = excelReader.ExcelColumnAsList(header);
        return dependencyPreAdmitList;
    }

    protected List<String> cleansepastMedicalHistory(String header){
        List<String> pastMedicalHistoryList = excelReader.ExcelColumnAsList(header);
        return pastMedicalHistoryList;
    }

    protected List<String> cleansehistory(String header){
        List<String> historyList = excelReader.ExcelColumnAsList(header);
        return historyList;
    }

    protected List<Boolean> cleanseoutcome(String header){
        List<String> outcomeList = excelReader.ExcelColumnAsList(header);
        List<Boolean> cleansedoutcomeList = new LinkedList<>();
        outcomeList.forEach(fitForPhysio -> cleansedoutcomeList.add(Boolean.parseBoolean(fitForPhysio)));
        return cleansedoutcomeList;
    }

}

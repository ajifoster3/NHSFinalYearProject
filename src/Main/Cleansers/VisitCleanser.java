package Main.Cleansers;

import Main.ExcelReader;

import java.util.List;

public class VisitCleanser {

    private ExcelReader excelReader = ExcelReader.getInstance();

    public List<String> cleansePOID(String header){
        List<String> POIDList = excelReader.ExcelColumnAsList(header);
        return POIDList;
    }

    public List<String> cleansediagnosis(String header){
        List<String> diagnosisList = excelReader.ExcelColumnAsList(header);
        return diagnosisList;
    }

    public List<String> cleansepatientCategory(String header){
        List<String> patientCategoryList = excelReader.ExcelColumnAsList(header);
        return patientCategoryList;
    }

    public List<String> cleanseadmitDateHos(String header){
        List<String> admitDateHosList = excelReader.ExcelColumnAsList(header);
        return admitDateHosList;
    }

    public List<String> cleansedischargeDateHos(String header){
        List<String> dischargeDateHosList = excelReader.ExcelColumnAsList(header);
        return dischargeDateHosList;
    }

    public List<String> cleanseadmitDateICU(String header){
        List<String> admitDateICUList = excelReader.ExcelColumnAsList(header);
        return admitDateICUList;
    }

    public List<String> cleansedischargeDateICU(String header){
        List<String> dischargeDateICUList = excelReader.ExcelColumnAsList(header);
        return dischargeDateICUList;
    }

    public List<String> cleanselengthOfStayHosp(String header){
        List<String> lengthOfStayHospList = excelReader.ExcelColumnAsList(header);
        return lengthOfStayHospList;
    }

    public List<String> cleanselengthOfStayICU(String header){
        List<String> lengthOfStayICUList = excelReader.ExcelColumnAsList(header);
        return lengthOfStayICUList;
    }

    public List<String> cleanseadmitType(String header){
        List<String> admitTypeList = excelReader.ExcelColumnAsList(header);
        return admitTypeList;
    }

    public List<String> cleanseadmitFrom(String header){
        List<String> admitFromList = excelReader.ExcelColumnAsList(header);
        return admitFromList;
    }

    public List<String> cleansedependencyPreAdmit(String header){
        List<String> dependencyPreAdmitList = excelReader.ExcelColumnAsList(header);
        return dependencyPreAdmitList;
    }

    public List<String> cleansepastMedicalHistory(String header){
        List<String> pastMedicalHistoryList = excelReader.ExcelColumnAsList(header);
        return pastMedicalHistoryList;
    }

    public List<String> cleansehistory(String header){
        List<String> historyList = excelReader.ExcelColumnAsList(header);
        return historyList;
    }

    public List<String> cleanseoutcome(String header){
        List<String> outcomeList = excelReader.ExcelColumnAsList(header);
        return outcomeList;
    }

}

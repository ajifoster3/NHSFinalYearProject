package Main.Cleansers;

import Main.ExcelReader;

import java.util.List;

public class RecordCleanser {

    private ExcelReader excelReader = ExcelReader.getInstance();

    public List<String> cleansedate(String header){
        List<String> dateList = excelReader.ExcelColumnAsList(header);
        return dateList;
    }

    public List<String> cleansebreathing(String header){
        List<String> breathingList = excelReader.ExcelColumnAsList(header);
        return breathingList;
    }

    public List<String> cleansecirculation(String header){
        List<String> circulationList = excelReader.ExcelColumnAsList(header);
        return circulationList;
    }

    public List<String> cleansedurationOfSession(String header){
        List<String> durationOfSessionList = excelReader.ExcelColumnAsList(header);
        return durationOfSessionList;
    }

    public List<String> cleansecomprehensiveRehab(String header){
        List<String> comprehensiveRehabList = excelReader.ExcelColumnAsList(header);
        return comprehensiveRehabList;
    }

    public List<String> cleansefitnessToParticipate(String header){
        List<String> fitnessToParticipateList = excelReader.ExcelColumnAsList(header);
        return fitnessToParticipateList;
    }

    public List<String> cleansedelirium(String header){
        List<String> deliriumList = excelReader.ExcelColumnAsList(header);
        return deliriumList;
    }

    public List<String> cleanseipat(String header){
        List<String> ipatList = excelReader.ExcelColumnAsList(header);
        return ipatList;
    }

    public List<String> cleansefitForPhysio(String header){
        List<String> fitForPhysioList = excelReader.ExcelColumnAsList(header);
        return fitForPhysioList;
    }

    public List<String> cleanserassHigh(String header){
        List<String> rassHighList = excelReader.ExcelColumnAsList(header);
        return rassHighList;
    }

    public List<String> cleanserassLow(String header){
        List<String> rassLowList = excelReader.ExcelColumnAsList(header);
        return rassLowList;
    }

}

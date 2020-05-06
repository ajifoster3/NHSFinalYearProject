package Main.Cleansers;

import Main.ExcelReader;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static Main.Cleansers.DateParser.getDates;

class RecordCleanser {

    private ExcelReader excelReader = ExcelReader.getInstance();

    protected List<LocalDate> cleansedate(String header){
        return getDates(header, excelReader);
    }

    protected List<String> cleansebreathing(String header){
        List<String> breathingList = excelReader.ExcelColumnAsList(header);
        return breathingList;
    }

    protected List<String> cleansecirculation(String header){
        List<String> circulationList = excelReader.ExcelColumnAsList(header);
        return circulationList;
    }

    protected List<String> cleansedurationOfSession(String header){
        List<String> durationOfSessionList = excelReader.ExcelColumnAsList(header);
        return durationOfSessionList;
    }

    protected List<String> cleansecomprehensiveRehab(String header){
        List<String> comprehensiveRehabList = excelReader.ExcelColumnAsList(header);
        return comprehensiveRehabList;
    }

    protected List<String> cleansefitnessToParticipate(String header){
        List<String> fitnessToParticipateList = excelReader.ExcelColumnAsList(header);
        return fitnessToParticipateList;
    }

    protected List<String> cleansedelirium(String header){
        List<String> deliriumList = excelReader.ExcelColumnAsList(header);
        return deliriumList;
    }

    protected List<String> cleanseipat(String header){
        List<String> ipatList = excelReader.ExcelColumnAsList(header);
        return ipatList;
    }

    protected List<Boolean> cleansefitForPhysio(String header){
        List<String> fitForPhysioList = excelReader.ExcelColumnAsList(header);
        List<Boolean> cleansedFitForPhysioList = new LinkedList<>();
        fitForPhysioList.forEach(value -> cleansedFitForPhysioList.add(Boolean.parseBoolean(value)));
        return cleansedFitForPhysioList;
    }

    protected List<Integer> cleanserassHigh(String header){
        List<String> rassHighList = excelReader.ExcelColumnAsList(header);
        List<Integer> cleansedrassHighList = new LinkedList<>();
        rassHighList.forEach( value -> cleansedrassHighList.add(Integer.valueOf(value)) );
        return cleansedrassHighList;
    }

    protected List<Integer> cleanserassLow(String header){
        List<String> rassLowList = excelReader.ExcelColumnAsList(header);
        List<Integer> cleansedrassLowList = new LinkedList<>();
        rassLowList.forEach( value -> cleansedrassLowList.add(Integer.valueOf(value)) );
        return cleansedrassLowList;
    }

}

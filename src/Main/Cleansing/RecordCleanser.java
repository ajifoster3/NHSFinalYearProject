package Main.Cleansing;


import Main.ExcelReader;
import Main.Cleansing.CleansingHelpers.RASSHelper;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class RecordCleanser {

    private ExcelReader excelReader = ExcelReader.getInstance();

    protected List<LocalDate> cleansedate(String header){
        return DateParser.getDates(header, excelReader);
    }

    protected List<String> cleansebreathing(String header){
        List<String> breathingList = excelReader.ExcelColumnAsList(header);
        breathingList.replaceAll(String::trim);
        breathingList.replaceAll(String::toUpperCase);
        return breathingList;
    }

    protected List<String> cleansecirculation(String header){
        List<String> circulationList = excelReader.ExcelColumnAsList(header);
        circulationList.replaceAll(String::trim);
        circulationList.replaceAll(String::toUpperCase);
        return circulationList;
    }

    protected List<String> cleansedurationOfSession(String header){
        List<String> durationOfSessionList = excelReader.ExcelColumnAsList(header);
        durationOfSessionList.replaceAll(String::trim);
        durationOfSessionList.replaceAll(String::toUpperCase);
        return durationOfSessionList;
    }

    protected List<String> cleansecomprehensiveRehab(String header){
        List<String> comprehensiveRehabList = excelReader.ExcelColumnAsList(header);
        comprehensiveRehabList.replaceAll(String::trim);
        comprehensiveRehabList.replaceAll(String::toUpperCase);
        return comprehensiveRehabList;
    }

    protected List<String> cleansefitnessToParticipate(String header){
        List<String> fitnessToParticipateList = excelReader.ExcelColumnAsList(header);
        fitnessToParticipateList.replaceAll(String::trim);
        fitnessToParticipateList.replaceAll(String::toUpperCase);
        fitnessToParticipateList.forEach(s -> {
            if(s.matches("-?\\d+(\\.\\d+)?")){
                fitnessToParticipateList.set(fitnessToParticipateList.indexOf(s), String.valueOf((int) Double.parseDouble(s)));
            }
        });
        return fitnessToParticipateList;
    }

    protected List<String> cleansedelirium(String header){
        List<String> deliriumList = excelReader.ExcelColumnAsList(header);
        deliriumList.replaceAll(String::trim);
        deliriumList.replaceAll(String::toUpperCase);
        return deliriumList;
    }

    protected List<String> cleanseipat(String header){
        List<String> ipatList = excelReader.ExcelColumnAsList(header);
        ipatList.replaceAll(String::trim);
        ipatList.replaceAll(String::toUpperCase);
        return ipatList;
    }

    protected List<Boolean> cleansefitForPhysio(String header){
        List<String> fitForPhysioList = excelReader.ExcelColumnAsList(header);
        List<Boolean> cleansedFitForPhysioList = new LinkedList<>();
        for (String value : fitForPhysioList) {
            if(value.toUpperCase().contains("YES")){
                cleansedFitForPhysioList.add(true);
            }else{
                cleansedFitForPhysioList.add(false);
            }
        }
        return cleansedFitForPhysioList;
    }

    protected List<RASSHelper> cleanserass(String header){
        List<String> rassList = excelReader.ExcelColumnAsList(header);
        List<RASSHelper> cleansedRassList = new LinkedList<>();
        rassList.forEach( value -> {
            List<String> csvrass = Arrays.asList(value.split("[\\ ,/]+"));
            List<Integer> rassAsInt = new LinkedList<>();
            csvrass.forEach( csvValue ->
            {
                if(csvValue.matches("-?\\d+(\\.\\d+)?"))
                    rassAsInt.add((int)Double.parseDouble(csvValue));
            });
            RASSHelper rass;
            if(!rassAsInt.isEmpty()) {
                rass = new RASSHelper(Collections.min(rassAsInt), Collections.max(rassAsInt));
            }else{
                rass = new RASSHelper(-99, -99);
            }
            cleansedRassList.add(rass);
        });
        return cleansedRassList;
    }

}

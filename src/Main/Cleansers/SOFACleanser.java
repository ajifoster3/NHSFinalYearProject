package Main.Cleansers;

import Main.ExcelReader;

import java.util.LinkedList;
import java.util.List;

class SOFACleanser {

    private ExcelReader excelReader = ExcelReader.getInstance();

    protected List<Integer> cleanserespiratoryScore(String header){
        List<String> respiratoryScoreList = excelReader.ExcelColumnAsList(header);
        List<Integer> cleansedrespiratoryScoreList = new LinkedList<>();
        respiratoryScoreList.forEach( value -> cleansedrespiratoryScoreList.add(Integer.valueOf(value)) );
        return cleansedrespiratoryScoreList;
    }

    protected List<Integer> cleansenervousScore(String header){
        List<String> nervousScoreList = excelReader.ExcelColumnAsList(header);
        List<Integer> cleansednervousScoreList = new LinkedList<>();
        nervousScoreList.forEach( value -> cleansednervousScoreList.add(Integer.valueOf(value)) );
        return cleansednervousScoreList;
    }

    protected List<Integer> cleansecardiovascularScore(String header){
        List<String> cardiovascularScoreList = excelReader.ExcelColumnAsList(header);
        List<Integer> cleansedcardiovascularScoreList = new LinkedList<>();
        cardiovascularScoreList.forEach( value -> cleansedcardiovascularScoreList.add(Integer.valueOf(value)) );
        return cleansedcardiovascularScoreList;
    }

    protected List<Integer> cleanseliverScore(String header){
        List<String> liverScoreList = excelReader.ExcelColumnAsList(header);
        List<Integer> cleansedliverScoreList = new LinkedList<>();
        liverScoreList.forEach( value -> cleansedliverScoreList.add(Integer.valueOf(value)) );
        return cleansedliverScoreList;
    }

    protected List<Integer> cleansecoagulationScore(String header){
        List<String> coagulationScoreList = excelReader.ExcelColumnAsList(header);
        List<Integer> cleansedcoagulationScoreList = new LinkedList<>();
        coagulationScoreList.forEach( value -> cleansedcoagulationScoreList.add(Integer.valueOf(value)) );
        return cleansedcoagulationScoreList;
    }

    protected List<Integer> cleansekidneyScore(String header){
        List<String> kidneyScoreList = excelReader.ExcelColumnAsList(header);
        List<Integer> cleansedkidneyScoreList = new LinkedList<>();
        kidneyScoreList.forEach( value -> cleansedkidneyScoreList.add(Integer.valueOf(value)) );
        return cleansedkidneyScoreList;
    }

}

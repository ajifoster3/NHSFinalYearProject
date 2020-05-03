package Main.Cleansers;

import Main.ExcelReader;

import java.util.List;

public class SOFACleanser {

    private ExcelReader excelReader = ExcelReader.getInstance();

    public List<String> cleanserespiratoryScore(String header){
        List<String> respiratoryScoreList = excelReader.ExcelColumnAsList(header);
        return respiratoryScoreList;
    }

    public List<String> cleansenervousScore(String header){
        List<String> nervousScoreList = excelReader.ExcelColumnAsList(header);
        return nervousScoreList;
    }

    public List<String> cleansecardiovascularScore(String header){
        List<String> cardiovascularScoreList = excelReader.ExcelColumnAsList(header);
        return cardiovascularScoreList;
    }

    public List<String> cleanseliverScore(String header){
        List<String> liverScoreList = excelReader.ExcelColumnAsList(header);
        return liverScoreList;
    }

    public List<String> cleansecoagulationScore(String header){
        List<String> coagulationScoreList = excelReader.ExcelColumnAsList(header);
        return coagulationScoreList;
    }

    public List<String> cleansekidneyScore(String header){
        List<String> kidneyScoreList = excelReader.ExcelColumnAsList(header);
        return kidneyScoreList;
    }

}
